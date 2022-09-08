package com.c1221g1.pharmacy.dto.report;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "medicineId", "medicineName", "quantity", "expiredDate"})
public interface MedicineBeAboutExpired {
    String getMedicineId();
    String getMedicineName();
    String getQuantity();
    String getExpiredDate();
}
