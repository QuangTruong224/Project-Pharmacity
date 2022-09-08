package com.c1221g1.pharmacy.dto.invoice;

import java.util.List;
/*
 * Created by DaLQA
 * Time: 7:30 PM 29/06/2022
 * Function:  InvoiceDto
 * */
public class InvoiceDto {
    private String invoiceId;
    private String customerId;
    private String employeeId;
    private Integer typeOfInvoiceId;
    private String invoiceNote;
    private List<InvoiceMedicineDto> invoiceMedicineList;

    public InvoiceDto() {
    }

    public Integer getTypeOfInvoiceId() {
        return typeOfInvoiceId;
    }

    public void setTypeOfInvoiceId(Integer typeOfInvoiceId) {
        this.typeOfInvoiceId = typeOfInvoiceId;
    }

    public String getInvoiceNote() {
        return invoiceNote;
    }

    public void setInvoiceNote(String invoiceNote) {
        this.invoiceNote = invoiceNote;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public List<InvoiceMedicineDto> getInvoiceMedicineList() {
        return invoiceMedicineList;
    }

    public void setInvoiceMedicineList(List<InvoiceMedicineDto> invoiceMedicineList) {
        this.invoiceMedicineList = invoiceMedicineList;
    }
}