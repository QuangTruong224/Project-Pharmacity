package com.c1221g1.pharmacy.dto.cart;

public interface CartDtoForList {
    Integer getQuantity();

    Double getPrice();

    Integer getCartId();

    String getMedicineImage();

    String getMedicineName();

    Double getDiscount();
}
