import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs';
const API_URL = `${environment.apiUrl}`;
import * as empty from 'firebase/empty-import';
import {Employee} from '../../model/employee/employee';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  constructor(private http: HttpClient) { }

  /**
   * this function use to get all page Employee
   *
   * @author GiangTB
   * @Time 15:30 02/07/2022
   */
  public getAllEmployee(request): Observable<Employee[]> {
    const params = request;
    return this.http.get<Employee[]>(API_URL + `/api/manager-employee/employees`, {params});
  }

  /**
   * this function use to get all page Employee
   *
   * @author GiangTB
   * @Time 19:00 02/07/2022
   */
  public deleteEmployeeById(id: string): Observable<Employee> {
    return this.http.delete<Employee>(`${API_URL}/api/manager-employee/employees/${id}`)
  }
  /*
    Created by TamNA
    Time: 08:50:00 03/07/2022
    Function:  save employee
  */
  saveEmployee(employee): Observable<Employee> {
    return this.http.post<Employee>('http://localhost:8080/api/manager-employee/employees/', employee);
  }


  /*
     Created by TamNA
     Time: 08:55:00 03/07/2022
     Function:  save employee
   */
  findEmployeeById(id: string): Observable<Employee> {
    return this.http.get<Employee>(`${'http://localhost:8080/api/manager-employee/employees'}/${id}`);
  }

  /*
     Created by TamNA
     Time: 09:00:00 03/07/2022
     Function:  save employee
   */
  updateEmployee(id: string, employee: Employee): Observable<Employee> {
    return this.http.patch<Employee>(`${'http://localhost:8080/api/manager-employee/employees'}/${id}`, employee);
  }
}
