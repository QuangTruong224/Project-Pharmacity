import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AdminChatRoutingModule} from './admin-chat-routing.module';
import {AdminChatComponent} from './admin-chat.component';
import {AdminChatDetailComponent} from './admin-chat-detail/admin-chat-detail.component';
import {AdminChatDefaultComponent} from './admin-chat-default/admin-chat-default.component';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AdminChatComponent,
    AdminChatDetailComponent,
    AdminChatDefaultComponent
  ],
  imports: [
    CommonModule,
    AdminChatRoutingModule,
    ReactiveFormsModule
  ]
})
export class AdminChatModule {
}
