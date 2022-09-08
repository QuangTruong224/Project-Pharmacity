package com.c1221g1.pharmacy.entity.medicine;

import javax.persistence.*;

@Entity
public class MedicineStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicineStorageId;
    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "medicineId")
    private Medicine medicine;
    private Long medicineQuantity;
    @Column(columnDefinition = "BIT")
    private boolean flag;

    public MedicineStorage() {
    }

    public Integer getMedicineStorageId() {
        return medicineStorageId;
    }

    public void setMedicineStorageId(Integer medicineStorageId) {
        this.medicineStorageId = medicineStorageId;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Long getMedicineQuantity() {
        return medicineQuantity;
    }

    public void setMedicineQuantity(Long medicineQuantity) {
        this.medicineQuantity = medicineQuantity;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}