import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StorageManagerService } from '../storage-manager.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router:Router, private manager:StorageManagerService) { }

  ngOnInit() {
    this.manager.removeUserToken();
    this.router.navigate(['/login']);
  }

}
