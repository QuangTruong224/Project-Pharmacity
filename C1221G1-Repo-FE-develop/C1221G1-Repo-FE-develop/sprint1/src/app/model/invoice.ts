import {Employee} from "./employee/employee";

import {Customer} from "./customer";

export interface Invoice {
  invoiceId?: string;
  customer?: Customer;
  employee?: Employee;
  invoiceNote?: string;
  invoiceCreatedDate?: string;
  invoiceCreateTime?: string;
  flag?: boolean;
}
