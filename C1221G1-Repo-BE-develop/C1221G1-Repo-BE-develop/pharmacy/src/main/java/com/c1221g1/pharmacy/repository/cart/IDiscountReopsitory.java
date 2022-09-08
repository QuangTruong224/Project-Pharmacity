package com.c1221g1.pharmacy.repository.cart;

import com.c1221g1.pharmacy.entity.cart.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IDiscountReopsitory extends JpaRepository<Discount, String> {
    /**
     * created by: KhoaPV
     * function: select discount from database
     *
     * @param discountId
     * @return
     */
    @Query(value = "SELECT discount_id, discount_value\n" +
            "FROM discount\n" +
            "WHERE discount_id = :discount_id", nativeQuery = true)
    Discount getDiscount(@Param("discount_id") String discountId);
}
