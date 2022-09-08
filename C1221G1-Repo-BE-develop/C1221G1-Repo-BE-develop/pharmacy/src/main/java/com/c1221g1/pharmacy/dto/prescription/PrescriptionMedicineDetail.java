package com.c1221g1.pharmacy.dto.prescription;

public interface PrescriptionMedicineDetail {
    String getPrescriptionId();
    String getMedicineId();
    String getMedicineName();
    Integer getTimes();
    Integer getNumberPerTime();
    Integer getTotalQuantity();
    Double getRetailPrice();
}
