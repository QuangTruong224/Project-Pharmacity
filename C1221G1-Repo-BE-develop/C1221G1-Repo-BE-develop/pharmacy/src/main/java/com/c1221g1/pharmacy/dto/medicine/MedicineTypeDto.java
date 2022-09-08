package com.c1221g1.pharmacy.dto.medicine;

public class MedicineTypeDto {
    private String medicineTypeId;
    private String medicineTypeName;

    public MedicineTypeDto() {
    }

    public String getMedicineTypeId() {
        return medicineTypeId;
    }

    public void setMedicineTypeId(String medicineTypeId) {
        this.medicineTypeId = medicineTypeId;
    }

    public String getMedicineTypeName() {
        return medicineTypeName;
    }

    public void setMedicineTypeName(String medicineTypeName) {
        this.medicineTypeName = medicineTypeName;
    }
}
