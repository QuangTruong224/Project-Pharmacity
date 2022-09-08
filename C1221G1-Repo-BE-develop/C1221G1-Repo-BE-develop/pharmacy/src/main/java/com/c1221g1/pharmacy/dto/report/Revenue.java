package com.c1221g1.pharmacy.dto.report;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "invoiceId", "employeeId", "createdDay", "total", "profit"})
public interface Revenue {
    String getInvoiceId();
    String getCreatedDay();
    String getEmployeeId();
    Double getTotal();
    Double getProfit();
}
