import { Injectable } from '@angular/core';

const TOKEN_KEY = 'c1221g1-impossible';
const USER_KEY = 'c1221g1-champion';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() { }

  signOut(){
    window.localStorage.removeItem(TOKEN_KEY)
    window.sessionStorage.clear();
    window.location.reload();
  }

  saveTokenLocal(token:string){
    window.localStorage.removeItem(TOKEN_KEY);
    window.localStorage.setItem(TOKEN_KEY,token);
  }

  saveTokenSession(token: string){
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY,token);
  }

  getToken():string{
    if(sessionStorage.getItem(TOKEN_KEY) !== null){
      return sessionStorage.getItem(TOKEN_KEY);
    }else {
      return localStorage.getItem(TOKEN_KEY);
    }
  }

  saveUserLocal(user){
    window.localStorage.removeItem(USER_KEY);
    window.localStorage.setItem(USER_KEY,JSON.stringify(user));
  }

  saveUserSession(user) {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  getUser() {
    if (localStorage.getItem(USER_KEY) != null) {
      return JSON.parse(localStorage.getItem(USER_KEY));
    } else {
      return JSON.parse(sessionStorage.getItem(USER_KEY));
    }
  }

  setRememberFlag() {
    window.localStorage.setItem('Remember', 'true');
  }

  setNoRememberFlag() {
    window.localStorage.setItem('Remember', 'false');
  }

  getRememberFlag() {
    return window.localStorage.getItem('Remember');
  }
}
