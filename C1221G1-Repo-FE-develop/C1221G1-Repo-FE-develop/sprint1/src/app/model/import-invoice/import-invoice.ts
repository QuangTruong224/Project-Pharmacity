
import {Employee} from '../employee/employee';
import {ImportInvoiceMedicine} from './import-invoice-medicine';
import {Supplier} from '../Supplier';

export interface ImportInvoice {
  importInvoiceId: string;
  importSystemCode: number;
  paymentPrepayment: number;
  total: number;
  importInvoiceDate: string;
  importInvoiceHour: string;
  flag: boolean;
  supplier?: Supplier;
  employee: Employee;
  importInvoiceMedicineList: ImportInvoiceMedicine[];
}
