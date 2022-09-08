import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Revenue} from "../model/revenue";
import {SupplierHaveReceivable} from "../model/supplier-have-receivable";
import {MedicineNeedToImport} from "../model/medicine-need-to-import";
import {Static} from "../model/static";
import * as FileSaver from 'file-saver';
import * as XLSX from 'xlsx';
import {TopMedicine} from "../model/top-medicine";
import {StaticByMonth} from "../model/static-by-month";

const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class ReportService {

  constructor(private http: HttpClient) {

  }
  getRevenue(startTime: string, endTime: string): Observable<Revenue[]> {
    return this.http.get<Revenue[]>(API_URL + `/api/manager_report/report/revenue?startTime=${startTime}&endTime=${endTime}`);
  }

  getRevenueByEmployee(startTime: string, endTime: string): Observable<Revenue[]> {
    return this.http.get<Revenue[]>(API_URL + `/api/manager_report/report/diary?startTime=${startTime}&endTime=${endTime}`);
  }

  getSupplierHaveReceivable(): Observable<SupplierHaveReceivable[]> {
    return this.http.get<SupplierHaveReceivable[]>(API_URL + `/api/manager_report/report/supplier`);
  }

  getMedicineNeedToImport(): Observable<MedicineNeedToImport[]> {
    return this.http.get<MedicineNeedToImport[]>(API_URL + `/api/manager_report/report/medicineNeedToImport`);
  }

  getMedicineBeAboutExpired(): Observable<MedicineNeedToImport[]> {
    return this.http.get<MedicineNeedToImport[]>(API_URL + `/api/manager_report/report/medicineBeAboutExpired`);
  }

  getTopMedicine(): Observable<TopMedicine[]> {
    return this.http.get<TopMedicine[]>(API_URL + `/api/manager_report/report/topMedicine`);
  }

  getStatic(year: string): Observable<Static[]> {
    return this.http.get<Static[]>(API_URL + `/api/manager_report/report/static?year=${year}`);
  }

  getStaticByMonth(month: string, year: string): Observable<StaticByMonth[]> {
    return this.http.get<StaticByMonth[]>(API_URL + `/api/manager_report/report/staticByMonth?month=${month}&year=${year}`);
  }

  fileType = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8';
  fileExtension = '.xlsx';

  public exportExcel(jsonData: any[], fileName: string): void {
    const ws: XLSX.WorkSheet = XLSX.utils.json_to_sheet(jsonData);
    const wb: XLSX.WorkBook = { Sheets: { 'data': ws }, SheetNames: ['data'] };
    const excelBuffer: any = XLSX.write(wb, { bookType: 'xlsx', type: 'array' });
    this.saveExcelFile(excelBuffer, fileName);
  }

  private saveExcelFile(buffer: any, fileName: string): void {
    const data: Blob = new Blob([buffer], {type: this.fileType});
    FileSaver.saveAs(data, fileName + this.fileExtension);
  }
}
