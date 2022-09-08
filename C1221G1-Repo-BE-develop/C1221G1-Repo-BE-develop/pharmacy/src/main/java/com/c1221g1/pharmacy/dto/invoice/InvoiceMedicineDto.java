package com.c1221g1.pharmacy.dto.invoice;

/*
 * Created by DaLQA
 * Time: 7:30 PM 29/06/2022
 * Function:  InvoiceMedicineDto
 * */

public class InvoiceMedicineDto {
    private Integer quantity;
    private String medicineId;

    public InvoiceMedicineDto() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

}