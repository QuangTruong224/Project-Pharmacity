import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {MedicineType} from '../../model/medicine/medicine-type';
import {environment} from '../../../environments/environment';
import {MedicineOrigin} from '../../model/medicine/medicine-origin';
import {MedicineUnit} from '../../model/medicine/medicine-unit';
import {MedicineConversionUnit} from '../../model/medicine/medicine-conversion-unit';
import {Medicine} from '../../model/medicine/medicine';
import {MedicineDto} from '../../model/medicine/medicine-dto';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  constructor(private http: HttpClient) {
  }

  /**
   * this function use to get all medicine type throw api url
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  public getMedicineTypeList(): Observable<MedicineType[]> {
    return this.http.get<MedicineType[]>(API_URL + '/api/manager-medicine/medicines/medicineType');
  }

  /**
   * this function use to get all medicine origin throw api url
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  public getMedicineOriginList(): Observable<MedicineOrigin[]> {
    return this.http.get<MedicineOrigin[]>(API_URL + '/api/manager-medicine/medicines/medicineOrigin');
  }

  /**
   * this function use to get all medicine unit throw api url
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  public getMedicineUnitList(): Observable<MedicineUnit[]> {
    return this.http.get<MedicineUnit[]>(API_URL + '/api/manager-medicine/medicines/medicineUnit');
  }

  /**
   * this function use to get all medicine conversion unit throw api url
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  public getMedicineConversionUnitList(): Observable<MedicineConversionUnit[]> {
    return this.http.get<MedicineConversionUnit[]>(API_URL + '/api/manager-medicine/medicines/medicineConversionUnit');
  }

  /**
   * this function use to create new medicine throw api url
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  createMedicine(medicine): Observable<Medicine> {
    return this.http.post<Medicine>(API_URL + '/api/manager-medicine/medicines', medicine);
  }

  /**
   * this function use to update exist medicine throw api url
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  updateMedicine(id: string, medicine: Medicine): Observable<Medicine> {
    return this.http.patch<Medicine>(`${API_URL}/api/manager-medicine/medicines/${id}`, medicine);
  }

  /**
   * this function use to find exist medicine in BE throw api url
   *
   * @Author LongNH
   * @Time 19:00 03/07/2022
   */
  public findMedicineById(id: string): Observable<Medicine> {
    return this.http.get<Medicine>(`${API_URL}/api/manager-medicine/medicines/${id}`);
  }

  /**
   * this function use delete medicine in BE throw api url
   *
   * @Author MyC
   * @Time 19:00 03/07/2022
   */
  public deleteMedicineById(id: string): Observable<Medicine> {
    return this.http.delete<Medicine>(`${API_URL}/api/manager-medicine/medicines/${id}`);
  }

  /**
   * this function use search and list medicine in BE throw api url
   *
   * @Author MyC
   * @Time 19:00 03/07/2022
   */
  public searchListMedicine(value1: any, value2: any, value3: any): Observable<MedicineDto[]> {
    console.log(`${API_URL}/api/manager-medicine/medicines/search?columName=${value1}&condition=${value2}&keyWord=${value3}`);
    // tslint:disable-next-line:max-line-length
    return this.http.get<MedicineDto[]>
    (`${API_URL}/api/manager-medicine/medicines/search?columName=${value1}&condition=${value2}&keyWord=${value3}`);
  }
}
