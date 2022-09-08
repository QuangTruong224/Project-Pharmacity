import {Component, OnInit} from '@angular/core';
import {HomePageService} from "../../service/home-page/home-page.service";
import {MedicineBestSeller} from "../../dto/medicine/medicine-best-seller";
import {ToastrService} from "ngx-toastr";
import {ShareService} from "../../share/ShareService";
import {CartDetailDto} from "../../dto/cart/CartDetailDto";
import {CartService} from "../../service/cart/cart.service";
import {Title} from "@angular/platform-browser";


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  medicineList: Array<MedicineBestSeller> = [];
  medicineBestSellerList: Array<MedicineBestSeller> = [];
  medicineBestSellerList1: Array<MedicineBestSeller> = [];
  medicineBestSellerList2: Array<MedicineBestSeller> = [];
  currentPage: number;
  totalPages: number;
  name: string = '';
  typeId: string = '';
  sort: string = 'idDesc';
  medicineList1: Array<MedicineBestSeller> = [];
  medicineList2: Array<MedicineBestSeller> = [];


  constructor(private homePageService: HomePageService, private toastrService: ToastrService,
              private shareService: ShareService, private cartService: CartService,
              private title: Title) {
    this.shareService.changeEmitted$.subscribe(data => {
      this.name = data.medicineName;
      this.typeId = data.medicineTypeId;
      this.medicineList1=[];
      this.medicineList2=[];
      this.getAllMedicineByNameAndTypeId({page: 0, size: 10, name: this.name, typeId: this.typeId, sort: this.sort});
      let scrollEle = document.getElementById('carouselExampleControls2');
      scrollEle.scrollIntoView();
    })
  }


  ngOnInit(): void {
    this.getAllMedicineBestSeller();
    this.getAllMedicineByNameAndTypeId({page: 0, size: 10});
    this.title.setTitle('Trang chủ - Pharmacode');
    window.scrollBy(0, 0);
  }

  /*
  Created by AnP
  Time: 16:00 02/07/2022
  Function: Get list 10 medicines best seller
  */
  getAllMedicineBestSeller() {
    this.homePageService.getMedicineBestseller().subscribe((medicineBestsellers) => {
      this.medicineBestSellerList = medicineBestsellers;
      for (let i: number = 0; i < this.medicineBestSellerList.length / 2; i++) {
        this.medicineBestSellerList1[i] = this.medicineBestSellerList[i];
      }
      for (let i: number = this.medicineBestSellerList.length / 2; i < this.medicineBestSellerList.length; i++) {
        this.medicineBestSellerList2[i - 5] = this.medicineBestSellerList[i];
      }
    }, error => {
    });

  }

  /*
    Created by AnP
    Time: 16:00 02/07/2022
    Function: Get All Medicine
  */
  getAllMedicineByNameAndTypeId(request) {
    this.homePageService.getMedicineByNameAndTypeId(request).subscribe((data) => {
      if (data != null) {
        this.medicineList = data.content;
        if (this.medicineList.length >= 5){
          for (let i: number = 0; i < 5; i++) {
              this.medicineList1[i] = this.medicineList[i];
          }
          for (let i: number = 5; i < this.medicineList.length; i++) {
            this.medicineList2[i - 5] = this.medicineList[i];
          }
        } else {
          for (let i: number = 0; i < this.medicineList.length; i++) {
            this.medicineList1[i] = this.medicineList[i];
          }
        }
        this.currentPage = data.number;
        this.totalPages = data.totalPages;
      } else {
        this.medicineList = []
        this.currentPage = -1;
        this.totalPages = 0;
      }
    }, error => {
    }, () => {
    });

  }

  /*
  Created by AnP
  Time: 17:00 02/07/2022
  Function: Get All Medicine And Search by medicine_name and medicine_type
  */
  searchMedicine(name: HTMLInputElement, typeId: HTMLSelectElement) {
    this.name = name.value;
    this.typeId = typeId.value;
    this.medicineList1=[];
    this.medicineList2=[];
    this.getAllMedicineByNameAndTypeId({page: 0, size: 10, name: this.name, typeId: this.typeId, sort: this.sort});
  }


  /*
  Created by AnP
  Time: 17:30 02/07/2022
  Function: Get All Medicine And Sort by newest or highest or lowest
  */
  sortMedicine(sort: HTMLSelectElement) {
    this.sort = sort.value
    this.medicineList1=[];
    this.medicineList2=[];
    this.getAllMedicineByNameAndTypeId({page: 0, size: 10, name: this.name, typeId: this.typeId, sort: this.sort});
  }

  /*
  Created by AnP
  Time: 17:30 02/07/2022
  Function: Add medicine to Cart by LocalStorage
  */
  addItemToCart(medicine: MedicineBestSeller) {
    this.cartService.addToCart(medicine, 1);
    if (medicine.medicineQuantity!=0){
      this.showMessageSuccess(medicine.medicineName);
    } else {
      this.showMessageError(medicine.medicineName);
    }
  }

  /*
  Created by AnP
  Time: 18:30 02/07/2022
  Function: Previous Page for method Get All Medicine
  */
  previousPage() {
    const request = {};
    if ((this.currentPage) > 0) {
      request['page'] = this.currentPage - 1;
      request['size'] = 5;
      request['name'] = this.name;
      request['typeId'] = this.typeId;
      request['sort'] = this.sort;
      this.getAllMedicineByNameAndTypeId(request);
    }
  }

  /*
  Created by AnP
  Time: 18:30 02/07/2022
  Function: Next Page for method Get All Medicine
  */
  nextPage() {
    const request = {};
    if ((this.currentPage + 1) < this.totalPages) {
      request['page'] = this.currentPage + 1;
      request['size'] = 10;
      request['name'] = this.name;
      request['typeId'] = this.typeId;
      request['sort'] = this.sort;
      this.medicineList1=[];
      this.medicineList2=[];
      this.getAllMedicineByNameAndTypeId(request);
    }
  }

  showMessageSuccess(medicineName: string) {
    this.toastrService.success('Đã thêm thành công ' + medicineName +' vào giỏ hàng', 'Thông báo', {
      timeOut: 2000,
      progressBar: true,
    });
  }

  showMessageError(medicineName: string) {
    this.toastrService.warning('Thuốc ' + medicineName + ' đã hết hàng', 'Thông báo', {
      timeOut: 2000,
      progressBar: true,
    });
  }

}
