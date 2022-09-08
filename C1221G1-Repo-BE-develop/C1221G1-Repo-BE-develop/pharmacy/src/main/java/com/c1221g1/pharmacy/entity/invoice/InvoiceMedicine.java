package com.c1221g1.pharmacy.entity.invoice;

import com.c1221g1.pharmacy.entity.medicine.Medicine;

import javax.persistence.*;

@Entity
@Table(name = "invoice_medicine",
        uniqueConstraints = {
                @UniqueConstraint(name = "INVOICE_MEDICINE_UK", columnNames = {"invoice_id", "medicine_id"})})
public class InvoiceMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceMedicineId;
    private Integer invoiceMedicineQuantity;
    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoiceId")
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "medicineId")
    private Medicine medicine;

    public InvoiceMedicine() {
    }

    public Integer getInvoiceMedicineId() {
        return invoiceMedicineId;
    }

    public void setInvoiceMedicineId(Integer invoiceMedicineId) {
        this.invoiceMedicineId = invoiceMedicineId;
    }

    public Integer getInvoiceMedicineQuantity() {
        return invoiceMedicineQuantity;
    }

    public void setInvoiceMedicineQuantity(Integer invoiceMedicineQuantity) {
        this.invoiceMedicineQuantity = invoiceMedicineQuantity;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}