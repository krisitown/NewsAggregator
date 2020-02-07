import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { StorageManagerService } from '../storage-manager.service';

@Component({
  selector: 'app-source-edit',
  templateUrl: './source-edit.component.html',
  styleUrls: ['./source-edit.component.css']
})
export class SourceEditComponent implements OnInit {
  private source:any;
  constructor(private http:HttpClient, private route:ActivatedRoute, private manage:StorageManagerService) { }

  ngOnInit() {
    let sourceId = this.route.snapshot.paramMap.get('sourceId');
    this.http.get("http://localhost:8080/api/sources/get/" + sourceId).subscribe(data => {
      this.source = data;
    });
  }

  edit(){
    this.http.put("http://localhost:8080/api/sources/edit", this.source, {headers: {"Content-Type": "application/json"}}).subscribe(data => {
      if(data['id']){
        this.manage.setMessages({status: "success", text: "Succesfully edited source!"});
      } else {
        this.manage.setMessages({status: "error", text: "An error occured while trying to edit source."});
      }})
    }
}
