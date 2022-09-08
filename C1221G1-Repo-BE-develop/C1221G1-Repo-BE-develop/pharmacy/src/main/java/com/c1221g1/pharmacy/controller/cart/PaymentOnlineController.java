package com.c1221g1.pharmacy.controller.cart;

import com.c1221g1.pharmacy.dto.cart.PaymentOnlineDto;
import com.c1221g1.pharmacy.dto.cart.PaymentOnlineForLookup;
import com.c1221g1.pharmacy.entity.cart.Discount;
import com.c1221g1.pharmacy.entity.cart.PaymentOnline;
import com.c1221g1.pharmacy.service.cart.IDiscountService;
import com.c1221g1.pharmacy.service.cart.IPaymentOnlineService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/payment-online")
public class PaymentOnlineController {
    @Autowired
    private IPaymentOnlineService iPaymentOnlineService;
    @Autowired
    private IDiscountService iDiscountService;

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: Receive request from client with method get. Find payment online mapping with optional condition search.
     * return all payment online in database if have no optional search key.
     *
     * @param paymentOnlineId
     * @param customerName
     * @param page
     * @param size
     * @return
     */
    @GetMapping("")
    public ResponseEntity<Page<PaymentOnlineForLookup>> getPaymentOnline(@RequestParam Optional<String> paymentOnlineId,
                                                                         @RequestParam Optional<String> customerName,
                                                                         @RequestParam(defaultValue = "0") int page,
                                                                         @RequestParam(defaultValue = "5") int size) {
        String paymentOnlineIdVal = paymentOnlineId.orElse("");
        String customerNameVal = customerName.orElse("");
        Pageable pageable = PageRequest.of(page, size);
        Page<PaymentOnlineForLookup> paymentOnlines = this.iPaymentOnlineService.findAll(paymentOnlineIdVal, customerNameVal, pageable);
        if (paymentOnlines.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paymentOnlines, HttpStatus.OK);
    }

    /**
     * Created by: KhoaPV
     * Date created: 7/7/2022
     * function: get discount id from request of client
     * return discount value if exists.
     *
     * @param id
     * @return
     */
    @GetMapping("/discount/{id}")
    public ResponseEntity<Discount> getDiscount(@PathVariable String id) {
        Discount discount = this.iDiscountService.getDiscount(id);
        if (discount == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(discount, HttpStatus.OK);
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: Save payment after pay with paypal successful.
     * If validate error, throw exception in method handleValidationExceptions.
     *
     * @param paymentOnlineDto
     * @return
     */
    @PostMapping("")
    public ResponseEntity<HttpStatus> savePayment(@Validated @RequestBody PaymentOnlineDto paymentOnlineDto) {
        PaymentOnline paymentOnline = new PaymentOnline();
        BeanUtils.copyProperties(paymentOnlineDto, paymentOnline);
        this.iPaymentOnlineService.save(paymentOnline);
        return new ResponseEntity<>(HttpStatus.OK);
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
