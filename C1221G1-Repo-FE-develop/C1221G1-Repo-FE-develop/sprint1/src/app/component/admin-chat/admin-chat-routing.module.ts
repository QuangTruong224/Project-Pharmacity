import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdminChatComponent} from './admin-chat.component';
import {AdminChatDetailComponent} from './admin-chat-detail/admin-chat-detail.component';
import {AdminChatDefaultComponent} from './admin-chat-default/admin-chat-default.component';
import {AuthGuard} from "../../service/security/auth.guard";





const routes: Routes = [
  {
    path: '', component: AdminChatComponent, children: [
      {path: 'room/:roomId', component: AdminChatDetailComponent},
      {path: 'rooms', component: AdminChatDefaultComponent}

    ], canActivate: [AuthGuard], data: {
      roles: ["ROLE_MANAGER", "ROLE_EMPLOYEE"]
    }
  },

];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class AdminChatRoutingModule {
}
