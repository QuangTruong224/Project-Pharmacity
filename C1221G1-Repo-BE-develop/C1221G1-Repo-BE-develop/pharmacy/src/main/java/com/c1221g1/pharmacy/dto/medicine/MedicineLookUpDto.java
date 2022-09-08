package com.c1221g1.pharmacy.dto.medicine;


public interface MedicineLookUpDto {

    String getMedicineId();
    String getMedicineName();
    String getMedicineActiveIngredients();
    Double getMedicineImportPrice();
    Double getWholesalePrice();
    Double getRetailPrice();
    Double getMedicineDiscount();
    Double getMedicineWholesaleProfit();
    Double getMedicineRetailSaleProfit();
    Double getMedicineTax();
    Integer getMedicineConversionRate();
    String getMedicineManufacture();
    String getMedicineUsage();
    String getMedicineInstruction();
    String getMedicineAgeApproved();
    String getMedicineDescription();
    String getMedicineOriginName();
    String getMedicineTypeName();
    String getMedicineUnitName();
    String getMedicineConversionUnitName();
    Boolean getFlag();
}

