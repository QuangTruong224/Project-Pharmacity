import { Injectable } from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Position} from '../../model/employee/position';
const API_URL = `${environment.apiUrl}`;
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PositionService {

  constructor(private http: HttpClient) { }

  /**
   * this function use to get all page Employee
   *
   * @author GiangTB
   * @Time 21:00 02/07/2022
   */
  public getAllPosition(): Observable<Position[]> {
    return this.http.get<Position[]>(API_URL + `/api/manager-position/positions` );
  }
}
