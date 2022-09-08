export interface MedicineDto {
  medicineId: string;
  medicineName: string;
  medicineActiveIngredients: string;
  medicineImportPrice: number;
  wholesalePrice: number;
  retailPrice: number;
  medicineDiscount: number;
  medicineWholesaleProfit: number;
  medicineRetailSaleProfit: number;
  medicineTax: number;
  medicineConversionRate: number;
  medicineManufacture: string;
  medicineUsage: string;
  medicineInstruction: string;
  medicineAgeApproved: string;
  medicineImage: string;
  medicineDescription: string;
  flag: boolean;
  medicineOriginName: string;
  medicineTypeName: string;
  medicineUnitName: string;
  medicineConversionUnitName: string;
}
