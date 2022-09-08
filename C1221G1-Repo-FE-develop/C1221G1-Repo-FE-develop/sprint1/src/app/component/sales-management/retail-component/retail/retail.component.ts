import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms'
import {RetailService} from "../../../../service/retail.service";
import {MedicineSale} from "../../../../dto/invoice/medicineSale";
import {InvoiceMedicineDto} from "../../../../dto/invoice/invoiceMedicineDto";
import {ListMedicineChoice} from "../../../../dto/invoice/listMedicineChoice";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
import {TokenStorageService} from "../../../../service/security/token-storage.service";
import {Employee} from "../../../../model/employee/employee";

pdfMake.vfs = pdfFonts.pdfMake.vfs;

@Component({
  selector: 'app-retail',
  templateUrl: './retail.component.html',
  styleUrls: ['./retail.component.css']
})
export class RetailComponent implements OnInit {
  invoiceForm: FormGroup;
  medicineSales: MedicineSale[] = [];
  invoiceMedicineDtos: InvoiceMedicineDto[] = [];
  listMedicineChoice: ListMedicineChoice[] = [];
  note: string;
  localDateTime: any;
  totalMoney = 0;
  nameDelete: string;
  isDisabled = true;
  disableFlag = true;
  printInvoice: string;
  arrPDF = [];
  user: any;
  employee: Employee;
  isComplete = false;
  listPrintPDF = [];
  totalMoneyPrint = 0;
  selectedRowIds: Set<String> = new Set<String>();
  listDeletedName: Set<String> = new Set<String>();

  constructor(private retailService: RetailService,
              private router: Router,
              private toastr: ToastrService,
              private tokenStorageService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.invoiceForm = new FormGroup({
      medicineSale: new FormControl('', [Validators.required]),
      quantity: new FormControl('', [Validators.pattern('[0-9]*')]),
      unit: new FormControl('', [Validators.required])
    })
    this.getMedicineDto();
    this.localDateTime = new Date().toLocaleDateString();
    this.getEmployee();
  }

  /*
* Created by DaLQA
* Time: 10:30 AM 3/07/2022
* Function: function getMedicineDto
* */
  getMedicineDto() {
    this.retailService.getMedicineDto().subscribe(medicineSales => {
      this.medicineSales = medicineSales;
    }, error => {
      console.log(error)
    })
  }

  /*
* Created by DaLQA
* Time: 10:30 AM 3/07/2022
* Function: function addListMedicine
* */
  addListMedicine() {
    this.listPrintPDF = [];
    let idChoice = this.invoiceForm.value.medicineSale.medicineId;
    let nameChoice = this.invoiceForm.value.medicineSale.medicineName;
    let quantityChoice = this.invoiceForm.value.quantity;
    let unitChoice = this.invoiceForm.value.unit;
    let priceChoice: number;
    if (unitChoice == 'vien') {
      priceChoice = Math.floor(1 * this.invoiceForm.value.medicineSale.retailPrice);
    } else if (unitChoice == 'vi') {
      priceChoice = Math.floor(10 * this.invoiceForm.value.medicineSale.retailPrice);
    } else if (unitChoice == 'hop') {
      priceChoice = Math.floor(100 * this.invoiceForm.value.medicineSale.retailPrice);
    }
    let moneyChoice = quantityChoice * priceChoice
    let flag = false;
    let medicine: any = {
      medicineId: idChoice,
      medicineName: nameChoice,
      retailPrice: priceChoice,
      quantity: quantityChoice,
      unit: unitChoice,
      money: moneyChoice,
    };
    const myArray = this.listMedicineChoice;
    const test = myArray.filter(data => data.medicineId == medicine.medicineId && medicine.medicineId != '')
    if (idChoice == undefined || idChoice == '' || idChoice == null ||
      nameChoice == '' || quantityChoice == '' || unitChoice == '' || test.length > 0
      || quantityChoice < 1 || unitChoice != 'vien' && unitChoice != 'vi' && unitChoice != 'hop') {
      flag = true;
    } else {
      flag = false;
    }
    if (!flag) {
      this.isDisabled = false;
      this.listMedicineChoice.push(medicine);
    } else {
      this.isDisabled = true;
    }
    this.getTotalMoney();
    this.resetForm();
    this.ngOnInit();
  }

