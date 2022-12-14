import {Component, OnInit} from '@angular/core';
import {PrescriptionDetail} from '../../../../dto/prescription/prescriptionDetail';
import {PrescriptionMedicineDetail} from '../../../../dto/prescription/prescriptionMedicineDetail';
import {RetailService} from '../../../../service/retail.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {InvoiceMedicineDto} from '../../../../dto/invoice/invoiceMedicineDto';
import {ListMedicineChoice} from '../../../../dto/invoice/listMedicineChoice';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
import {TokenStorageService} from "../../../../service/security/token-storage.service";
import {Employee} from "../../../../model/employee/employee";

pdfMake.vfs = pdfFonts.pdfMake.vfs;

@Component({
  selector: 'app-prescription-detail',
  templateUrl: './prescription-detail.component.html',
  styleUrls: ['./prescription-detail.component.css']
})
export class PrescriptionDetailComponent implements OnInit {

  idChoice: string;
  prescriptionDetail: PrescriptionDetail;
  listPrescriptionMedicine: PrescriptionMedicineDetail[] = [];
  invoiceMedicineDtos: InvoiceMedicineDto[] = [];
  totalMoney = 0;
  activeProjectIndex: number;
  flagHover: Boolean;
  idDelete = '';
  nameDelete: any;
  deleteErr: string;
  printInvoice: string;
  arrPDF = [];
  user: any;
  employee: Employee;
  isComplete = false;
  selectedRowIds: Set<String> = new Set<String>();
  listDeletedName: Set<String> = new Set<String>();

  constructor(private retailService: RetailService,
              private route: ActivatedRoute,
              private toastr: ToastrService,
              private router: Router,
              private tokenStorageService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((paramMap: ParamMap) => {
      this.idChoice = paramMap.get('id');
      this.getPrescriptionDetail(this.idChoice);
      this.getPrescriptionMedicineDetail(this.idChoice);
      console.log(this.prescriptionDetail);
    });
    this.getEmployee();
  }

  /*
* Created by DaLQA
* Time: 10:30 AM 3/07/2022
* Function: function getPrescriptionDetail
* */
  getPrescriptionDetail(prescriptionId: string) {
    this.retailService.getPrescriptionDetail(prescriptionId).subscribe(res => {
      this.prescriptionDetail = res;
      console.log(this.prescriptionDetail);
    });
  }

  /*
* Created by DaLQA
* Time: 10:30 AM 3/07/2022
* Function: function getPrescriptionMedicineDetail
* */
  getPrescriptionMedicineDetail(prescriptionId: string) {
    this.retailService.getPrescriptionMedicineDetail(prescriptionId).subscribe(res => {
      this.listPrescriptionMedicine = res;
      for (let item of this.listPrescriptionMedicine) {
        item.retailPrice = Math.floor(item.retailPrice);
        item.money = item.retailPrice * item.totalQuantity;
      }
      this.getTotalMoney();
    })
  }

  /*
* Created by DaLQA
* Time: 10:30 AM 3/07/2022
* Function: function createRetailInvoice
* */
  createRetailInvoice() {
    for (let medicine of this.listPrescriptionMedicine) {
      let invoiceMedicineDto: any = {
        medicineId: medicine.medicineId,
        quantity: medicine.totalQuantity
      };
      this.invoiceMedicineDtos.push(invoiceMedicineDto);
    }
    let invoiceDto: any = {
      customerId: 'KH-00001',
      employeeId: this.employee.employeeId,
      invoiceNote: 'no comment',
      invoiceMedicineList: this.invoiceMedicineDtos
    };
    console.log(invoiceDto);
    if (invoiceDto.invoiceMedicineList.length < 1) {
      this.toastr.warning("????n ch??a c?? thu???c !", "C???nh b??o", {
        timeOut: 3000,
        progressBar: true
      });
    } else {
      this.retailService.createRetailInvoice(invoiceDto).subscribe(
        () => {
          this.toastr.success('Thanh to??n th??nh c??ng !', 'Th??ng b??o', {
            timeOut: 3000,
            progressBar: true
          });
          this.isComplete = true;
          invoiceDto.invoiceMedicineList = [];
          this.invoiceMedicineDtos = [];
          this.router.navigateByUrl('/sales-management/prescription-detail/' + this.idChoice);
        }, error => {
          this.toastr.warning(error.error.errors, 'C???nh b??o', {
            timeOut: 3000,
            progressBar: true
          });
          this.invoiceMedicineDtos = [];
          invoiceDto.invoiceMedicineList = [];
          console.log(error);
        }
      );
    }
  }

