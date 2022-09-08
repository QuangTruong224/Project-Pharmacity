package com.c1221g1.pharmacy.dto.medicine;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MedicineStorageDto implements Validator {
    private Integer medicineStorageId;
    private Long medicineQuantity;
    private Medicine medicine;
    private Boolean flag;

    public MedicineStorageDto() {
    }

    public Integer getMedicineStorageId() {
        return medicineStorageId;
    }

    public void setMedicineStorageId(Integer medicineStorageId) {
        this.medicineStorageId = medicineStorageId;
    }

    public Long getMedicineQuantity() {
        return medicineQuantity;
    }

    public void setMedicineQuantity(Long medicineQuantity) {
        this.medicineQuantity = medicineQuantity;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MedicineStorageDto medicineStorageDto = (MedicineStorageDto) target;
    }
}

