import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StorageManagerService } from '../storage-manager.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  private token:any;
  constructor(private manager:StorageManagerService) { }

  ngOnInit() {
    this.token = this.manager.getUserToken();
    this.manager.userToken.subscribe(r => {
      console.log("userToken value changed!");
      this.token = r;
    }) 
  }
}
