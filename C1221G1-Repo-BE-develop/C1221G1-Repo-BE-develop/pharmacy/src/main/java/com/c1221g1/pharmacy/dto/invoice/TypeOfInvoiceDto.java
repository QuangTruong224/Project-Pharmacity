package com.c1221g1.pharmacy.dto.invoice;

import com.c1221g1.pharmacy.entity.invoice.Invoice;

import java.util.List;

public class TypeOfInvoiceDto {
    private Integer typeOfInvoiceId;
    private String typeOfInvoiceName;

    public TypeOfInvoiceDto() {
    }

    public Integer getTypeOfInvoiceId() {
        return typeOfInvoiceId;
    }

    public void setTypeOfInvoiceId(Integer typeOfInvoiceId) {
        this.typeOfInvoiceId = typeOfInvoiceId;
    }

    public String getTypeOfInvoiceName() {
        return typeOfInvoiceName;
    }

    public void setTypeOfInvoiceName(String typeOfInvoiceName) {
        this.typeOfInvoiceName = typeOfInvoiceName;
    }
}
