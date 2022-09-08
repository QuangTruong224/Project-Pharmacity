import {Component, OnInit} from '@angular/core';
import {InvoiceService} from "../../../service/invoice.service";
import {FormControl, FormGroup, ValidationErrors, ValidatorFn} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {IInvoice} from "../../../model/i-invoice";

@Component({
  selector: 'app-invoice-list',
  templateUrl: './invoice-list.component.html',
  styleUrls: ['./invoice-list.component.css']
})
export class InvoiceListComponent implements OnInit {
  invoiceList: IInvoice[] = [];
  totalPages: number;
  currentPage: number;
  idDel: string;
  nameDel: string;
  startDate: string = "";
  endDate: string = new Date().toLocaleDateString('ez-ZA');
  startTime: string = "";
  endTime: string = "23:59";
  typeOfInvoiceId: string = '1';
  fieldSort: string = 'invoiceId';
  searchForm: FormGroup;
  isChosen: boolean;
  chosenIndex: number;
  chosenId: string;

  constructor(private invoiceService: InvoiceService, private toastr: ToastrService) {
    this.searchForm = new FormGroup({
      dateForm: new FormGroup({
        startDate: new FormControl(),
        endDate: new FormControl()
      }, [this.dateErrorValidator, this.startDateErrorValidator]),
      typeOfInvoiceId: new FormControl("1"),
      fieldSort: new FormControl("invoiceId")
    })
  }

  ngOnInit(): void {
    this.getAllInvoice({page: 0, size: 5});
  }

  getAllInvoice(request) {
    this.invoiceService.getAll(request).subscribe(invoices => {
        if (invoices != null) {
          this.invoiceList = invoices['content'];
          this.currentPage = invoices['number'];
          this.totalPages = invoices['totalPages'];
        } else {
          this.invoiceList = [];
        }
      }
    )
  }

  previousPage() {
    const request = {};
    if ((this.currentPage) > 0) {
      request['page'] = this.currentPage - 1;
      request['size'] = 5;
      request['startDate'] = this.startDate;
      request['endDate'] = this.endDate;
      request['startDate'] = this.startDate;
      request['startTime'] = this.startTime;
      request['endTime'] = this.endTime;
      request['typeOfInvoiceId'] = this.typeOfInvoiceId;
      request['fieldSort'] = this.fieldSort;
      this.getAllInvoice(request);
    }
  }

  nextPage() {
    const request = {};
    if ((this.currentPage + 1) < this.totalPages) {
      request['page'] = this.currentPage + 1;
      request['size'] = 5;
      request['startDate'] = this.startDate;
      request['endDate'] = this.endDate;
      request['startDate'] = this.startDate;
      request['startTime'] = this.startTime;
      request['endTime'] = this.endTime;
      request['typeOfInvoiceId'] = this.typeOfInvoiceId;
      request['fieldSort'] = this.fieldSort;
      this.getAllInvoice(request);

    }
  }

  deleteInvoice(idDel: string) {
    if (idDel !== null) {
      this.invoiceService.deleteInvoiceById(idDel).subscribe(() => {
        this.ngOnInit();
        this.toastr.success("Xóa thành công hóa đơn!", "Thông báo", {
          timeOut: 3000,
          progressBar: true
        })
      })
    }
  }

  search() {
    if (this.searchForm.value.startDate == null) {
      this.searchForm.value.startDate = this.startDate
    } else {
      this.startDate = this.searchForm.value.startDate
    }
    if (this.searchForm.value.endDate == null) {
      this.searchForm.value.endDate = this.endDate
    } else {
      this.endDate = this.searchForm.value.endDate
    }
    if (this.searchForm.value.startTime == null) {
      this.searchForm.value.startTime = this.startTime
    }
    if (this.searchForm.value.endTime == null) {
      this.searchForm.value.endTime = this.endTime
    }
    if (this.searchForm.value.fieldSort == null) {
      this.searchForm.value.fieldSort = this.fieldSort;
    } else {
      this.fieldSort = this.searchForm.value.fieldSort;
    }
    if (this.searchForm.value.typeOfInvoiceId == null) {
      this.searchForm.value.typeOfInvoiceId = this.typeOfInvoiceId;
    } else {
      this.typeOfInvoiceId = this.searchForm.value.typeOfInvoiceId;
    }
    this.invoiceService.getAll({
      page: 0, size: 5, startDate: this.searchForm.value.startDate, endDate: this.searchForm.value.endDate,
      startTime: this.searchForm.value.startTime, endTime: this.searchForm.value.endTime,
      typeOfInvoiceId: this.typeOfInvoiceId, fieldSort: this.fieldSort
    }).subscribe(invoices => {
        if (invoices != null) {
          this.invoiceList = invoices['content'];
          this.currentPage = invoices['number'];
          this.totalPages = invoices['totalPages'];
        } else {
          this.invoiceList = [];
          this.currentPage = -1;
          this.totalPages = 0;
        }
      }
    )
  }

  chooseInvoice(index: number, invoiceId: string, customerName: string): void {
    if (this.chosenIndex !== index) {
      this.isChosen = true;
      this.chosenIndex = index;
      this.chosenId = invoiceId;
    } else {
      this.isChosen = !this.isChosen;
      this.chosenIndex = null;
      this.idDel = null;
    }
    if (this.isChosen) {
      this.idDel = invoiceId;
      this.nameDel = customerName;
    }
  }

  reset() {
    this.startDate = "";
    this.endDate = new Date().toLocaleDateString('ez-ZA');
    this.startTime = "";
    this.endTime = "23:59";
    this.typeOfInvoiceId = '1';
    this.fieldSort = 'invoiceId';
    this.ngOnInit();
  }

  dateErrorValidator: ValidatorFn = (control: FormGroup): ValidationErrors | null => {
    const start = control.get('startDate');
    if (start.value !== null) {
      this.startDate = start.value.slice(0, 10) + start.value.slice(11);
    }
    const end = control.get('endDate');
    if (end.value !== null) {
      this.endDate = end.value.slice(0, 10) + end.value.slice(11);
    }
    return start.value > end.value ? {dateError: true} : null;
  }

  startDateErrorValidator: ValidatorFn = (control: FormGroup): ValidationErrors | null => {
    const start = control.get('startDate');
    if (start.value !== null) {
      this.startDate = start.value.slice(0, 10) + start.value.slice(11);
    }
    let now = new Date().toLocaleString('en-ZA', {hour12: false});
    const string1 = now.substr(0,4)
    const string2 = now.substr(5,2)
    const string3 = now.substr(8,2)
    const string4 = now.substr(12,5);
    const nowVal = string1+"-"+string2+"-"+string3+string4
    if (this.startDate > nowVal) {
      return {startDateError: true}
    } else {
      return null;
    }
  }
}
