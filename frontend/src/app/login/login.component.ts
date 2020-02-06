import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private email:string;
  private password:string;

  constructor(private http:HttpClient) { }

  ngOnInit() {
    
  }

  login(){
    this.http.post("http://localhost:8080/api/users/auth", {email: this.email, password: this.password},
    {headers: {"Content-Type": "application/json"}}).subscribe(data => {
      console.log(data);
      localStorage.setItem("userToken", data['token']);
    })
  }

}
