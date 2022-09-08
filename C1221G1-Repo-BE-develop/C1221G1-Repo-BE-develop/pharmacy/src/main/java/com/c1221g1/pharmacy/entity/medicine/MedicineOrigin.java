package com.c1221g1.pharmacy.entity.medicine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"medicineList"})
public class MedicineOrigin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicineOriginId;
    private String medicineOriginName;
    @OneToMany(mappedBy = "medicineOrigin")
    private List<Medicine> medicineList;

    public MedicineOrigin() {
    }

    public Integer getMedicineOriginId() {
        return medicineOriginId;
    }

    public void setMedicineOriginId(Integer medicineOriginId) {
        this.medicineOriginId = medicineOriginId;
    }

    public String getMedicineOriginName() {
        return medicineOriginName;
    }

    public void setMedicineOriginName(String medicineOriginName) {
        this.medicineOriginName = medicineOriginName;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }
}