import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {SupplierRoutingModule} from './supplier-routing.module';
import {SupplierCreateComponent} from './supplier-create/supplier-create.component';
import {SupplierEditComponent} from './supplier-edit/supplier-edit.component';
import {SupplierListComponent} from './supplier-list/supplier-list.component';
import {SupplierDetailComponent} from './supplier-detail/supplier-detail.component';
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    SupplierCreateComponent,
    SupplierEditComponent,
    SupplierListComponent,
    SupplierDetailComponent],
  imports: [
    CommonModule,
    SupplierRoutingModule,
    ReactiveFormsModule]
})


export class SupplierModule { }
