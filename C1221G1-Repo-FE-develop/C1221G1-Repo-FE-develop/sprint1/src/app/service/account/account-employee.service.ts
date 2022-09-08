import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AccountEmployee} from "../../model/account/accountEmployee";
import {EditAccountEmployeeDto} from "../../model/account/edit-account-employee-dto";

const API_URL = "http://localhost:8080/api/manager-account/account";

@Injectable({
  providedIn: 'root'
})
export class AccountEmployeeService {

  constructor(private http: HttpClient) {
  }


  // **
  //  * create by HaiNX
  //  * time: 03/06/2022
  //  * search and list
  //  *

  getAllAccountEmployee(id: string, name: string , position: string,username: string , page: number): Observable<any> {
    return this.http.get<any>(
      API_URL +  '?&id=' + id + '&name=' + name + '&position=' + position + '&username=' + username + '&page=' + page  );
  }

  // **
  //  * create by HaiNX
  //  * time: 03/06/2022
  //  * find id account
  //  *
  findAccountEmployeeById(id: string): Observable<EditAccountEmployeeDto> {
    return this.http.get<EditAccountEmployeeDto>(API_URL+ '/' + id);
  }


  // **
  //  * create by HaiNX
  //  * time: 03/06/2022
  //  * edit account
  //  *
  update(id: string, account: EditAccountEmployeeDto): Observable<EditAccountEmployeeDto> {
    return this.http.patch<EditAccountEmployeeDto>(API_URL + '/updateAccount' + '?id=' + id, account);
  }


}
