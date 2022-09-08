package com.c1221g1.pharmacy.service.cart;

import com.c1221g1.pharmacy.entity.cart.Discount;

public interface IDiscountService {
    /**
     * created by: KhoaPV
     * function: select discount from database
     *
     * @param discountId
     * @return
     */
    Discount getDiscount(String discountId);
}
