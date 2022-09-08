package com.c1221g1.pharmacy.dto.invoice;

public interface IInvoiceDto {
    String getInvoiceId();
    String getCustomerName();
    String getEmployeeName();
    String getTypeOfInvoiceId();
    String getInvoiceNote();
    String getInvoiceCreatedDate();
    String getInvoiceCreateTime();
    String getInvoiceTotalMoney();
}

