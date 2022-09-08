import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ImportInvoiceRoutingModule} from './import-invoice-routing.module';
import {ImportInvoiceListComponent} from './import-invoice-list/import-invoice-list.component';
import {ReactiveFormsModule} from '@angular/forms';
import {ImportInvoiceCreateComponent} from './import-invoice-create/import-invoice-create.component';


@NgModule({
  declarations: [ImportInvoiceListComponent,
    ImportInvoiceCreateComponent
  ],
  exports     : [
    ImportInvoiceListComponent,
  ],
  imports     : [
    CommonModule,
    ImportInvoiceRoutingModule,
    ReactiveFormsModule,
  ]
})
export class ImportInvoiceModule {
}

