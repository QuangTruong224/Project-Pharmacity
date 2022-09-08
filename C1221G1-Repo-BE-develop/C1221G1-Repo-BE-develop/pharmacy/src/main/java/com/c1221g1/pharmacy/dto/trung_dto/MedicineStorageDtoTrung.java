package com.c1221g1.pharmacy.dto.trung_dto;

public class MedicineStorageDtoTrung {
    private Integer medicineStorageId;
    private Long medicineQuantity;
    private MedicineDtoTrung medicineDtoTrung;

    public MedicineStorageDtoTrung() {
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

    public MedicineDtoTrung getMedicineDtoTrung() {
        return medicineDtoTrung;
    }

    public void setMedicineDtoTrung(MedicineDtoTrung medicineDtoTrung) {
        this.medicineDtoTrung = medicineDtoTrung;
    }
}