  /*
* Created by DaLQA
* Time: 10:30 AM 3/07/2022
* Function: function resetForm
* */
  resetForm() {
    this.invoiceForm = new FormGroup({
      medicineSale: new FormControl(''),
      quantity: new FormControl(''),
      unit: new FormControl('')
    })
  }

  /*
* Created by DaLQA
* Time: 10:30 AM 3/07/2022
* Function: function createRetailInvoice
* */
  createRetailInvoice() {
    for (let medicine of this.listMedicineChoice) {
      let invoiceMedicineDto: any = {
        medicineId: medicine.medicineId,
        quantity: medicine.quantity
      }
      this.invoiceMedicineDtos.push(invoiceMedicineDto);
    }
    let invoiceDto: any = {
      customerId: 'KH-00001',
      employeeId: this.employee.employeeId,
      invoiceNote: this.note,
      invoiceMedicineList: this.invoiceMedicineDtos
    };
    if (invoiceDto.invoiceMedicineList.length < 1) {
      this.toastr.warning("Danh sách thuốc trống !", "Cảnh báo", {
        timeOut: 3000,
        progressBar: true
      });
    } else {
      this.retailService.createRetailInvoice(invoiceDto).subscribe(
        () => {
          this.toastr.success("Thanh toán thành công !", "Thông báo", {
            timeOut: 3000,
            progressBar: true
          });
          for (let item of this.listMedicineChoice) {
            this.listPrintPDF.push(item);
          }
          this.isComplete = true;
          this.totalMoneyPrint = this.totalMoney;
          this.resetCreateForm();
        }, error => {
          console.log(error);
          this.toastr.warning(error.error.errors, "Cảnh báo", {
            timeOut: 3000,
            progressBar: true
          });
          this.resetCreateForm();
        }
      )
    }
  }

  /*
 * Created by DaLQA
 * Time: 10:30 AM 3/07/2022
 * Function: function getTotalMoney
 * */
  getTotalMoney() {
    this.totalMoney = 0;
    for (let item of this.listMedicineChoice) {
      this.totalMoney += item.money;
    }
  }

  /*
* Created by DaLQA
* Time: 10:30 AM 3/07/2022
* Function: function changeIsDisabled
* */
  changeIsDisabled() {
    this.isDisabled = false;
  }

  /*
* Created by DaLQA
* Time: 10:30 AM 3/07/2022
* Function: function print
* */
  print() {
    if (this.isComplete == true) {
      if (this.listPrintPDF.length > 0) {
        this.arrPDF.push(['Sản phẩm', 'Số lượng', 'Giá tiền(VND)', 'Thành tiền(VND)'],);
        for (let item of this.listPrintPDF) {
          this.arrPDF.push(
            [item.medicineName,
              item.quantity,
              item.retailPrice.toLocaleString('it-IT', {style: 'currency', currency: 'VND'}),
              item.money.toLocaleString('it-IT', {style: 'currency', currency: 'VND'})]
          );
        }
        this.printInvoice = 'yes';
        this.generatePDF(this.printInvoice);
      } else {
        this.toastr.warning("Vui lòng chọn thuốc trước khi in hóa đơn !", "Cảnh báo", {
          timeOut: 3000,
          progressBar: true
        });
      }
      this.arrPDF = [];
      this.totalMoneyPrint = 0;
    } else {
      this.toastr.warning("Vui lòng chọn thanh toán khi in hóa đơn !", "Cảnh báo", {
        timeOut: 3000,
        progressBar: true
      });
    }
  }

