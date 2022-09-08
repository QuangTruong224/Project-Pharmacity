package com.c1221g1.pharmacy.entity.cart;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class PaymentOnline {
    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    @GeneratedValue(generator = "payment-id-generator")
    @GenericGenerator(name = "payment-id-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "HDO"),
            strategy = "com.c1221g1.pharmacy.common.IdentityCodeGenerator")
    private String paymentId;
    @JoinColumn(columnDefinition = "DATETIME")
    private String timeCreate;
    private String note;
    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cartId")
    private Cart cart;

    public PaymentOnline() {
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(String timeCreate) {
        this.timeCreate = timeCreate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
