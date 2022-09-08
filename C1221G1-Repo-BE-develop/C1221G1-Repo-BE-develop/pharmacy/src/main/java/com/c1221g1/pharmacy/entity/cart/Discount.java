package com.c1221g1.pharmacy.entity.cart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@JsonIgnoreProperties({"cartList"})
public class Discount {
    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    private String discountId;
    private Double discountValue;

    @JsonBackReference(value = "cartList")
    @OneToMany(mappedBy = "discount")
    private List<Cart> cartList;

    public Discount() {
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public Double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

}
