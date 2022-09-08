package com.c1221g1.pharmacy.service.cart.impl;

import com.c1221g1.pharmacy.dto.cart.CustomerDtoForCart;
import com.c1221g1.pharmacy.entity.cart.Cart;
import com.c1221g1.pharmacy.entity.cart.Discount;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.repository.cart.ICartRepository;
import com.c1221g1.pharmacy.service.cart.ICartService;
import com.c1221g1.pharmacy.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository iCartRepository;

    @Autowired
    private ICustomerService iCustomerService;

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: finding cart object have status false (incomplete) with customer id
     *
     * @param customerId
     * @return
     */
    @Override
    public Cart findCartByCustomerId(String customerId) {
        return this.iCartRepository.findCartByCustomerId(customerId, false);
    }

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: call repository to save cart object into database
     *
     * @param cart
     * @param customerId
     */
    @Override
    public Cart save(Cart cart, String customerId) {
        Customer customer = this.iCustomerService.findByCustomerId(customerId);
        System.out.println(customer);
        cart.setCustomer(customer);

        cart.setCartStatus(false);
        cart.setDateCreate(LocalDate.now().toString());
        if (cart.getDiscount() == null) {
            Discount discount = new Discount();
            discount.setDiscountId("1");
            cart.setDiscount(discount);
        }
        return this.iCartRepository.save(cart);
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: call repository to set cart status complete (true).
     *
     * @param cartId
     */
    @Override
    public void setCartComplete(Integer cartId) {
        this.iCartRepository.setCartCompleted(cartId);
    }

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: call repository to count how many items in cart.
     *
     * @param customerId
     * @return totalItems
     */
    @Override
    public Integer countItemInCart(String customerId) {
        return this.iCartRepository.countItemInCart(customerId, false);
    }

    /**
     * Created by: KhoaPV
     * Date created: 6/7/2022
     * function: call repository to find customerDto by username.
     *
     * @param customerUsername
     * @return totalItems
     */
    @Override
    public CustomerDtoForCart findCustomerByUsername(String customerUsername) {
        Customer customer = this.iCustomerService.findCustomerByUsername(customerUsername);
        CustomerDtoForCart customerDtoForCart = new CustomerDtoForCart();
        BeanUtils.copyProperties(customer, customerDtoForCart);
        customerDtoForCart.setCustomerUserName(customer.getCustomerUsername().getUsername());
        return customerDtoForCart;
    }

}
