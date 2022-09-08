package com.c1221g1.pharmacy.dto.prescription;
import com.c1221g1.pharmacy.entity.prescription.MedicinePrescription;
import javax.validation.constraints.*;
import java.util.List;

public class PrescriptionDto {
    private String prescriptionId;
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 50)
    @Pattern(regexp = "^[^!@#$%^&*()]*$")
    private String prescriptionName;
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 100)
    @Pattern(regexp = "^[^!@#$%^&*()]*$")
    private String prescriptionSymptom;
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 50)
    @Pattern(regexp = "^[^!@#$%^&*()]*$")
    private String prescriptionTargetUser;
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 100)
    @Pattern(regexp = "^[^!@#$%^&*()]*$")
    private String prescriptionNote;
    @NotNull
    @Min(1)
    @Max(365)
    private Integer prescriptionNumberOfDays;
    private Boolean flag;
//    private List<MedicinePrescriptionDto> medicinePrescriptionDtoList;

    public PrescriptionDto() {
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
}
