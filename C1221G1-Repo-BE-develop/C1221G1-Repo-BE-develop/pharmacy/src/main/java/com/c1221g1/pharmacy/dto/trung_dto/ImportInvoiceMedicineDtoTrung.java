package com.c1221g1.pharmacy.dto.trung_dto;

import com.c1221g1.pharmacy.dto.medicine.MedicineDto;

public class ImportInvoiceMedicineDtoTrung {
    private Integer importInvoiceMedicineId;
    private Integer importInvoiceMedicineImportAmount;
    private boolean flag;
    private MedicineDto medicineDto;
    private ImportInvoiceDtoTrung importInvoiceDtoTrung;

    public ImportInvoiceMedicineDtoTrung() {
    }

    public Integer getImportInvoiceMedicineId() {
        return importInvoiceMedicineId;
    }

    public void setImportInvoiceMedicineId(Integer importInvoiceMedicineId) {
        this.importInvoiceMedicineId = importInvoiceMedicineId;
    }

    public Integer getImportInvoiceMedicineImportAmount() {
        return importInvoiceMedicineImportAmount;
    }

    public void setImportInvoiceMedicineImportAmount(Integer importInvoiceMedicineImportAmount) {
        this.importInvoiceMedicineImportAmount = importInvoiceMedicineImportAmount;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public MedicineDto getMedicineDto() {
        return medicineDto;
    }

    public void setMedicineDto(MedicineDto medicineDto) {
        this.medicineDto = medicineDto;
    }

    public ImportInvoiceDtoTrung getImportInvoiceDtoTrung() {
        return importInvoiceDtoTrung;
    }

    public void setImportInvoiceDtoTrung(ImportInvoiceDtoTrung importInvoiceDtoTrung) {
        this.importInvoiceDtoTrung = importInvoiceDtoTrung;
    }
}
