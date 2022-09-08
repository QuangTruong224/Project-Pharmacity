import {Injectable} from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Invoice} from "../model/invoice";
import {Page} from "ngx-pagination/dist/pagination-controls.directive";

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class InvoiceService {

  constructor(private http: HttpClient) { }

  getAll(request): Observable<Page> {
    const params = request;
    return this.http.get<Page>(API_URL + '/api/manager-sale/invoices', {params});
  }
  public deleteInvoiceById(id: string): Observable<Invoice> {
    return this.http.delete<Invoice>(`${API_URL}/api/manager-sale/invoices/${id}`)
  }
}
