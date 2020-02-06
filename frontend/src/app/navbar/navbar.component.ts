import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  private token:string;
  constructor() { }

  ngOnInit() {
    this.token = localStorage.getItem('userToken'); 
  }
}
