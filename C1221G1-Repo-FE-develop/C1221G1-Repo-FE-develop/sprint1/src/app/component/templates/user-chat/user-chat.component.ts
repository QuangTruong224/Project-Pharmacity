import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, ValidationErrors, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import firebase from "firebase/app";
import "firebase/database";
import {snapshotToArray} from '../../admin-chat/admin-chat.component';
import {UserChat} from '../../../dto/user-chat.model';
import {ToastrService} from 'ngx-toastr';
import {Chat} from '../../../dto/chat.model';
import {getTimeStamp} from '../../../utils/time-stamp.utils';
import {v4 as uuidv4} from 'uuid';
import {TokenStorageService} from '../../../service/security/token-storage.service';
import {CartService} from '../../../service/cart/cart.service';

@Component({
  selector   : 'app-user-chat',
  templateUrl: './user-chat.component.html',
  styleUrls  : ['./user-chat.component.css']
})
export class UserChatComponent implements OnInit {
  @ViewChild('chatContent') chatContent: ElementRef;
  scrollTop: number = null;
  isExpanded = false;
  isClosed = false;
  isLogin = false;
  customerForm: FormGroup;
  chatForm: FormGroup;
  userChat: UserChat;
  message = '';
  uuid: string;
  chats = [];
  chat: Chat;
  isFirstLoad = true;
  isMute = false;

  constructor(private toastr: ToastrService,
              private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private tokenStorageService: TokenStorageService,
              private cartService: CartService) {
    // firebase.initializeApp(environment.firebaseConfig);
  }

  /**
   * * @Author NghiaNTT
   * * @Time: 03/07/2022
   * * @param
   * * @return load messages for chat room
   * */
  loginToChatRoom() {
    this.chatForm = this.formBuilder.group({'message': [null, Validators.required]});
    firebase.database().ref('chats/' + this.uuid).on('value', resp => {
      this.chats = [];
      this.chats = snapshotToArray(resp);
      if (this.chats.length != 0 && !this.isMute && this.chats[this.chats.length - 1].name !== this.userChat.name && !this.isFirstLoad) {
        this.playAudio();
      } else {
        this.isFirstLoad = false;
      }
      setTimeout(() => {
        if (this.chatContent) {
          this.scrollTop = this.chatContent.nativeElement.scrollHeight;
        }
      }, 200);
    });
  }

