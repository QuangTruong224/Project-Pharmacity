import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';


import {CustomerRoutingModule} from './customer-routing.module';
import {CustomerModalComponent} from './customer-modal/customer-modal.component';
import {CustomerCreateComponent} from './customer-create/customer-create.component';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {CustomerEditComponent} from './customer-edit/customer-edit.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [
    CustomerModalComponent,
    CustomerCreateComponent,
    CustomerListComponent,
    CustomerEditComponent],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ]
})

export class CustomerModule {
}



