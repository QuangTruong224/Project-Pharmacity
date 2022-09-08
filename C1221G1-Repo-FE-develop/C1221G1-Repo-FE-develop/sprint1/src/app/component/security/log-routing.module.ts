import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {SignUpComponent} from "./sign-up/sign-up.component";
import {LogoutComponent} from "./logout/logout.component";
import {ForbiddenPageComponent} from "./forbidden-page/forbidden-page.component";
import {VerifyUserComponent} from "./verify-user/verify-user.component";


const routes: Routes = [{
  path: 'sign-in',
  component: LoginComponent
  }, {
  path: 'sign-up',
  component: SignUpComponent
  }, {
  path: 'sign-out',
  component: LogoutComponent,
  },
  {
    path: 'forbidden-page',
    component: ForbiddenPageComponent
  },
  {
    path: 'verify/:token/:username',
    component: VerifyUserComponent
  }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LogRoutingModule {
}
