import {Component, OnInit} from '@angular/core';
import {CartService} from '../../../service/cart/cart.service';
import {Router} from '@angular/router';
import {CartDetailDto} from '../../../dto/cart/CartDetailDto';
import {MedicineDtoForCart} from '../../../dto/cart/MedicineDtoForCart';
import {CartAndDetailDto} from '../../../dto/cart/CartAndDetailDto';
import {PaymentOnlineService} from '../../../service/cart/payment-online.service';
import {TokenStorageService} from "../../../service/security/token-storage.service";
import {Title} from "@angular/platform-browser";
import {CustomerDtoForCart} from "../../../dto/cart/CustomerDtoForCart";


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartDetails: CartDetailDto [] = [];
  total = 0;
  medicineDelete = {} as MedicineDtoForCart;
  medicineErrorArray: string[] = [];
  display = 'none';
  username: string;

  constructor(private cartService: CartService,
              private title: Title,
              private route: Router,
              private paymentOnlineService: PaymentOnlineService,
              private tokenStorageService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.title.setTitle('Giỏ hàng - Pharmacycode');
    if (this.tokenStorageService.getUser() != null) {
      this.username = this.tokenStorageService.getUser().username;
      console.log(this.username);
    }
    this.cartDetails = this.cartService.getCart();
    this.total = this.getTotal();
    window.scrollBy(0, 0);
  }

  reload() {
    this.ngOnInit();
  }

  /**
   * Created by: KhoaPV
   * Date created: 01/7/2022
   * function: Get all item in cart and call service, send it to webService to confirm cart.
   */
  confirmCart() {
    let cartAndDetailDto = {} as CartAndDetailDto;
    cartAndDetailDto.cartDetail = this.cartDetails;
    if (this.username != null) {
      let customer = {} as CustomerDtoForCart;
      customer.customerUserName = this.username;
      cartAndDetailDto.customer = customer;
    }
    this.cartService.sendCartDetailToAPI(cartAndDetailDto).subscribe(data => {
      // this.paymentOnlineService.setCartAndDetailDto(data);
      this.paymentOnlineService.setCartAndDetail(data);
      this.route.navigate(['cart/payment-online']);
    }, error => {
      this.medicineErrorArray = [];
      for (let i = 0; i < cartAndDetailDto.cartDetail.length; i++) {
        console.log('cartDetail[' + i + '].medicine');
        console.log(error.error['cartDetail[' + i + '].medicine']);
        if (error.error['cartDetail[' + i + '].medicine'] != undefined ||
          error.error['cartDetail[' + i + '].medicine'] != null) {
          this.medicineErrorArray.push(error.error['cartDetail[' + i + '].medicine']);
        }
        this.openModal();
      }
    });
  }

  /**
   * Created by: KhoaPV
   * Date created: 01/7/2022
   * function: Remove item in cart, recalculate total of cart.
   */
  removeItem(medicine: MedicineDtoForCart) {
    this.cartService.removeItemFromCart(medicine);
    this.cartDetails = this.cartService.getCart();
    this.total = this.getTotal();
  }

  /**
   * Created by: KhoaPV
   * Date created: 01/7/2022
   * function: reduce quantity item in cart, recalculate total of cart.
   */
  reduceItem(medicine: MedicineDtoForCart) {
    this.cartService.addToCart(medicine, -1);
    this.cartDetails = this.cartService.getCart();
    this.total = this.getTotal();

  }

  /**
   * Created by: KhoaPV
   * Date created: 01/7/2022
   * function: increase quantity item in cart, recalculate total of cart.
   */
  increaseItem(medicine: MedicineDtoForCart) {
    this.cartService.addToCart(medicine, 1);
    this.cartDetails = this.cartService.getCart();
    this.total = this.getTotal();
  }

  /**
   * Created by: KhoaPV
   * Date created: 01/7/2022
   * function: calculate total money of cart.
   */
  getTotal(): number {
    let total = 0;
    if (this.cartDetails != null) {
      this.cartDetails.forEach(item => {
        total += (item.quantity * item.medicine.medicinePrice);
      });
    }
    return total;
  }

  /**
   * Created by: KhoaPV
   * Date created: 01/7/2022
   * function: Get information of medicine when user click remove button.
   */
  getMedicineDelete(medicine: MedicineDtoForCart) {
    this.medicineDelete = medicine;
  }

  /**
   * Created by: KhoaPV
   * Date created: 01/7/2022
   * function: show modal on screen.
   */
  openModal() {
    // this.display = 'block';
    document.getElementById('openModalButton').click();
  }

}
