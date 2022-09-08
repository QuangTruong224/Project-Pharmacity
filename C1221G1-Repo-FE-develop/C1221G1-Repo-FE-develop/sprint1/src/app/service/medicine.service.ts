import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Medicine} from '../model/medicine';
const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  constructor(private http: HttpClient) { }
  getAll(): Observable<Medicine[]> {
    return this.http.get<Medicine[]>(API_URL + '/api/manager-medicine/medicines/list');
  }
}
