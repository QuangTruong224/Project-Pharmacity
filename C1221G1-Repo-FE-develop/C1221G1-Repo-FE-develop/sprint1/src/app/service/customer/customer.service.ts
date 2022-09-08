import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

import {map} from 'rxjs/operators';
import {environment} from '../../../environments/environment';
import {Customer} from '../../model/customer/customer';



const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  constructor(private http: HttpClient) {
  }

  getAllCustomer(request): Observable<any[]> {
    const params = request;
    console.log(request);
    return this.http.get<Customer[]>(API_URL + '/api/manager-customer/customers', {params});
  }

  search(value: any, value2: any): Observable<Customer[]> {
    console.log(value);
    console.log(value2);
    return this.http.get<Customer[]>(API_URL + `/api/manager-customer/customers?${value}=${value2}`);
  }

  delete(customerId: string) {
    return this.http.delete<Customer>(API_URL + `/api/manager-customer/customers/${customerId}`);
  }

  /**
   * Create by TruongNQ
   * Time : 23:56 02/07/2022
   * Function api create
   */
  create(customer: Customer): Observable<Customer | any> {
    return this.http.post(API_URL + '/api/manager-customer/customers', customer);
  }

  /**
   * Create by TruongNQ
   * Time : 00:20 03/07/2022
   * Function api find by customerId
   */
  findById(customerId: string): Observable<Customer | any> {
    return this.http.get(`${API_URL}/api/manager-customer/customers/${customerId}`);
  }

  /**
   * Create by TruongNQ
   * Time : 00:22 03/07/2022
   * Function api update customerId
   */
  update(customerId: string, customer: Customer): Observable<Customer | any> {
    return this.http.patch(`${API_URL}/api/manager-customer/customers/${customerId}`, customer);
  }

  /**
   * Create by TruongNQ
   * Time : 00:28 03/07/2022
   * Function api check duplicate customerPhone
   */
  checkPhoneNotTaken(customerPhone: string): Observable<boolean> {
    console.log(customerPhone + '!aemewdsjhgdkjghvsdkjyhg');
    return this.http.get('http://localhost:8080/api/manager-customer/customers?size=10000').pipe(
      map((res => {
            const customerList = res['content'];
            return customerList.filter(prd =>

              // tslint:disable-next-line:triple-equals
              prd.customerPhone == customerPhone);
          }
        )
      ), map(customerList =>
        !customerList.length  // length = 1 => false, length = 0 => true;
      ))
      ;
  }
}



