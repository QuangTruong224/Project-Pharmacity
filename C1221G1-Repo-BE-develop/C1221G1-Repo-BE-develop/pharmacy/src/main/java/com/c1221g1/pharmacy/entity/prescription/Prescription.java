package com.c1221g1.pharmacy.entity.prescription;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"medicinePrescriptionList"})
public class Prescription {
    @Id
    @Column(columnDefinition = "VARCHAR(20)")
    @GeneratedValue(generator = "prod-generator")
    @GenericGenerator(name = "prod-generator",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "DT"),
            strategy = "com.c1221g1.pharmacy.common.IdentityCodeGenerator")
    private String prescriptionId;
    private String prescriptionName;
    @Column(columnDefinition = "LONGTEXT")
    private String prescriptionSymptom;
    private String prescriptionTargetUser;
    @Column(columnDefinition = "LONGTEXT")
    private String prescriptionNote;
    private Integer prescriptionNumberOfDays;
    private Boolean flag;
    @OneToMany(mappedBy = "prescription")
    private List<MedicinePrescription> medicinePrescriptionList;

    public Prescription() {
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    public String getPrescriptionSymptom() {
        return prescriptionSymptom;
    }

    public void setPrescriptionSymptom(String prescriptionSymptom) {
        this.prescriptionSymptom = prescriptionSymptom;
    }

    public String getPrescriptionTargetUser() {
        return prescriptionTargetUser;
    }

    public void setPrescriptionTargetUser(String prescriptionTargetUser) {
        this.prescriptionTargetUser = prescriptionTargetUser;
    }

    public String getPrescriptionNote() {
        return prescriptionNote;
    }

    public void setPrescriptionNote(String prescriptionNote) {
        this.prescriptionNote = prescriptionNote;
    }

    public Integer getPrescriptionNumberOfDays() {
        return prescriptionNumberOfDays;
    }

    public void setPrescriptionNumberOfDays(Integer prescriptionNumberOfDays) {
        this.prescriptionNumberOfDays = prescriptionNumberOfDays;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public List<MedicinePrescription> getMedicinePrescriptionList() {
        return medicinePrescriptionList;
    }

    public void setMedicinePrescriptionList(List<MedicinePrescription> medicinePrescriptionList) {
        this.medicinePrescriptionList = medicinePrescriptionList;
    }
}