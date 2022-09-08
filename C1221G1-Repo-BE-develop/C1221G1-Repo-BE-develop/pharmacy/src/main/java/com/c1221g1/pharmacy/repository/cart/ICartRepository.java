package com.c1221g1.pharmacy.repository.cart;

import com.c1221g1.pharmacy.dto.cart.CustomerDtoForCart;
import com.c1221g1.pharmacy.entity.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ICartRepository extends JpaRepository<Cart, Integer> {
    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: finding cart object by customer id and cart status
     *
     * @param customerId
     * @param status
     * @return cart object
     */
    @Query(value = "SELECT cart_id, cart_status, date_create, customer_id, discount_id\n" +
            "FROM cart\n" +
            "WHERE customer_id = :customer_id AND cart_status = :status", nativeQuery = true)
    Cart findCartByCustomerId(@Param("customer_id") String customerId, @Param("status") Boolean status);

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: execute sql query save new cart object into database
     *
     * @param cart
     */
    @Query(value = "INSERT INTO cart (cart_status, date_create, customer_id) " +
            "VALUES (:#{#cart.cartStatus},:#{#cart.dateCreate},:#{#cart.customer.customerId})", nativeQuery = true)
    void saveCart(@Param("cart") Cart cart);

    /**
     * Created by: KhoaPV
     * Date created: 30/6/2022
     * function: Update cart status to true (complete)
     *
     * @param cart
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE cart\n" +
            "SET cart_status = TRUE\n" +
            "WHERE cart_id = :id", nativeQuery = true)
    void setCartCompleted(@Param("id") Integer cartId);

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: finding cart object by cart id and cart status
     *
     * @param customerId
     * @param status
     * @return cart object
     */
    @Query(value = "SELECT cart_id, cart_status, date_create, customer_id, discount_id\n" +
            "FROM cart\n" +
            "WHERE cart_id = :cart_id AND cart_status = :status", nativeQuery = true)
    Cart findCartById(@Param("cart_id") Integer cartId, @Param("status") Boolean status);

    /**
     * Created by: KhoaPV
     * Date created: 29/6/2022
     * function: Count how may item in cart of customer object
     *
     * @param cartId
     * @param status
     * @return
     */
    @Query(value = "SELECT count(*)\n" +
            "FROM cart_detail cd\n" +
            "         JOIN cart c ON cd.cart_id = c.cart_id\n" +
            "WHERE c.customer_id = :customer_id\n" +
            "  AND c.cart_status = :status\n" +
            "GROUP BY c.cart_id", nativeQuery = true)
    Integer countItemInCart(@Param("customer_id") String customerId, @Param("status") Boolean status);
}
