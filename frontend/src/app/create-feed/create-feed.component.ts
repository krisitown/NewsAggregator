import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { StorageManagerService } from '../storage-manager.service';

@Component({
  selector: 'app-create-feed',
  templateUrl: './create-feed.component.html',
  styleUrls: ['./create-feed.component.css']
})
export class CreateFeedComponent implements OnInit {
  private sources:any;
  private name:string;
  private feeds:any;
  constructor(private http:HttpClient, private manager:StorageManagerService) { }

  ngOnInit() {
    this.http.get<any>("http://localhost:8080/api/sources/index").subscribe(data => {
      console.log(data);
      this.sources = data;
      this.http.get<any>('http://localhost:8080/api/feeds/get?token=' + this.manager.getUserToken()).subscribe(data => {
        console.log(data);
        this.feeds = data;
    })
    })
  }

  createFeed(){
    console.log(this.sources);
    let checkedIds = this.sources
      .filter(opt => opt.checked)
      .map(opt => opt.id)

      this.http.post("http://localhost:8080/api/feeds/new", {name: this.name, userToken: this.manager.getUserToken(),
        ids: checkedIds}, {headers:{"Content-Type": "application/json"}}).subscribe(r => {console.log(r)});
  }
}
