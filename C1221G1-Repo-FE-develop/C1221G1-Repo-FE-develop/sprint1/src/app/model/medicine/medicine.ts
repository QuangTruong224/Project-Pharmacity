import {MedicineOrigin} from './medicine-origin';
import {MedicineType} from './medicine-type';
import {MedicineUnit} from './medicine-unit';
import {MedicineConversionUnit} from './medicine-conversion-unit';

export interface Medicine {
  medicineId: string;
  medicineName: string;
  medicineActiveIngredients: string;
  medicineImportPrice: number;
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
  medicineOrigin: MedicineOrigin;
  medicineType: MedicineType;
  medicineUnit: MedicineUnit;
  medicineConversionUnit: MedicineConversionUnit;

}
