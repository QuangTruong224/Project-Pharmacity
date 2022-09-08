package com.c1221g1.pharmacy.dto.report;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "medicineId", "medicineName", "quantity"})
public interface MedicineNeedToImport {
    String getMedicineId();
    String getMedicineName();
    Double getQuantity();

}
