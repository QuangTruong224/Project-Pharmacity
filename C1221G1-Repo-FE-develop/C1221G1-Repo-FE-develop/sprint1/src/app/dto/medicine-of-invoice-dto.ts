import {Medicine} from "../model/medicine/medicine";


export interface MedicineOfInvoiceDto {
  medicine: Medicine,
  quantityRefund?: number,
  medicineUnit?: string,
  price?: number,
  medicineName?: string,
  invoiceMedicineQuantity?: number,
  moneyOfMedicine?: number
}