  /*
* Created by DaLQA
* Time: 10:30 AM 3/07/2022
* Function: function generatePDF
* */
  generatePDF(action: string) {
    console.log(this.listMedicineChoice);
    const docDefinition = {
      content: [
        {
          text: 'C1221G1 PHARMACODE',
          fontSize: 30,
          alignment: 'center',
          color: '#047886'
        },
        {
          text: 'Hóa đơn mua thuốc',
          fontSize: 20,
          bold: true,
          alignment: 'center',
          decoration: 'underline',
          color: 'skyblue'
        },
        {
          columns: [
            [
              {
                text: `Ngày: ${new Date().toLocaleString()}`,
                alignment: 'right'
              },
            ]
          ]
        },
        {
          text: 'Chi tiết hóa đơn:',
          style: 'sectionHeader',
          color: '#865604'
        },
        {
          table: {
            // headers are automatically repeated if the table spans over multiple pages
            // you can declare how many rows should be treated as headers
            headerRows: 1,
            widths: ['*', 'auto', 100, '*'],
            body: this.arrPDF
          }
        },
        {
          text: 'Tổng tiền:',
          style: 'sectionHeader'
        },
        {
          columns: [
            [this.totalMoneyPrint.toLocaleString('it-IT', {style: 'currency', currency: 'VND'})],
          ]
        },
        {
          text: 'Người lập hóa đơn:',
          style: 'sectionHeader',
          color: '#865604'
        },
        {
          columns: [
            [this.employee.employeeName],
          ]
        },

        {
          text: 'Các điều khoản và điều kiện:',
          style: 'sectionHeader',
          color: '#865604'
        },
        {
          ul: [
            'Hóa đơn có thể được trả lại sau không quá 3 ngày.',
            'Sẽ không chấp nhận hoàn trả nếu thuốc không được nguyên vẹn.',
            'Đây là hóa đơn do hệ thống tạo.',
          ],
        }
      ],
      styles: {
        sectionHeader: {
          bold: true,
          decoration: 'underline',
          fontSize: 14,
          margin: [0, 15, 0, 15]
        },
      }
    };
    if (action === 'yes') {
      pdfMake.createPdf(docDefinition).download('hoa_don.pdf');
    }
  }

  /*
* Created by DaLQA
* Time: 10:30 AM 3/07/2022
* Function: function getEmployee
* */
  getEmployee() {
    this.user = this.tokenStorageService.getUser();
    this.retailService.getListEmployee().subscribe(employees => {
      employees.forEach(e => {
        if (e.employeeUsername.username == this.user.username) {
          this.employee = e;
        }
      });
    }, error => {
      console.log(error);
    });
  }

  /*
* Created by DaLQA
* Time: 10:30 AM 3/07/2022
* Function: function onRowClick get medicineId when click a random row
* */
  onRowClick(medicineId: string) {
    if (this.selectedRowIds.has(medicineId)) {
      this.selectedRowIds.delete(medicineId);
    } else {
      this.selectedRowIds.add(medicineId);
    }
    console.log(this.selectedRowIds);
    this.getNameDelete();
  }

  rowIsSelected(id: string) {
    return this.selectedRowIds.has(id);
  }

  /*
 * Created by DaLQA
 * Time: 10:30 AM 3/07/2022
 * Function: function deleteLotsOfMedicine
 * */
  deleteLotsOfMedicine(closeModal: HTMLButtonElement) {
    if (this.selectedRowIds.size > 0) {
      for (let id of this.selectedRowIds) {
        this.listMedicineChoice = this.listMedicineChoice.filter(
          (item) => {
            return item.medicineId != id;
          });
        this.selectedRowIds.delete(id);
      }
      this.toastr.success("Xóa thành công !", "Thông báo", {
        timeOut: 3000,
        progressBar: true
      });
      this.listDeletedName.clear();
      this.getTotalMoney();
      closeModal.click();
    }
  }

  /*
 * Created by DaLQA
 * Time: 10:30 AM 3/07/2022
 * Function: function resetCreateForm
 * */
  resetCreateForm() {
    this.listMedicineChoice = [];
    this.invoiceMedicineDtos = [];
    this.totalMoney = 0;
  }

  /*
 * Created by DaLQA
 * Time: 10:30 AM 3/07/2022
 * Function: function getNameDelete
 * */
  getNameDelete() {
    for (let id of this.selectedRowIds) {
      for (let item of this.listMedicineChoice) {
        if (item.medicineId == id && !this.listDeletedName.has(item.medicineName)) {
          this.listDeletedName.add(item.medicineName);
        }
      }
    }
  }
}

