import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StorageManagerService {
  userToken = new Subject();
  messages = new Subject();

  constructor() { }

  setMessages(value){
    this.messages.next(value);
    localStorage.setItem("messages", JSON.stringify(value));
  }

  getMessages(){
    let messages = localStorage.getItem("messages");
    localStorage.removeItem("messages");
    return JSON.parse(messages);
  }

  setUserToken(value){
    this.userToken.next(value);
    localStorage.setItem("userToken", value);
  }

  getUserToken(){
    return localStorage.getItem("userToken");
  }

  removeUserToken(){
    this.userToken.next(null);
    localStorage.removeItem("userToken");
  }
}
