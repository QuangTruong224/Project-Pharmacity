import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {MedicinePrescription} from '../../models/prescription/medicine-prescription';
import {HttpClient} from '@angular/common/http';
import {Prescription} from "../../models/prescription/prescription";

@Injectable({
  providedIn: 'root'
})
export class MedicinePrescriptionService {

  constructor(private http: HttpClient) {
  }

  createMedicinePrescription(medicinePrescription): Observable<MedicinePrescription> {
    return this.http.post<MedicinePrescription>('http://localhost:8080/api/manager-prescription/prescriptions/create-med-pre',
      medicinePrescription);
  }

  editMedicinePrescription(ids: number, medicinePrescription: MedicinePrescription): Observable<MedicinePrescription> {
    return this.http.patch<MedicinePrescription>('http://localhost:8080/api/manager-prescription/prescriptions/med-pre/'
      + `${ids}`, medicinePrescription);
  }

  getMedicinePrescriptionById(ids: number): Observable<MedicinePrescription> {
    return this.http.get<MedicinePrescription>('http://localhost:8080/api/manager-prescription/prescriptions/med-pre/' + `${ids}`);
  }
}
