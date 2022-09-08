import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AccountRoutingModule } from './account-routing.module';
import {AccountListComponent} from "./account-list/account-list.component";
import {AccountEditComponent} from "./account-edit/account-edit.component";
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    AccountListComponent,
    AccountEditComponent
  ],
    imports: [
        CommonModule,
        AccountRoutingModule,
        ReactiveFormsModule
    ]
})
export class AccountModule { }
