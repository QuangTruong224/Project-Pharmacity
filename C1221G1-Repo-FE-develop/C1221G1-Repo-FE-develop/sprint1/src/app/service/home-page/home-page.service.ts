import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class HomePageService {
  homepageApi = 'http://localhost:8080/api/manager-medicine/medicines';

  constructor(private http: HttpClient) {
  }

  /*
  Created by AnP
  Time: 11:00 02/07/2022
  Function: Get list 10 medicines best seller
  */
  getMedicineBestseller(): Observable<any> {
    return this.http.get<any>(this.homepageApi + '/best-seller');
  }

  /*
  Created by AnP
  Time: 15:30 02/07/2022
  Function: Get All Medicine And Search by medicine_name and medicine_type
  */
  getMedicineByNameAndTypeId(request): Observable<any>{
    const params = request;
    return this.http.get<any>(this.homepageApi, {params});
  }

}
