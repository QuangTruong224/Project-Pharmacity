package com.c1221g1.pharmacy.dto.prescription;

public interface IMedicinePrescriptionDto {
    String getPrescriptionId();
    String getPrescriptionName();
//    String getPrescriptionSymptom();
//    String getPrescriptionTargetUser();
//    String getPrescriptionNote();
    Integer getPrescriptionNumberOfDays();
    String getMedicineId();
    String getMedicineName();
    Integer getMedicinePrescriptionTimes();
    Integer getMedicinePrescriptionNumberPerTime();
    Integer getTotalQuantityMedicine();
}
