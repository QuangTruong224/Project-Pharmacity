import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import firebase from "firebase/app";
import "firebase/database";
import {Title} from '@angular/platform-browser';

export const snapshotToArray = (snapshot: any) => {
  const returnArr = [];
  snapshot.forEach((childSnapshot: any) => {
    const item = childSnapshot.val();
    item.key = childSnapshot.key;
    returnArr.push(item);
  });

  return returnArr;
};
const SECOND_MILLIS = 1000;
const MINUTE_MILLIS = 60 * SECOND_MILLIS;
const HOUR_MILLIS = 60 * MINUTE_MILLIS;
const DAY_MILLIS = 24 * HOUR_MILLIS;
const WEEK_MILLIS = 7 * DAY_MILLIS;
const MONTH_MILLIS = DAY_MILLIS * 30;
const YEAR_MILLIS = WEEK_MILLIS * 52;

@Component({
  selector   : 'app-admin-chat',
  templateUrl: './admin-chat.component.html',
  styleUrls  : ['./admin-chat.component.css']
})
export class AdminChatComponent implements OnInit {
  @ViewChild("chatRoomList") private chatRoomList: ElementRef;
  rooms: any[];
  colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
  ];
  latestMessagePostTime: number;

  constructor(private title: Title) {
    if (localStorage.getItem('latestMessagePostTime')) {
      this.latestMessagePostTime = Number(localStorage.getItem('latestMessagePostTime'));
    } else {
      this.latestMessagePostTime = 0;
      localStorage.setItem('latestMessagePostTime', this.latestMessagePostTime + "");
    }
  }

  /**
   * @Author NghiaNTT
   * @Time: 03/07/2022
   * @return retrieve rooms from Rooms FRD and sort by lastMessagePost time
   */
  ngOnInit(): void {
    // this.chatRoomList.nativeElement.scrollIntoView({ behavior: "smooth", block:'nearest' });
    this.title.setTitle("Pharmacode | Hỗ trợ khách hàng");
    firebase.database().ref('rooms/').on('value', resp => {
      this.rooms = [];
      this.rooms = snapshotToArray(resp);
      this.rooms.sort((a, b) => b.lastMessagePost - a.lastMessagePost);
      if (this.rooms[0].lastMessagePost > this.latestMessagePostTime
        && this.rooms[0].isSeen == false) {
        console.log('sound admin' + this.latestMessagePostTime);
        this.playAudio();
        this.latestMessagePostTime = this.rooms[0].lastMessagePost;
        localStorage.setItem('latestMessagePostTime', this.latestMessagePostTime + "");
      }
    });
  }

  /**
   * @Author NghiaNTT
   * @Time: 06/07/2022
   * @param
   * @return change status from not read to read
   */
  isSeenToggle(uuid: any) {
    firebase.database().ref('rooms/' + uuid).once('value').then(res => {
      const room = res.val();
      firebase.database().ref('rooms/' + uuid).update({...room, isSeen: true});
    });
  }

  /**
   * @Author NghiaNTT
   * @Time: 06/07/2022
   * @param
   * @return get background color for specific name
   */
  getAvatarColor(name) {
    let hash = 0;
    for (let i = 0; i < name.length; i++) {
      hash = 31 * hash + name.charCodeAt(i);
    }
    const index = Math.abs(hash % this.colors.length);
    return this.colors[index];
  }

  /**
   * @Author NghiaNTT
   * @Time: 06/07/2022
   * @param
   * @return get last message post time by word
   */
  calculateLastMessagePost(time) {
    let diff = new Date().getTime() - time;
    let last: number;
    let roundup: number;
    if (diff < MINUTE_MILLIS) {
      return "gần đây";
    } else if (diff < 2 * MINUTE_MILLIS) {
      return "1 phút trước";
    } else if (diff < 50 * MINUTE_MILLIS) {
      roundup = diff / MINUTE_MILLIS;
      last = Math.floor(roundup);
      return last + " phút trước";
    } else if (diff < 90 * MINUTE_MILLIS) {
      return "1 giờ trước";
    } else if (diff < 24 * HOUR_MILLIS) {
      roundup = diff / HOUR_MILLIS;
      last = Math.floor(roundup);
      return last + " giờ trước";
    } else if (diff < 48 * HOUR_MILLIS) {
      return "hôm qua";
    } else if (diff < 7 * DAY_MILLIS) {
      roundup = diff / DAY_MILLIS;
      last = Math.floor(roundup);
      return last + "ngày trước";
    } else if (diff < 2 * WEEK_MILLIS) {
      return "1 tuần trước";
    } else if (diff < DAY_MILLIS * 30.43675) {
      roundup = diff / (DAY_MILLIS * 30.43675);
      last = Math.floor(roundup);
      return last + "tuần";
    } else if (diff < 2 * MONTH_MILLIS) {
      return "1 tháng trước";
    } else if (diff < WEEK_MILLIS * 52.2) {
      roundup = diff / (WEEK_MILLIS * 52.2);
      last = Math.floor(roundup);
      return last + " tháng trước";
    } else if (diff < 2 * YEAR_MILLIS) {
      return "1 năm trước";
    } else {
      roundup = diff / (YEAR_MILLIS * 2);
      last = Math.floor(roundup);
      return last + " năm trước";
    }
  }
  /**
   * @Author NghiaNTT
   * @Time: 07/07/2022
   * @return play sound
   */
  playAudio() {
    let audio = new Audio();
    audio.src = "../../../assets/audio/noti.wav";
    audio.load();
    audio.play();
  }

}
