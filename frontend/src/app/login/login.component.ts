import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { StorageManagerService } from '../storage-manager.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private email:string;
  private password:string;

  constructor(private http:HttpClient, private router:Router, private manager:StorageManagerService) { }

  ngOnInit() {
    
  }

  login(){
    this.http.post("http://localhost:8080/api/users/auth", {email: this.email, password: this.password},
    {headers: {"Content-Type": "application/json"}}).subscribe(data => {
      if(data['token']){
        this.manager.setUserToken(data['token']);
        let messages = [{status: "success", text: "You have successfully logged in."}];
        this.manager.setMessages(messages);
        this.router.navigate(['/feed']);
      } else {
        let messages = [{status: "error", text: "Please check your log in credentials and try to log in again!"}];
        this.manager.setMessages(messages);
      }
    })
  }

}
