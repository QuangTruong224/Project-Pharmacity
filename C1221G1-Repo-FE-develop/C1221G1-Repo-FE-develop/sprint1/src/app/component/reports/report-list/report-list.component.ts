import {ReportService} from "../../../service/report.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ToastrService} from "ngx-toastr";
import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-report-list',
  templateUrl: './report-list.component.html',
  styleUrls: ['./report-list.component.css']
})
export class ReportListComponent implements OnInit {
  reportForm: FormGroup;
  constructor(private reportService: ReportService,
              private toastr: ToastrService) { }

  ngOnInit(): void {
    this.reportForm = new FormGroup({
      startTime: new FormControl('', [Validators.required]),
      endTime: new FormControl('', [Validators.required]),
      type: new FormControl('', [Validators.required])
    });
  }

  onSubmit() {
    console.log(this.reportForm.value.type);
    console.log(this.reportForm.value.startTime);
    console.log(this.reportForm.value.endTime);
    console.log(this.reportForm.valid);
    if (this.reportForm.value.type === '1' || this.reportForm.value.type === '2') {
      // **
      // * this method to export excel file for revenue and profit
      // * @author DinhH
      // * @Time 15:30 04/07/2022
      // */
      if (this.reportForm.valid && this.reportForm.value.startTime <= this.reportForm.value.endTime) {
        this.reportService.getRevenue(this.reportForm.value.startTime, this.reportForm.value.endTime)
          .subscribe( revenues => {
            console.log(revenues);
            if (revenues == null) {
              revenues = [];
            }
            this.reportService.exportExcel(revenues, 'Doanh thu, lợi nhuận từ ' + this.reportForm.value.startTime +
              ' đến ' + this.reportForm.value.endTime);
            this.toastr.success('Tải thành công!', 'Thông báo', {
              timeOut: 3000,
              progressBar: true
            });
          });
      } else {
        this.toastr.warning('Ngày tháng không hợp lệ!', 'Thông báo', {
          timeOut: 3000,
          progressBar: true
        });
      }
    } else if (this.reportForm.value.type === '3') {
      // **
      // * this method to export excel file for receivable from supplier
      // * @author DinhH
      // * @Time 15:30 04/07/2022
      // */
      this.reportService.getSupplierHaveReceivable()
        .subscribe( supplierHaveReceivable => {
          this.reportService.exportExcel(supplierHaveReceivable, 'Công nợ nhà cung cấp');
          this.toastr.success('Tải thành công!', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
        });
    } else if (this.reportForm.value.type === '4') {
      // **
      // * this method to export excel file for revenue by employee
      // * @author DinhH
      // * @Time 15:30 04/07/2022
      // */
      if (this.reportForm.valid && this.reportForm.value.startTime <= this.reportForm.value.endTime) {
        this.reportService.getRevenueByEmployee(this.reportForm.value.startTime, this.reportForm.value.endTime)
          .subscribe( revenueByEmployee => {
            if (revenueByEmployee == null) {
              revenueByEmployee = [];
            }
            this.reportService.exportExcel(revenueByEmployee, 'Doanh thu theo nhân viên từ ' + this.reportForm.value.startTime +
              ' đến ' + this.reportForm.value.endTime);
            this.toastr.success('Tải thành công!', 'Thông báo', {
              timeOut: 3000,
              progressBar: true
            });
          });
      } else {
        this.toastr.warning('Ngày tháng không hợp lệ!', 'Thông báo', {
          timeOut: 3000,
          progressBar: true
        });
      }
    } else if (this.reportForm.value.type === '5') {
      // **
      // * this method to export excel file for medicine list need to import
      // * @author DinhH
      // * @Time 15:30 04/07/2022
      // */
      this.reportService.getMedicineNeedToImport()
        .subscribe( medicineNeedToImport => {
          this.reportService.exportExcel(medicineNeedToImport, 'Danh sách thuốc cần nhập thêm');
          this.toastr.success('Tải thành công!', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
        });
    } else if (this.reportForm.value.type === '6') {
      // **
      // * this method to export excel file for medicine list that to be about expired
      // * @author DinhH
      // * @Time 15:30 04/07/2022
      // */
      this.reportService.getMedicineBeAboutExpired()
        .subscribe( medicineBeAboutExpired => {
          // console.log(medicineBeAboutExpired);
          this.reportService.exportExcel(medicineBeAboutExpired, 'Danh sách thuốc sắp hết hạn');
          this.toastr.success('Tải thành công!', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
        });
    } else if (this.reportForm.value.type === '7') {
      // **
      // * this method to export excel file for medicine list that have top seller
      // * @author DinhH
      // * @Time 15:30 04/07/2022
      // */
      this.reportService.getTopMedicine()
        .subscribe( topMedicine => {
          this.reportService.exportExcel(topMedicine, 'Top 100 thuốc bán chạy');
          this.toastr.success('Tải thành công!', 'Thông báo', {
            timeOut: 3000,
            progressBar: true
          });
        });
    } else if (this.reportForm.value.type == '') {
      this.toastr.warning('Vui lòng chọn mẫu báo cáo', 'Thông báo', {
        timeOut: 5000,
        progressBar: true
      });
    } else if (this.reportForm.value.type != null) {
      this.toastr.warning('Tính năng đang được cập nhật!', 'Thông báo', {
        timeOut: 5000,
        progressBar: true
      });
    }
  }
}
