package com.c1221g1.pharmacy.service.cart;

import com.c1221g1.pharmacy.dto.cart.CustomerDtoForCart;
import com.c1221g1.pharmacy.entity.cart.Cart;

public interface ICartService {
    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: finding cart object have status false (incomplete) with customer id
     *
     * @param customerId
     * @return
     */
    Cart findCartByCustomerId(String customerId);

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: call repository to save cart object into database
     *
     * @param cart
     * @param customerId
     */
    Cart save(Cart cart, String customerId);

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: call repository to set cart status complete (true).
     *
     * @param cartId
     */
    void setCartComplete(Integer cartId);

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: call repository to count how many items in cart.
     *
     * @param customerId
     * @return totalItems
     */
    Integer countItemInCart(String customerId);

    /**
     * Created by: KhoaPV
     * Date created: 6/7/2022
     * function: call repository to find customerDto by username.
     *
     * @param customerUsername
     * @return totalItems
     */
    CustomerDtoForCart findCustomerByUsername(String customerUsername);
}
