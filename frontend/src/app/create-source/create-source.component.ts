import { Component, OnInit } from '@angular/core';
import {CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { StorageManagerService } from '../storage-manager.service';

@Component({
  selector: 'app-create-source',
  templateUrl: './create-source.component.html',
  styleUrls: ['./create-source.component.css']
})
export class CreateSourceComponent implements OnInit {
  private sources:any;
  private link:string;
  private linkSel: string;
  private title:string;
  private content:string;
  private image:string;
  constructor(private http: HttpClient, private manager:StorageManagerService) { }

  ngOnInit() {
    this.http.get("http://localhost:8080/api/sources/index").subscribe(data => {
      this.sources = data;
    })
  }

  create(){
    let body = {
      link: this.link,
      linkSelector: this.linkSel,
      titleSelector: this.title,
      contentSelector: this.content,
      imageSelector: this.image,
      userToken: this.manager.getUserToken()
    }

    this.http.post("http://localhost:8080/api/sources/new", body, {headers: { "Content-Type": "application/json"}}).subscribe(r => {console.log(r)})
  }
}
