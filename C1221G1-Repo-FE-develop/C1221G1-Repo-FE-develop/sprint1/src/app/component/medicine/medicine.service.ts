import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {MedicineDetailDto} from '../../dto/medicine/medicine-detail.model';

const API_URL_MEDICINE = 'http://localhost:8080/api/manager-medicine/medicines';

@Injectable({
  providedIn: 'root'
})


export class MedicineService {

  constructor(private httpClient: HttpClient) {
  }

  getMedicineDetailForView(medicineId: string): Observable<MedicineDetailDto> {
    return this.httpClient.get<MedicineDetailDto>(`${API_URL_MEDICINE}/detail/${medicineId}`);
  }

  get5RelativeMedicinesOf(medicineId: string): Observable<MedicineDetailDto[]> {
    return this.httpClient.get<MedicineDetailDto[]>(`${API_URL_MEDICINE}/get-5-relative-medicines-type/${medicineId}`);
  }
}
