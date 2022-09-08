package com.c1221g1.pharmacy.dto.import_invoice;

public interface ISupplierDto {
    String getSupplierId();

    String getSupplierName();

    String getSupplierAddress();

    String getSupplierPhone();

    String getSupplierEmail();

    String getNote();

    boolean getFlag();

    Double getDebt();
}
