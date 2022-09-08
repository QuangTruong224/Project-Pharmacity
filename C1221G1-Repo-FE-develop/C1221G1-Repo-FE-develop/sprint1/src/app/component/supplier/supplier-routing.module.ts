import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SupplierListComponent} from "./supplier-list/supplier-list.component";
import {SupplierCreateComponent} from "./supplier-create/supplier-create.component";
import {SupplierEditComponent} from "./supplier-edit/supplier-edit.component";
import {SupplierDetailComponent} from "./supplier-detail/supplier-detail.component";
import {AuthGuard} from "../../service/security/auth.guard";


/**
 * Routes
 *  @23h 01/06/2022 LuatTN
 *   @this  get value  Supplier
 */
const routes: Routes = [
  {
    path: '', component: SupplierListComponent, canActivate: [AuthGuard], data: {
      roles: ['ROLE_MANAGER', 'ROLE_EMPLOYEE']
    }
  },
  {
    path: 'create', component: SupplierCreateComponent, canActivate: [AuthGuard], data: {
      roles: ['ROLE_MANAGER', 'ROLE_EMPLOYEE']
    }
  },
  {
    path: 'edit/:supplierId', component: SupplierEditComponent, canActivate: [AuthGuard], data: {
      roles: ['ROLE_MANAGER', 'ROLE_EMPLOYEE']
    }
  },
  {
    path: 'detail/:supplierId', component: SupplierDetailComponent, canActivate: [AuthGuard], data: {
      roles: ['ROLE_MANAGER', 'ROLE_EMPLOYEE']
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SupplierRoutingModule {
}
