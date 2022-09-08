import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router, UrlSegment} from '@angular/router';
import {MedicineDetailDto} from '../../../dto/medicine/medicine-detail.model';
import {MedicineService} from '../medicine.service';
import {ToastrService} from 'ngx-toastr';
import {CartService} from '../../../service/cart/cart.service';
import {Title} from '@angular/platform-browser';

const MAXIMUM_QUANTITY_ALLOWED = 10;

@Component({
  selector   : 'app-medicine-detail',
  templateUrl: './medicine-detail.component.html',
  styleUrls  : ['./medicine-detail.component.css']
})
export class MedicineDetailComponent implements OnInit {

  medicineId: string;
  medicine: MedicineDetailDto;
  relativeMedicineList: MedicineDetailDto[];
  quantity = 1;
  toastrOptions = {
    preventOpenDuplicates: true,
    timeOut              : 5000
  };

  constructor(private toastr: ToastrService,
              private cartService: CartService,
              private router: Router,
              private title: Title,
              private medicineService: MedicineService,
              private activatedRoute: ActivatedRoute) {

  }

  /**
   * @Author NghiaNTT
   * @Time: 03/07/2022
   * @param
   * @return get medicine and its relatives.
   */
  ngOnInit(): void {
    this.activatedRoute.url.subscribe((s: UrlSegment[]) => {
      this.quantity = 1;
      this.medicineId = s[s.length - 1].path;
      this.medicineService.getMedicineDetailForView(this.medicineId).subscribe(
        medicine => {
          this.medicine = medicine;
          this.title.setTitle(`${this.medicine.medicineName}`)
          this.scrollToTopOfScrollable()
        }, err => {
          this.router.navigateByUrl("not-found");
        }
      );
      this.medicineService.get5RelativeMedicinesOf(this.medicineId).subscribe(
        data => {
          this.relativeMedicineList = data;
        }, err => console.log(err)
      );
    });
  }

  /**
   * @Author NghiaNTT
   * @Time: 03/07/2022
   * @param
   * @return increase quantity when user click [-] button
   */
  increaseQuantity() {
    this.quantity++;
    if (this.quantity > MAXIMUM_QUANTITY_ALLOWED) {
      this.quantity = MAXIMUM_QUANTITY_ALLOWED;
      this.toastr.warning(
        `Bạn chỉ được mua tối đa ${MAXIMUM_QUANTITY_ALLOWED} sản phảm`,
        '',
        {...this.toastrOptions});
    } else if (this.quantity > this.medicine.medicineQuantity) {
      this.quantity = this.medicine.medicineQuantity;
      this.toastr.warning(
        `Số lượng sản phảm còn lại không đủ`,
        '',
        {...this.toastrOptions});
    }
  }

  /**
   * @Author NghiaNTT
   * @Time: 03/07/2022
   * @param
   * @return decrease quantity when user click [+] button
   */
  decreaseQuantity() {
    this.quantity--;
    if (this.quantity < 1) {
      this.quantity = 1;
    }
  }

  /**
   * @Author NghiaNTT
   * @Time: 03/07/2022
   * @param
   * @return add item and quantity to localstorage
   */
  addItemToCart() {
    this.cartService.addToCart(
      {
        medicineId: this.medicine.medicineId,
        medicineName: this.medicine.medicineName,
        medicineImage: this.medicine.medicineImage,
        medicinePrice: this.medicine.medicinePrice
      }, this.quantity);
    this.toastr.success(`Thêm thành công ${this.quantity} sản phẩm vào giỏ hàng`, '', {
      timeOut    : 3000,
      progressBar: false
    });
    this.quantity = 1;
  }

  /**
   * @Author NghiaNTT
   * @Time: 03/07/2022
   * @param
   * @return scroll to top when view is checked
   */
  scrollToTopOfScrollable() {
    window.scrollBy(0, -window.innerHeight);
  }
  /**
   * @Author NghiaNTT
   * @Time: 03/07/2022
   * @param
   * @return add 1 item to cart and navigate to cart
   */
  buyNow() {
    this.cartService.addToCart(
      {
        medicineId: this.medicine.medicineId,
        medicineName: this.medicine.medicineName,
        medicineImage: this.medicine.medicineImage,
        medicinePrice: this.medicine.medicinePrice
      }, 1);
    this.router.navigateByUrl('cart');
  }
}
