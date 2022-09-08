package com.c1221g1.pharmacy.dto.cart;

public class MedicineDtoForCart {
    private String medicineId;
    private String medicineName;
    private String medicineImage;
    private Double medicinePrice;

    public MedicineDtoForCart() {
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineImage() {
        return medicineImage;
    }

    public void setMedicineImage(String medicineImage) {
        this.medicineImage = medicineImage;
    }

    public Double getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(Double medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    @Override
    public String toString() {
        return "MedicineDtoForCart{" +
                "medicineId='" + medicineId + '\'' +
                ", MedicineName='" + medicineName + '\'' +
                ", MedicineImage='" + medicineImage + '\'' +
                ", MedicinePrice=" + medicinePrice +
                '}';
    }
}
