package com.c1221g1.pharmacy.service.cart.impl;

import com.c1221g1.pharmacy.entity.cart.Discount;
import com.c1221g1.pharmacy.repository.cart.IDiscountReopsitory;
import com.c1221g1.pharmacy.service.cart.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService implements IDiscountService {
    @Autowired
    private IDiscountReopsitory iDiscountReopsitory;

    /**
     * created by: KhoaPV
     * function: select discount from database
     *
     * @param discountId
     * @return
     */
    @Override
    public Discount getDiscount(String discountId) {
        return this.iDiscountReopsitory.getDiscount(discountId);
    }
}
