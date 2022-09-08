import {CartDetailDto} from './CartDetailDto';
import {Discount} from '../../model/Discount';
import {CustomerDtoForCart} from './CustomerDtoForCart';

export interface CartAndDetailDto {
  id?: number;
  discount?: Discount;
  customer?: CustomerDtoForCart;
  cartDetail?: CartDetailDto[];
  dateCreate?: string;
}
