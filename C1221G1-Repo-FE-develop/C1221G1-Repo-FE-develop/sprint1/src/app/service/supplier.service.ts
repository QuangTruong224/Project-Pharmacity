import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Page} from 'ngx-pagination/dist/pagination-controls.directive';
import {HttpClient} from '@angular/common/http';
import {Supplier} from '../model/Supplier';
import {SupplierDto} from '../dto/SupplierDto';
import {map} from 'rxjs/operators';
import {ISupplierDto} from '../dto/ISupplierDto';

@Injectable({
  providedIn: 'root'
})
export class SupplierService {

  constructor(private http: HttpClient) {
  }

  /**
   * read the value of API
   * method: get
   *  @23h 01/06/2022 LuatTN
   *   @this  get all Supplier
   */
  public getAll(request): Observable<any> {
    const params = request;
    return this.http.get<Page>(`http://localhost:8080/api/manager-medicine/medicines/supplier`, {params});
  }

  /**
   * delete the value
   * method: delete
   *  @23h 01/06/2022 LuatTN
   *  @this  delete Supplier
   */
  public deleteSupplier(id: string): Observable<Supplier> {
    return this.http.delete<Supplier>(`http://localhost:8080/api/manager-medicine/medicines/supplier/${id}`);
  }

  /**
   * save the value
   * method: post
   *  @23h 01/06/2022 LuatTN
   *  @this  save Supplier
   */
  public saveSupplier(supplierDto): Observable<SupplierDto> {
    return this.http.post<SupplierDto>(`http://localhost:8080/api/manager-medicine/medicines/supplier`, supplierDto);
  }

  /**
   * get the value Supplier
   * method: get
   *  @23h 01/06/2022 LuatTN
   *  @this  get Supplier
   */
  public findById(id: string): Observable<ISupplierDto> {
    return this.http.get<ISupplierDto>(`http://localhost:8080/api/manager-medicine/medicines/supplier/${id}`);
  }

  /**
   * get the value Supplier
   * method: get
   *  @23h 01/06/2022 LuatTN
   *  @this  get Supplier Detail
   */
  public findByDetailId(id: string): Observable<ISupplierDto> {
    return this.http.get<ISupplierDto>(`http://localhost:8080/api/manager-medicine/medicines/supplier/detail/${id}`);
  }

  /**
   * get the value Supplier
   * method: patch
   *  @23h 01/06/2022 LuatTN
   *  @this update Supplier
   *
   */
  public updateSupplier(idSupplier: string, supplierDto: SupplierDto) {
    return this.http.patch<SupplierDto>(`http://localhost:8080/api/manager-medicine/medicines/supplier/${idSupplier}`, supplierDto);
  }

  /**
   * check email exists
   *
   *  @23h 01/06/2022 LuatTN
   * @param supplierMail
   * @finished!!
   */
  checkMailNotTaken(supplierMail: string): Observable<boolean> {
    return this.http.get('http://localhost:8080/api/manager-medicine/medicines/supplier?pageSize=10000').pipe(
      map((res => {
            const productList = res['content'];
            return productList.filter(prd =>
              prd.supplierEmail == supplierMail);
          }
        )
      ), map(productList =>
        !productList.length  // length = 1 => false, length = 0 => true;
      ))

      ;
  }

  /**
   * check phone exists
   *  @23h 01/06/2022 LuatTN
   * @param supplierPhone
   * @finished!!
   */
  checkPhoneNotTaken(supplierPhone: string): Observable<boolean> {
    return this.http.get('http://localhost:8080/api/manager-medicine/medicines/supplier?pageSize=10000').pipe(
      map((res => {
            const productList = res['content'];
            return productList.filter(prd =>
              prd.supplierPhone == supplierPhone);
          }
        )
      ), map(productList =>
        !productList.length  // length = 1 => false, length = 0 => true;
      ));
  }
}
