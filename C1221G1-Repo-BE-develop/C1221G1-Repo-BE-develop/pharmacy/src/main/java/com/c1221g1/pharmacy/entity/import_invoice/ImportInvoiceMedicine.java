package com.c1221g1.pharmacy.entity.import_invoice;

import com.c1221g1.pharmacy.entity.medicine.Medicine;

import javax.persistence.*;

@Entity
public class ImportInvoiceMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer importInvoiceMedicineId;
    private Integer importInvoiceMedicineDiscountRate;
    @Column(columnDefinition = "DATE")
    private String importInvoiceMedicineExpiry;
    private Integer importInvoiceMedicineImportAmount;
    private Double importInvoiceMedicineImportPrice;
    private Integer importInvoiceMedicineLotNumber;
    private Integer importInvoiceMedicineVat;
    @Column(columnDefinition = "BIT")
    private boolean flag;
    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "medicineId")
    private Medicine medicine;
    @ManyToOne
    @JoinColumn(name = "import_invoice_id", referencedColumnName = "importInvoiceId")
    private ImportInvoice importInvoice;

    public ImportInvoiceMedicine() {
    }

    public Integer getImportInvoiceMedicineId() {
        return importInvoiceMedicineId;
    }

    public void setImportInvoiceMedicineId(Integer importInvoiceMedicineId) {
        this.importInvoiceMedicineId = importInvoiceMedicineId;
    }

    public Integer getImportInvoiceMedicineDiscountRate() {
        return importInvoiceMedicineDiscountRate;
    }

    public void setImportInvoiceMedicineDiscountRate(Integer importInvoiceMedicineDiscountRate) {
        this.importInvoiceMedicineDiscountRate = importInvoiceMedicineDiscountRate;
    }

    public String getImportInvoiceMedicineExpiry() {
        return importInvoiceMedicineExpiry;
    }

    public void setImportInvoiceMedicineExpiry(String importInvoiceMedicineExpiry) {
        this.importInvoiceMedicineExpiry = importInvoiceMedicineExpiry;
    }

    public Integer getImportInvoiceMedicineImportAmount() {
        return importInvoiceMedicineImportAmount;
    }

    public void setImportInvoiceMedicineImportAmount(Integer importInvoiceMedicineImportAmount) {
        this.importInvoiceMedicineImportAmount = importInvoiceMedicineImportAmount;
    }

    public Double getImportInvoiceMedicineImportPrice() {
        return importInvoiceMedicineImportPrice;
    }

    public void setImportInvoiceMedicineImportPrice(Double importInvoiceMedicineImportPrice) {
        this.importInvoiceMedicineImportPrice = importInvoiceMedicineImportPrice;
    }

    public Integer getImportInvoiceMedicineLotNumber() {
        return importInvoiceMedicineLotNumber;
    }

    public void setImportInvoiceMedicineLotNumber(Integer importInvoiceMedicineLotNumber) {
        this.importInvoiceMedicineLotNumber = importInvoiceMedicineLotNumber;
    }

    public Integer getImportInvoiceMedicineVat() {
        return importInvoiceMedicineVat;
    }

    public void setImportInvoiceMedicineVat(Integer importInvoiceMedicineVat) {
        this.importInvoiceMedicineVat = importInvoiceMedicineVat;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public ImportInvoice getImportInvoice() {
        return importInvoice;
    }

    public void setImportInvoice(ImportInvoice importInvoice) {
        this.importInvoice = importInvoice;
    }

}