import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Invoice} from "../model/invoice";
import {Observable} from "rxjs";
import {MedicineStorageDto} from "../dto/medicine-storage-dto";
import {InvoiceDto} from "../dto/invoice-dto";
import {ListMedicineDto} from "../dto/list-medicine-dto";
import {MedicineOfInvoiceDto} from "../dto/medicine-of-invoice-dto";
import {Customer} from "../model/customer";
import {Employee} from "../model/employee/employee";

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class InvoiceWholesaleAndRefundService {

  constructor(private http: HttpClient) { }

  createInvoice(invoice: Invoice):Observable<Invoice>{
    return this.http.post<Invoice>(API_URL + '/api/manager-sale/invoiceMedicines/createWholesale', invoice)
  }
  createRefundInvoice(invoice: Invoice):Observable<Invoice>{
    return this.http.post<Invoice>(API_URL + '/api/manager-sale/invoiceMedicines/createRefund', invoice)
  }
  getAll(): Observable<MedicineStorageDto[]> {
    return this.http.get<MedicineStorageDto[]>(API_URL + '/api/manager-sale/invoiceMedicines/medicine');
  }

  search(invoiceId: string): Observable<InvoiceDto> {
    return this.http.get<InvoiceDto>(`${API_URL}/api/manager-sale/invoices/${invoiceId}`);
  }
  getInvoiceMedicine(invoiceId: string): Observable<MedicineOfInvoiceDto[]>{
    return this.http.get<MedicineOfInvoiceDto[]>(`${API_URL}/api/manager-sale/invoiceMedicines/${invoiceId}`);
  }
  getCustomer(): Observable<Customer[]> {
    return this.http.get<Customer[]>(API_URL + '/api/manager-customer/customers/getCustomerType');
  }
  public getListEmployee(): Observable<Employee[]> {
    return this.http.get<Employee[]>(API_URL + `/api/manager-employee/employees/list`);
  }
}