  /*
 * Created by DaLQA
 * Time: 10:30 AM 3/07/2022
 * Function: function resetIdAndName
 * */
  resetIdAndName() {
    this.idDelete = '';
    this.nameDelete = '';
  }

  /*
* Created by DaLQA
* Time: 10:30 AM 3/07/2022
* Function: function getTotalMoney
* */
  getTotalMoney() {
    this.totalMoney = 0;
    for (let item of this.listPrescriptionMedicine) {
      this.totalMoney += item.money;
    }
  }

  /*
 * Created by DaLQA
 * Time: 10:30 AM 3/07/2022
 * Function: function print
 * */
  print(yes: string) {
    if (this.isComplete == true) {
      if (this.listPrescriptionMedicine.length > 0) {
        this.arrPDF.push(['S???n ph???m', 'S??? l?????ng', 'Gi?? ti???n(VND)', 'T???ng ti???n(VND)'],);
        for (let item of this.listPrescriptionMedicine) {
          this.arrPDF.push([item.medicineName, item.totalQuantity, item.retailPrice, item.money]);
        }
        this.printInvoice = yes;
        this.generatePDF(this.printInvoice);
      } else {
        this.toastr.warning("Vui l??ng ch???n thu???c tr?????c khi in h??a ????n !", "C???nh b??o", {
          timeOut: 3000,
          progressBar: true
        });
      }
      this.arrPDF = [];
    } else {
      this.toastr.warning("Vui l??ng ch???n thanh to??n khi in h??a ????n !", "C???nh b??o", {
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
  private generatePDF(action: string) {
    const docDefinition = {
      content: [
        {
          text: 'C1221G1 PHARMACODE',
          fontSize: 30,
          alignment: 'center',
          color: '#047886'
        },
        {
          text: 'H??a ????n mua thu???c',
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
                text: `Ng??y: ${new Date().toLocaleString()}`,
                alignment: 'right'
              },
            ]
          ]
        },
        {
          text: 'Chi ti???t h??a ????n:',
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
          text: 'Th??nh ti???n:',
          style: 'sectionHeader'
        },
        {
          columns: [
            [this.totalMoney + ' VND'],
          ]
        },

        {
          text: 'Chi ti???t b??? sung:',
          style: 'sectionHeader',
          color: '#865604'
        },
        {
          columns: [
            [{qr: `lqad1649engineer@gmail.com`, fit: '50'}],
          ]
        },
        {
          text: 'C??c ??i???u kho???n v?? ??i???u ki???n:',
          style: 'sectionHeader',
          color: '#865604'
        },
        {
          ul: [
            'H??a ????n c?? th??? ???????c tr??? l???i sau kh??ng qu?? 3 ng??y.',
            'S??? kh??ng ch???p nh???n ho??n tr??? n???u thu???c kh??ng ???????c nguy??n v???n.',
            '????y l?? h??a ????n do h??? th???ng t???o.',
          ],
        }
      ],
      styles: {
        sectionHeader: {
          bold: true,
          decoration: 'underline',
          fontSize: 14,
          margin: [0, 15, 0, 15]
        }
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
        ;
      })
    }, error => {
      console.log(error)
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

  /*
 * Created by DaLQA
 * Time: 10:30 AM 3/07/2022
 * Function: rowIsSelected returns the record you selected
 * */
  rowIsSelected(id: string) {
    return this.selectedRowIds.has(id);
  }
  /*
 * Created by DaLQA
 * Time: 10:30 AM 3/07/2022
 * Function: get the list medicine name you have delete
 * */
  getNameDelete() {
    for (let id of this.selectedRowIds) {
      for (let item of this.listPrescriptionMedicine) {
        if (item.medicineId == id && !this.listDeletedName.has(item.medicineName)) {
          this.listDeletedName.add(item.medicineName);
        }
      }
    }
  }

  /*
 * Created by DaLQA
 * Time: 10:30 AM 3/07/2022
 * Function: delete records you have selected
 * */
  deleteLotsOfMedicine(closeModal: HTMLButtonElement) {
    if (this.selectedRowIds.size > 0) {
      for (let id of this.selectedRowIds) {
        this.listPrescriptionMedicine = this.listPrescriptionMedicine.filter(
          (item) => {
            return item.medicineId != id;
          });
        this.selectedRowIds.delete(id);
      }
      this.toastr.success("X??a th??nh c??ng !", "Th??ng b??o", {
        timeOut: 3000,
        progressBar: true
      });
      this.listDeletedName.clear();
      this.getTotalMoney();
      closeModal.click();
    }
  }
}
