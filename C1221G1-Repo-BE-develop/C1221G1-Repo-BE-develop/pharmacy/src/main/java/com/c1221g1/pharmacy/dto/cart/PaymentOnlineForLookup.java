package com.c1221g1.pharmacy.dto.cart;

public interface PaymentOnlineForLookup {
    String getPaymentId();

    String getDateCreate();

    String getTimeCreate();

    String getCustomerName();

    String getTotalPrice();

    String getNote();
}
