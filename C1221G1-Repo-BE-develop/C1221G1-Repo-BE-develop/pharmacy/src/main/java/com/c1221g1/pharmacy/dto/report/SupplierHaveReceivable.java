package com.c1221g1.pharmacy.dto.report;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "supplierId", "supplierName", "balance"})
public interface SupplierHaveReceivable {
    String getSupplierId();
    String getSupplierName();
    Double getBalance();
}
