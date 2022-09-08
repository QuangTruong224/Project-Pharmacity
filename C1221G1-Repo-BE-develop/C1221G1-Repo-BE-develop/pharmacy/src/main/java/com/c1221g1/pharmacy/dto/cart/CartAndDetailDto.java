package com.c1221g1.pharmacy.dto.cart;

import com.c1221g1.pharmacy.entity.cart.Discount;


import java.util.List;

public class CartAndDetailDto {
    private Integer id;
    private Discount discount;
    private CustomerDtoForCart customer;
    private String dateCreate;
    private List<CartDetailDto> cartDetail;

    public CartAndDetailDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public CustomerDtoForCart getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDtoForCart customer) {
        this.customer = customer;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public List<CartDetailDto> getCartDetail() {
        return cartDetail;
    }

    public void setCartDetail(List<CartDetailDto> cartDetail) {
        this.cartDetail = cartDetail;
    }

    @Override
    public String toString() {
        return "CartAndDetailDto{" +
                "id=" + id +
                ", discount=" + discount +
                ", customer=" + customer +
                ", dateCreate='" + dateCreate + '\'' +
                ", cartDetail=" + cartDetail +
                '}';
    }
}
