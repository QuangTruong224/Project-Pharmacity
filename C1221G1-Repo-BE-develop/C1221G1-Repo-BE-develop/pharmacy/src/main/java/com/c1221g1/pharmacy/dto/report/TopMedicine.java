package com.c1221g1.pharmacy.dto.report;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "medicineId", "medicineName", "totalQuantity"})
public interface TopMedicine {
    String getMedicineId();
    String getMedicineName();
    String getTotalQuantity();
}
