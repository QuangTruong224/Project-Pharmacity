
import {CustomerType} from './customer-type';
import {Users} from '../users/users';

export interface Customer {
  customerId: string;
  customerName: string;
  customerBirthday: string;
  customerGender: number;
  customerAddress: string;
  customerPhone: string;
  customerNote: string;
  flag: boolean;
  customerUsername: Users;
  customerType: CustomerType;
}
