import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TemplatesRoutingModule } from './templates-routing.module';
import { HomePageComponent } from '../home-page/home-page.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { UserChatComponent } from './user-chat/user-chat.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {ModalComponent} from './modal/modal.component';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    HomePageComponent,
    SidebarComponent,
    UserChatComponent,
    HeaderComponent,
    FooterComponent,
    ModalComponent],
  exports: [
    HomePageComponent,
    HeaderComponent,
    FooterComponent,
    SidebarComponent,
    UserChatComponent
  ],
  imports: [
    CommonModule,
    TemplatesRoutingModule,
    ReactiveFormsModule
  ]
})
export class TemplatesModule { }
