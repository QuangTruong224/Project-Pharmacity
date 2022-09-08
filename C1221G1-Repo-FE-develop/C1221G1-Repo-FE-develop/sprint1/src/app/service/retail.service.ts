import { Injectable } from '@angular/core';
import {MedicineSale} from "../dto/invoice/medicineSale";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {InvoiceDto} from "../dto/invoice/invoiceDto";
import {Prescription} from "../model/prescription";
import {PrescriptionDetail} from "../dto/prescription/prescriptionDetail";
import {PrescriptionMedicineDetail} from "../dto/prescription/prescriptionMedicineDetail";
import {Employee} from "../model/employee/employee";

const API_URL8080_SALE = `${environment.url8080retail}`;
const API_URL8080_PRESCRIPTION = `${environment.url8080prescription}`;
const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class RetailService {

  constructor(private  httpClient: HttpClient) { }
  /*
* Created by DaLQA
* Time: 10:30 AM 3/07/2022
* Function: function getMedicineDto
* */
  public getMedicineDto(): Observable<MedicineSale[]> {
    return this.httpClient.get<MedicineSale[]>(API_URL8080_SALE + '/getMedicines');
  }
  /*
* Created by DaLQA
* Time: 10:30 AM 3/07/2022
* Function: function createRetailInvoice
* */
  public createRetailInvoice(invoiceDto: InvoiceDto): Observable<void> {
    return this.httpClient.post<void>(API_URL8080_SALE + '/createRetail', invoiceDto);
  }

  /*
* Created by DaLQA
* Time: 10:53 AM 4/07/2022
* Function: function getAllPrescription
* */
  public getAllPrescription(page: number, id: string, names: string, target: string, symptom: string): Observable<Prescription[]> {
    return this.httpClient.get<Prescription[]>('http://localhost:8080/api/manager-prescription/prescriptions?page=' +
      page + '&id=' + id + '&names=' + names + '&target=' + target + '&symptom=' + `${symptom}`);
  }

  /*
* Created by DaLQA
* Time: 10:04 AM 5/07/2022
* Function: function getDetailPrescription
* */
   public getPrescriptionDetail(id: string): Observable<PrescriptionDetail> {
    return this.httpClient.get<PrescriptionDetail>(`${API_URL8080_PRESCRIPTION}/detail/${id}`);
  }

  /*
* Created by DaLQA
* Time: 10:04 AM 5/07/2022
* Function: function getPrescriptionMedicineDetail
* */
  public getPrescriptionMedicineDetail(id: string){
    return this.httpClient.get<PrescriptionMedicineDetail[]>(`${API_URL8080_PRESCRIPTION}/detail/prescriptions-medicines/${id}`)
  }


  public getListEmployee(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(API_URL + `/api/manager-employee/employees/list`);
  }
}
