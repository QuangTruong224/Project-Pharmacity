package com.c1221g1.pharmacy.dto.cart;

public class CustomerDtoForCart {
    private String customerId;
    private String customerName;
    private String customerUserName;
    private String customerPhone;
    private String customerAddress;
    private String uuidChat;

    public String getUuidChat() {
        return uuidChat;
    }

    public void setUuidChat(String uuidChat) {
        this.uuidChat = uuidChat;
    }

    public CustomerDtoForCart() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
