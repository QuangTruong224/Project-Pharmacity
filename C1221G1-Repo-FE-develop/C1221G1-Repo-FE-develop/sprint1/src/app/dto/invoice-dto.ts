import {Employee} from "../model/employee/employee";
import {Customer} from "../model/customer";
import {TypeOfInvoice} from "../model/type-of-invoice";

export interface InvoiceDto {
  customer: Customer,
  employee: Employee,
  invoiceCreatedDate: string,
  invoiceId: string,
  typeOfInvoice: TypeOfInvoice,
  invoiceNote: string,
}
