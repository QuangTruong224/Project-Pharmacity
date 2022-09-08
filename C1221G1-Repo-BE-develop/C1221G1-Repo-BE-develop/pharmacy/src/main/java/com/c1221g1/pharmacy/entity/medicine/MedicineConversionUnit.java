package com.c1221g1.pharmacy.entity.medicine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties("medicineList")
public class MedicineConversionUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicineConversionUnitId;
    private String medicineConversionUnitName;
    @OneToMany(mappedBy = "medicineConversionUnit")
    private List<Medicine> medicineList;

    public MedicineConversionUnit() {
    }

    public Integer getMedicineConversionUnitId() {
        return medicineConversionUnitId;
    }

    public void setMedicineConversionUnitId(Integer medicineConversionUnitId) {
        this.medicineConversionUnitId = medicineConversionUnitId;
    }

    public String getMedicineConversionUnitName() {
        return medicineConversionUnitName;
    }

    public void setMedicineConversionUnitName(String medicineConversionUnitName) {
        this.medicineConversionUnitName = medicineConversionUnitName;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }
}