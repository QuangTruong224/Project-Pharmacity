package com.c1221g1.pharmacy.entity.cart;

import com.c1221g1.pharmacy.entity.medicine.Medicine;
import javax.persistence.*;

@Entity
@Table(name = "cart_detail", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "CART_MEDICINE_UK", columnNames = {"medicine_id", "cart_id"})})
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartDetailId;
    private Integer cartDetailQuantity;
    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "medicineId")
    private Medicine medicine;
    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cartId")
    private Cart cart;

    public CartDetail() {
    }

    public Integer getCartDetailId() {
        return cartDetailId;
    }

    public void setCartDetailId(Integer cartDetailId) {
        this.cartDetailId = cartDetailId;
    }

    public Integer getCartDetailQuantity() {
        return cartDetailQuantity;
    }

    public void setCartDetailQuantity(Integer cartDetailQuantity) {
        this.cartDetailQuantity = cartDetailQuantity;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
