import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Prescription} from '../models/prescription/prescription';
import {HttpClient} from '@angular/common/http';
import {Medicine} from '../models/medicine/medicine';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  constructor(private http: HttpClient) { }

  getAllMedicine1(): Observable<Medicine[]> {
    return this.http.get<Medicine[]>('http://localhost:8080/api/manager-medicine/medicines/list');
  }
}
