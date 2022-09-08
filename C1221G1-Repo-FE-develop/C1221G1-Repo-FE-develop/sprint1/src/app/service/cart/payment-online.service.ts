import {Injectable} from '@angular/core';
import {CartAndDetailDto} from "../../dto/cart/CartAndDetailDto";
import {BehaviorSubject, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Discount} from '../../model/Discount';
import {CustomerDtoForCart} from '../../dto/cart/CustomerDtoForCart';

const API_URL = 'http://localhost:8080/api/carts';
const API_URL_PAYMENT = 'http://localhost:8080/api/payment-online';

@Injectable({
  providedIn: 'root'
})
export class PaymentOnlineService {

  private cartAndDetail = new BehaviorSubject<CartAndDetailDto>({});

  constructor(private http: HttpClient) {
  }

  /**
   * Created by: KhoaPV
   * Date created: 01/7/2022
   * function: set value of cart and information of medicine, quantity -> data send from webservice
   */
  setCartAndDetail(cartAndDetail: CartAndDetailDto) {
    this.cartAndDetail.next(cartAndDetail);
    console.log("service")
    console.log(this.cartAndDetail)
  }

  /**
   * Created by: KhoaPV
   * Date created: 01/7/2022
   * function: set value of cart and information of medicine, quantity
   */
  getCartAndDetail() {
    return this.cartAndDetail.asObservable();
  }

  /**
   * Created by: KhoaPV
   * Date created: 03/7/2022
   * function: save cart and detail of cart after pay with paypal.
   */
  saveCartAndDetailAPI(cartAndDetailDto: CartAndDetailDto): Observable<any> {
    return this.http.post<CartAndDetailDto>(`${API_URL}/saveCart`, cartAndDetailDto);
  }

  /**
   * Created by: KhoaPV
   * Date created: 05/7/2022
   * function: send discount from user input to webservice, check and response result
   */
  getDiscount(id: string): Observable<Discount> {
    return this.http.get<Discount>(`${API_URL_PAYMENT}/discount/${id}`)
  }



}
