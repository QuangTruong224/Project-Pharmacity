package com.c1221g1.pharmacy.controller.cart;

import com.c1221g1.pharmacy.dto.cart.*;
import com.c1221g1.pharmacy.entity.cart.Cart;
import com.c1221g1.pharmacy.entity.cart.CartDetail;
import com.c1221g1.pharmacy.entity.cart.PaymentOnline;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.service.cart.ICartDetailService;
import com.c1221g1.pharmacy.service.cart.ICartService;
import com.c1221g1.pharmacy.service.cart.IPaymentOnlineService;
import com.c1221g1.pharmacy.service.cart.ISendingEmailService;
import com.c1221g1.pharmacy.service.medicine.IMedicineService;
import com.c1221g1.pharmacy.service.medicine.IMedicineStorageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/api/carts")
public class CartController {
    @Autowired
    private ICartService iCartService;
    @Autowired
    private ICartDetailService iCartDetailService;

    @Autowired
    private IMedicineService iMedicineService;

    @Autowired
    private IPaymentOnlineService iPaymentOnlineService;
    @Autowired
    private ISendingEmailService iSendingEmailService;
    @Autowired
    private IMedicineStorageService iMedicineStorageService;

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: Update item in cart by customer id, item quantity in cart
     * if cart null: create new cart
     *
     * @param cartDetailDto
     * @param bindingResult
     * @return
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateItem(@PathVariable String id,
                                                          @Validated @RequestBody CartDetailDto cartDetailDto,
                                                          BindingResult bindingResult) {
        Cart cart = this.iCartService.findCartByCustomerId(id);
        if (cart == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        new CartDetailDto().validate(cartDetailDto, bindingResult);
        List<CartDetailDto> cartDetailDtos = new ArrayList<>();
        cartDetailDtos.add(cartDetailDto);
        this.iCartDetailService.checkExistOfLinksObject(cartDetailDtos, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        CartDetail cartDetail = new CartDetail();
        BeanUtils.copyProperties(cartDetailDto, cartDetail);
        this.iCartDetailService.updateItemCartDetail(cartDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by: KhoaPV
     * Date created: 1/7/2022
     * function: Get list cart detail of customer by customer id
     *
     * @param id
     * @return
     */
    @GetMapping("/details/{id}")
    public ResponseEntity<List<CartDtoForList>> getListDetail(@PathVariable String id) {
        Cart cart = this.iCartService.findCartByCustomerId(id);
        if (cart == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<CartDtoForList> cartDetails = this.iCartDetailService.getListByCartId(cart.getCartId());
        if (cartDetails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cartDetails, HttpStatus.OK);
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: find cart by customer by id (check customer have cart before)
     * if cart null: create new cart and return cart to client.
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findCartByCustomerId(@PathVariable String id) {
        Map<String, Object> cartResponse = new HashMap<>();
        Cart cart = this.iCartService.findCartByCustomerId(id);
        if (cart == null) {
            Cart newCart = new Cart();
            Cart cartReturn = this.iCartService.save(newCart, id);
            cartResponse.put("cart", cartReturn);
            cartResponse.put("totalItems", 0);
            //create new cart for this customer.
            return new ResponseEntity<>(cartResponse, HttpStatus.OK);
        }
        Integer totalItems = this.iCartService.countItemInCart(id);
        cartResponse.put("cart", cart);
        cartResponse.put("totalItems", totalItems);
        return new ResponseEntity<>(cartResponse, HttpStatus.OK);
    }

    /**
     * Created by: KhoaPV
     * Date created: 4/7/2022
     * function: check cart and details send from client, and return to payment pay if cart valid (cart save at localstorage)
     */
    @PostMapping("")
    public ResponseEntity<CartAndDetailDto> checkCartAndDetailFromClient(@Validated @RequestBody CartAndDetailDto cartAndDetailDto,
                                                                         BindingResult bindingResult) throws MethodArgumentNotValidException {

        this.iCartDetailService.checkExistOfLinksObject(cartAndDetailDto.getCartDetail(), bindingResult);
        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }
        if (cartAndDetailDto.getCustomer() != null) {
            CustomerDtoForCart customerDtoForCart =
                    this.iCartService.findCustomerByUsername(cartAndDetailDto.getCustomer().getCustomerUserName());
            cartAndDetailDto.setCustomer(customerDtoForCart);
        }
        System.out.println(cartAndDetailDto);
        return new ResponseEntity<>(cartAndDetailDto, HttpStatus.OK);
    }

    /**
     * Created by: KhoaPV
     * Date created: 4/7/2022
     * function: save cart and detail after customer pay with paypal (cart save at localstorage)
     */
    @PostMapping("/saveCart")
    public ResponseEntity<HttpStatus> saveCartAndDetail(@RequestBody CartAndDetailDto cartAndDetailDto) {
        Cart cart = new Cart();
        if (cartAndDetailDto.getDiscount() != null) {
            cart.setDiscount(cartAndDetailDto.getDiscount());
        }
        if (cartAndDetailDto.getCustomer().getCustomerId() == null) {
            cart = this.iCartService.save(cart, "KH-00001");
        } else {
            cart = this.iCartService.save(cart, cartAndDetailDto.getCustomer().getCustomerId());
        }
        this.iCartService.setCartComplete(cart.getCartId());
        double total = 0.0;
        for (CartDetailDto cartDetailDto : cartAndDetailDto.getCartDetail()) {
            total += cartDetailDto.getQuantity() * cartDetailDto.getMedicine().getMedicinePrice();
            CartDetail cartDetail = new CartDetail();
            cartDetail.setCartDetailQuantity(cartDetailDto.getQuantity());
            Optional<Medicine> medicine = this.iMedicineService.findMedicineById(cartDetailDto.getMedicine().getMedicineId());
            if (medicine.isPresent()) {
                cartDetail.setMedicine(medicine.get());
            }
            cartDetail.setCart(cart);
            this.iCartDetailService.save(cartDetail);
            this.iMedicineStorageService.changeMedicineQuantity(
                    cartDetail.getMedicine().getMedicineId(),
                    Long.valueOf(cartDetail.getCartDetailQuantity()), 0);
        }
        double discount = 0;
        if (cartAndDetailDto.getDiscount() != null) {
            discount = cartAndDetailDto.getDiscount().getDiscountValue();
        }
        PaymentOnline paymentOnline = new PaymentOnline();
        paymentOnline.setCart(cart);
        this.iPaymentOnlineService.save(paymentOnline);
        try {
            this.iSendingEmailService.sendEmail(cartAndDetailDto, total, discount);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("success");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by: KhoaPV
     * Date created: 6/7/2022
     * function: find customer using cart by username
     */
    @GetMapping("/customer/{customerUsername}")
    public ResponseEntity<CustomerDtoForCart> findCustomerByUsername(@PathVariable String customerUsername) {
        CustomerDtoForCart customer = this.iCartService.findCustomerByUsername(customerUsername);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: exception handle if validate have errors. Return bad request to client and error messages.
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
