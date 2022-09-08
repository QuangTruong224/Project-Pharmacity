package com.c1221g1.pharmacy.dto.prescription;

import com.c1221g1.pharmacy.entity.medicine.Medicine;
import com.c1221g1.pharmacy.entity.prescription.Prescription;


public class MedicinePrescriptionDto {
    private Integer medicinePrescriptionId;
    private Integer medicinePrescriptionTimes;
    private Integer medicinePrescriptionNumberPerTime;
    private Prescription prescription;
    private Medicine medicine;

    public MedicinePrescriptionDto() {
    }

    public Integer getMedicinePrescriptionId() {
        return medicinePrescriptionId;
    }

    public void setMedicinePrescriptionId(Integer medicinePrescriptionId) {
        this.medicinePrescriptionId = medicinePrescriptionId;
    }

    public Integer getMedicinePrescriptionTimes() {
        return medicinePrescriptionTimes;
    }

    public void setMedicinePrescriptionTimes(Integer medicinePrescriptionTimes) {
        this.medicinePrescriptionTimes = medicinePrescriptionTimes;
    }

    public Integer getMedicinePrescriptionNumberPerTime() {
        return medicinePrescriptionNumberPerTime;
    }

    public void setMedicinePrescriptionNumberPerTime(Integer medicinePrescriptionNumberPerTime) {
        this.medicinePrescriptionNumberPerTime = medicinePrescriptionNumberPerTime;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}