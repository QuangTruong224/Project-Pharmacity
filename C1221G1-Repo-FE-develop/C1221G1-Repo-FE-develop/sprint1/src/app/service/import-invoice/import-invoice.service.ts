import {Injectable} from '@angular/core';
import {Page} from 'ngx-pagination/dist/pagination-controls.directive';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Medicine} from '../../model/medicine/medicine';
import {FormGroup} from '@angular/forms';
import {Employee} from '../../model/employee/employee';
import {ImportInvoice} from '../../model/import-invoice/import-invoice';
import {Supplier} from '../../model/Supplier';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ImportInvoiceService {

  constructor(private http: HttpClient) {
  }

  /**
   * this function use to get list Import Invoice from be
   *
   * @author HongHTX
   * @Time 09:00 03/07/2022
   */
  public getAll(request): Observable<any> {
    const params = request;
    return this.http.get<Page>('http://localhost:8080/api/manager-medicine/import-invoice', {params});
  }

  /**
   * this function use to send id to be
   *
   * @author HongHTX
   * @Time 10:00 03/07/2022
   */
  public delete(id: string): Observable<ImportInvoice> {
    return this.http.delete<ImportInvoice>(`http://localhost:8080/api/manager-medicine/import-invoice/${id}`);
  }


  /**
   * this is temp function
   *
   * @author Trung
   * @Time 05/07/2022
   */
  getSupplierList(): Observable<Supplier[]> {
    return this.http.get<Supplier[]>('http://localhost:8080/api/manager-medicine/import-invoice' + '/suppliers');
  }

  /**
   * this is temp function
   *
   * @author Trung
   * @Time 05/07/2022
   */
  getMedicineList() {
    return this.http.get<Medicine[]>('http://localhost:8080/api/manager-medicine/import-invoice' + '/medicines');
  }

  /**
   * this is main function
   *
   * @author Trung
   * @Time 05/07/2022
   */
  save(createImportInvoiceForm: FormGroup): Observable<any> {
    console.log('form: ' + createImportInvoiceForm);
    return this.http.post<any>('http://localhost:8080/api/manager-medicine/import-invoice' + '/importInvoice', createImportInvoiceForm);
  }

  /**
   * this is temp function
   *
   * @author Trung
   * @Time 05/07/2022
   */
  getEmployee(): Observable<Employee[]> {
    return this.http.get<Employee[]>('http://localhost:8080/api/manager-medicine/import-invoice' + '/employees');
  }
}
