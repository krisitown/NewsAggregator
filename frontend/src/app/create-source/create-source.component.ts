import { Component, OnInit } from '@angular/core';
import {CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-create-source',
  templateUrl: './create-source.component.html',
  styleUrls: ['./create-source.component.css']
})
export class CreateSourceComponent implements OnInit {
  private link:string;
  private linkSel: string;
  private title:string;
  private content:string;
  private image:string;
  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  create(){
    let body = {
      link: this.link,
      linkSelector: this.linkSel,
      titleSelector: this.title,
      contentSelector: this.content,
      imageSelector: this.image,
      userToken: localStorage.getItem('userToken')
    }

    this.http.post("http://localhost:8080/api/sources/new", body, {headers: { "Content-Type": "application/json"}}).subscribe(r => {console.log(r)})
  }
}
