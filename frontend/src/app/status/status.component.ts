import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StorageManagerService } from '../storage-manager.service';

@Component({
  selector: 'app-status',
  templateUrl: './status.component.html',
  styleUrls: ['./status.component.css']
})
export class StatusComponent implements OnInit {
  private messages:any;
  constructor(private manager:StorageManagerService) { }

  ngOnInit() {
    this.messages = this.manager.getMessages();
    console.log(this.messages);
    this.manager.setMessages([]);
  }

}
