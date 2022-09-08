import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {NotFoundComponent} from './component/not-found/not-found.component';
import {HomePageComponent} from './component/home-page/home-page.component';

const routes: Routes = [
  {
    path: '', pathMatch: 'full', redirectTo: 'home-page'
  },
  {path: 'home-page', component: HomePageComponent},
  {
    path: 'customer',
    loadChildren: () => import('./component/customer/customer.module').then(module => module.CustomerModule)
  },
  {

    path: 'customer',
    loadChildren: () => import('./component/customer/customer.module').then(module => module.CustomerModule)
  },
  {
    path: 'employee',
    loadChildren: () => import('./component/employee/employee.module').then(module => module.EmployeeModule)
  },
  {
    path: 'account',
    loadChildren: () => import('./component/account/account.module').then(module => module.AccountModule)
  },
  {
    path: 'admin-chat',
    loadChildren: () => import('./component/admin-chat/admin-chat.module').then(module => module.AdminChatModule),
  },
  {
    path: 'log',
    loadChildren: () => import('./component/security/log.module').then(module => module.LogModule)
  },
  {
    path: 'medicine',
    loadChildren: () => import('./component/medicine/medicine.module').then(module => module.MedicineModule)
  },
  {
    path: 'look-up',
    loadChildren: () => import('./component/look-up/look-up.module').then(module => module.LookUpModule)
  },
  {
    path: 'cart',
    loadChildren: () => import('./component/cart/cart.module').then(module => module.CartModule)
  },
  {
    path: 'prescription',
    loadChildren: () => import('./component/prescription/prescription.module').then(module => module.PrescriptionModule)
  },
  {
    path: 'reports',
    loadChildren: () => import('./component/reports/report.module').then(module => module.ReportModule)
  },
  {
    path: 'sales-management',
    loadChildren: () => import('./component/sales-management/sales-management.module').then(module => module.SalesManagementModule)
  },
  {
    path: 'supplier',
    loadChildren: () => import('./component/supplier/supplier.module').then(module => module.SupplierModule)
  },
  {
    path: 'templates',
    loadChildren: () => import('./component/templates/templates.module').then(module => module.TemplatesModule)
  },
  {
    path: 'payment',
    loadChildren: () => import('./component/payment/payment.module').then(module => module.PaymentModule)
  },
  {
    path: 'import-invoice-medicine',
    loadChildren: () => import('./component/import-invoice-medicine/import-invoice-medicine.module')
      .then(module => module.ImportInvoiceMedicineModule)
  },
  {
    path: 'import-invoice',

    loadChildren: () => import('./component/import-invoice/import-invoice.module').then(module => module.ImportInvoiceModule)
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
