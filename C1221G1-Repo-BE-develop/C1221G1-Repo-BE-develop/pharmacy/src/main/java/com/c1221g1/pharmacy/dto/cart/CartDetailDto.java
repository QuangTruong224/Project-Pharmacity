package com.c1221g1.pharmacy.dto.cart;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CartDetailDto implements Validator {
    private Integer quantity;
    private MedicineDtoForCart medicine;

    public CartDetailDto() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public MedicineDtoForCart getMedicine() {
        return medicine;
    }

    public void setMedicine(MedicineDtoForCart medicine) {
        this.medicine = medicine;
    }

    @Override
    public String toString() {
        return "CartDetailDto{" +
                "quantity=" + quantity +
                ", medicine=" + medicine +
                '}';
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CartDetailDto cartDetailDto = (CartDetailDto) target;
    }
}
