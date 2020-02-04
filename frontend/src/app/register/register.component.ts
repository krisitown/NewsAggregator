import { Component, OnInit } from '@angular/core';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  private registerUrl:string;
  private name:String;
  private email:String;
  private password:String;
  private http:HttpClient;

  constructor(private httpClient:HttpClient) {
    this.http = httpClient;
   }

  ngOnInit() {
    this.registerUrl = "http://localhost:8080/api/users/new";
  }

  register(){
    console.log("Registering!");
    let body = {
      "id": null,
      "name": this.name,
      "email": this.email,
      "password": this.password,
    }
    console.log(body);
    this.http.post(this.registerUrl, body, {"headers": {"Content-Type": "application/json"}}).subscribe(r => {});
  }

}
