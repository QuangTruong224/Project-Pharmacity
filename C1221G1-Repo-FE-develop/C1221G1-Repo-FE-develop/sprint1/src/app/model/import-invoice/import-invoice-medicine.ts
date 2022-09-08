import {Medicine} from '../medicine/medicine';
import {MedicineUnit} from '../medicine/medicine-unit';

export interface ImportInvoiceMedicine {
  importInvoiceMedicineId?: number;
  importInvoiceMedicineDiscountRate?: number;
  importInvoiceMedicineExpiry?: number;
  importInvoiceMedicineImportAmount?: number;
  importInvoiceMedicineImportPrice?: number;
  importInvoiceMedicineLotNumber?: number;
  importInvoiceMedicineVat?: number;
  medicineName?: string;
  flag?: boolean;
  medicine?: Medicine;
  medicineUnit?: MedicineUnit;
  medicineImportPrice?: number;
  intoMoney?: number;
}
