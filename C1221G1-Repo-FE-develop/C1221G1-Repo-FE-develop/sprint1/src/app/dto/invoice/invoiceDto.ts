import {InvoiceMedicineDto} from "./invoiceMedicineDto";

export interface InvoiceDto {
  customerId?: string;
  employeeId?: string;
  invoiceNote?: string;
  invoiceMedicineList?: InvoiceMedicineDto[]
}
