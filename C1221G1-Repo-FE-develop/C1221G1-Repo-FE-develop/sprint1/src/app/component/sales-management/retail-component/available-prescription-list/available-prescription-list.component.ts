import {Component, OnInit} from '@angular/core';
import {RetailService} from '../../../../service/retail.service';
import {Prescription} from '../../../../model/prescription';
import {FormControl, FormGroup} from '@angular/forms';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';


@Component({
  selector: 'app-available-prescription-list',
  templateUrl: './available-prescription-list.component.html',
  styleUrls: ['./available-prescription-list.component.css']
})
export class AvailablePrescriptionListComponent implements OnInit {
  prescriptions: Prescription[] = [];
  id = '';
  names = '';
  target = '';
  symptom = '';
  page = 0;
  totalPages: any;
  pageSize: any;
  firsts: boolean;
  last: boolean;
  message: boolean;
  activeProjectIndex: number;
  flagHover: boolean;
  idChoice: any;
  searchForm: FormGroup;

  constructor(private retailService: RetailService,
              private toastr: ToastrService,
              private router: Router,) {
  }

  ngOnInit(): void {
    this.getAllPrescription();
    this.searchForm = new FormGroup({
      typeSearch: new FormControl(''),
      inputSearch: new FormControl(''),
    });
  }

  /*
 * Created by DaLQA
 * Time: 10:30 AM 3/07/2022
 * Function: function getAllPrescription
 * */
  getAllPrescription() {
    this.retailService.getAllPrescription(this.page, '', '', '', '').subscribe((data: any) => {
      this.prescriptions = data.content;
      this.page = data.pageable.pageNumber;
      this.totalPages = data.totalPages;
      this.pageSize = data.pageable.pageSize;
      this.firsts = data.first;
      this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElements;
    }, error => {
      this.prescriptions = [];
      this.message = true;
    });
  }

  /*
 * Created by DaLQA
 * Time: 10:30 AM 3/07/2022
 * Function: function previous
 * */
  previous() {
    if (this.page > 0) {
      this.retailService.getAllPrescription(this.page - 1, this.id,
        this.names, this.target, this.symptom).subscribe(
        (data: any) => {
          this.prescriptions = data.content;
          this.page = data.number;
          this.firsts = data.first;
          this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElements;
        }, err => {
          console.log(err);
        }
      );
    }
  }

  /*
 * Created by DaLQA
 * Time: 10:30 AM 3/07/2022
 * Function: function next
 * */
  next() {
    if (this.page < this.totalPages - 1) {
      this.retailService.getAllPrescription(this.page + 1, this.id, this.names,
        this.target, this.symptom).subscribe(
        (data: any) => {
          this.prescriptions = data.content;
          this.page = data.number;
          this.firsts = data.first;
          this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElements;
        }, err => {
          console.log(err);
        }
      );
    }
  }

  /*
 * Created by DaLQA
 * Time: 10:30 AM 3/07/2022
 * Function: function activeProject
 * */
  activeProject(k: number, item: any) {
    if (this.activeProjectIndex != k) {
      this.flagHover = true;
    } else {
      this.flagHover = !this.flagHover;
    }
    this.activeProjectIndex = k;
    if (this.flagHover == true) {
      this.idChoice = item.prescriptionId;
      console.log(this.idChoice);
    } else {
      this.idChoice = '';
    }
  }

  /*
 * Created by DaLQA
 * Time: 10:30 AM 3/07/2022
 * Function: function search
 * */
  search() {
    const input = this.searchForm.get('inputSearch').value;
    const type = this.searchForm.get('typeSearch').value;
    if (type === 'id' && input.trim() !== '') {
      this.retailService.getAllPrescription(this.page, this.id = input.trim(), '', '', '').subscribe(
        (data: any) => {
          this.message = false;
          this.prescriptions = data.content;
          this.page = data.pageable.pageNumber;
          this.totalPages = data.totalPages;
          this.firsts = data.first;
          this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElements;
        }, err => {
          this.message = true;
          this.prescriptions = null;
          this.page = 0;
          this.totalPages = 0;
          console.log(err);
        }
      );
    } else if (type === 'names' && input.trim() !== '') {
      this.retailService.getAllPrescription(this.page, this.id = '', this.names = input.trim(),
        this.target = '', this.symptom = '').subscribe(
        (data: any) => {
          this.message = false;
          this.prescriptions = data.content;
          this.page = data.pageable.pageNumber;
          this.totalPages = data.totalPages;
          this.firsts = data.first;
          this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElements;
        }, err => {
          this.message = true;
          this.prescriptions = null;
          this.page = 0;
          this.totalPages = 0;
          console.log(err);
        }
      );
    } else if (type === 'target' && input.trim() !== '') {
      this.retailService.getAllPrescription(this.page, this.id = '', this.names = '',
        this.target = input.trim(), this.symptom = '').subscribe(
        (data: any) => {
          this.message = false;
          this.prescriptions = data.content;
          this.page = data.pageable.pageNumber;
          this.totalPages = data.totalPages;
          this.firsts = data.first;
          this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElements;
        }, err => {
          this.message = true;
          this.prescriptions = null;
          this.page = 0;
          this.totalPages = 0;
          console.log(err);
        }
      );
    } else if (type === 'symptom' && input.trim() !== '') {
      this.retailService.getAllPrescription(this.page, this.id = '', this.names = '',
        this.target = '', this.symptom = input.trim()).subscribe(
        (data: any) => {
          this.message = false;
          this.prescriptions = data.content;
          this.page = data.pageable.pageNumber;
          this.totalPages = data.totalPages;
          this.firsts = data.first;
          this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElements;
        }, err => {
          this.message = true;
          this.prescriptions = null;
          this.page = 0;
          this.totalPages = 0;
          console.log(err);
        }
      );
      //   tslint:disable-next-line:triple-equals
    } else if (input.trim() == '') {
      this.retailService.getAllPrescription(this.page, this.id = '', this.names = '',
        this.target = '', this.symptom = '').subscribe(
        (data: any) => {
          this.message = false;
          this.prescriptions = data.content;
          this.page = data.pageable.pageNumber;
          this.totalPages = data.totalPages;
          this.firsts = data.first;
          this.last = (data.pageable.offset + data.pageable.pageSize) >= data.totalElements;
          console.log(this.prescriptions);
        }, err => {
          this.message = true;
          console.log(err);
        });
    }
  }


  /*
 * Created by DaLQA
 * Time: 10:30 AM 3/07/2022
 * Function: function getEmitChange
 * */
  getEmitChange() {
    if (this.idChoice == '') {
      this.toastr.warning('Vui lòng chọn đơn thuốc !', 'Cảnh báo', {
        timeOut: 3000,
        progressBar: true
      });
      this.router.navigateByUrl('/sales-management/available-prescription');
    }
  }
}