  /**
   * * @Author NghiaNTT
   * * @Time: 03/07/2022
   * * @param
   * * @return check user are registered or not
   * */
  ngOnInit(): void {
    if (this.tokenStorageService.getUser()) {
      this.handleRegisteredCustomer();
    } else {
      this.handleUnregisteredCustomer();
    }
  }
  /**
   * * @Author NghiaNTT
   * * @Time: 10/07/2022
   * * @param
   * * @return handle registered customer.
   * */
  private handleRegisteredCustomer() {
    const username = this.tokenStorageService.getUser();
    this.cartService.getCustomerByUsername(username.username).subscribe(data => {
      this.userChat = {};
      this.userChat.name = data.customerName;
      this.userChat.phone = data.customerPhone;
      this.userChat.uuid = data.uuidChat;
      this.uuid = data.uuidChat;
      firebase.database().ref('users/').push().set(this.userChat);
      firebase.database().ref('rooms/' + this.uuid).set({
        ...this.userChat,
        isSeen         : false,
        lastMessagePost: getTimeStamp()
      });
      this.isLogin = true;
      this.loginToChatRoom();
    });

  }
  /**
   * * @Author NghiaNTT
   * * @Time: 10/07/2022
   * * @param
   * * @return handle unregistered customer.
   * */
  private handleUnregisteredCustomer() {
    this.customerForm = this.formBuilder.group({
      'name'   : ['', [this.validateCustomerName()]],
      'phone'  : ['', [Validators.required, Validators.pattern('^0\\d{9}$')]],
      'message': ['', Validators.required]
    });
    this.userChat = JSON.parse(localStorage.getItem('user-chat-info'));
    if (this.userChat && this.userChat.name && this.userChat.phone && this.userChat.uuid) {
      this.uuid = this.userChat.uuid;
      firebase.database().ref('users/').orderByChild('uuid').equalTo(this.uuid).once('value', snapshot => {
        if (snapshot.exists()) {
          this.isLogin = true;
          this.loginToChatRoom();
        } else {
          localStorage.removeItem('user-chat-info');
        }
      });
    }
  }
  /**
   * * @Author NghiaNTT
   * * @Time: 09/07/2022
   * * @param
   * * @return validate customer name
   * */
  validateCustomerName(): ValidationErrors {
    return (control: AbstractControl): ValidationErrors | null => {
      const name = control.value.trim();
      if (name.length === 0) {
        return {forbiddenName: {message: 'Vui lòng không để trống'}};
      } else if (name.length < 5) {
        return {forbiddenName: {message: 'Vui lòng nhập nhiều hơn 5 kí tự'}};
      } else if (name.length > 25) {
        return {forbiddenName: {message: 'Vui lòng nhập ít hơn 25 kí tự'}};
      } else if (!name.match(/^((?!admin|\d|[\\_.\/*)\-+^$<>,"':\]\[{}&=%#@!`]).)+$/i)) {
        return {forbiddenName: {message: 'Tên không hợp lệ'}};
      }
    };
  }

  /**
   * * @Author NghiaNTT
   * * @Time: 03/07/2022
   * * @param
   * * @return toggle expand function
   * */
  toggleExpanded() {
    this.isExpanded = !this.isExpanded;
  }

  /**
   * * @Author NghiaNTT
   * * @Time: 03/07/2022
   * * @param
   * * @return close chat box
   * */
  closePanel() {
    this.isClosed = true;
  }

  /**
   * * @Author NghiaNTT
   * * @Time: 03/07/2022
   * * @param
   * * @return add Chat in Chats FRD, Update lastMessagePost time in Rooms FRD
   * */
  onChatSubmit() {
    const chat = this.chatForm.value;
    if (chat.message.trim().length != 0 && chat.message.trim().length < 255) {
      chat.name = this.userChat.name;
      chat.uuid = this.uuid;
      chat.message = chat.message.trim();
      chat.createdAt = getTimeStamp();
      firebase.database().ref('chats/' + this.uuid).push().set(chat);
      firebase.database().ref('rooms/' + this.uuid).once('value').then(res => {
        const room = res.val();
        firebase.database().ref('rooms/' + this.uuid).update({...room, lastMessagePost: getTimeStamp(), isSeen: false});
      });
      this.chatForm.reset();
    } else {
      this.toastr.info('Vui lòng không để trống hoặc không nhập quá 255 kí tự', '', {
        timeOut    : 3000,
        progressBar: false
      });
      this.chatForm.reset();
    }
  }

  /**
   * * @Author NghiaNTT
   * * @Time: 03/07/2022
   * * @param
   * * @return handle user login.
   * * 1. add new user to Users FRD
   * * 2. add new room to Rooms FRD
   * * 3. add new chat to Chats FRD
   * * 4. save item in localStorage
   * */
  onCustomerFormSubmit() {
    this.uuid = uuidv4();
    if (this.customerForm.valid) {
      const form = this.customerForm.value;
      this.userChat = {};
      this.userChat.name = form.name;
      this.userChat.phone = form.phone;
      this.userChat.uuid = this.uuid;
      firebase.database().ref('users/').push().set(this.userChat);
      firebase.database().ref('rooms/' + this.uuid).set({
        ...this.userChat,
        isSeen         : false,
        lastMessagePost: getTimeStamp()
      });
      this.chat = {};
      this.chat = {...this.userChat, message: form.message, createdAt: getTimeStamp()};
      firebase.database().ref('chats/' + this.uuid).push().set(this.chat);
      localStorage.setItem('user-chat-info', JSON.stringify(this.userChat));
      this.isLogin = true;
      this.loginToChatRoom();
    } else {
      this.toastr.info('Vui lòng nhập chính xác thông tin', '', {timeOut: 3000, progressBar: false});
    }
  }
  /**
   * * @Author NghiaNTT
   * * @Time: 10/07/2022
   * * @param
   * * @return play audio setting
   * */
  playAudio() {
    let audio = new Audio();
    audio.src = "../../../../assets/audio/noti.wav";
    audio.load();
    audio.play();
  }

  toggleSound() {
    this.isMute = !this.isMute;
  }


}
