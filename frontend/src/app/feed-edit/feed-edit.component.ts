import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { StorageManagerService } from '../storage-manager.service';

@Component({
  selector: 'app-feed-edit',
  templateUrl: './feed-edit.component.html',
  styleUrls: ['./feed-edit.component.css']
})
export class FeedEditComponent implements OnInit {
  private sources:any;
  private feed:any;
  private name:string;
  private feedId:any;
  constructor(private http:HttpClient, private route:ActivatedRoute, private manager:StorageManagerService) { }

  ngOnInit() {
    this.feedId = this.route.snapshot.paramMap.get('feedId');
    this.http.get("http://localhost:8080/api/feeds/" + this.feedId).subscribe(r => {
      this.feed = r
      this.name = this.feed['name'];
      this.http.get<any>("http://localhost:8080/api/sources/index").subscribe(data => { 
        this.sources = data 
        this.sources.forEach(source => {
          this.feed.sources.forEach(checkedSource => {
            if(source['id'] == checkedSource['id']){
              source['checked'] = true;
            }
          })
        });
      });
    });
  }

  edit(){
    console.log(this.sources);
    let checkedIds = this.sources
      .filter(opt => opt.checked)
      .map(opt => opt.id)

      this.http.put("http://localhost:8080/api/feeds/edit", {id: this.feedId, name: this.name, userToken: this.manager.getUserToken(),
        ids: checkedIds}, {headers:{"Content-Type": "application/json"}}).subscribe(r => {
          if(r['id']){
            this.manager.setMessages({status: "success", text: "Successfully edited feed!"});
          } else {
            this.manager.setMessages({status:"error", text: "There was an error while trying to edit feed. Please try again later."});
          }
        });
    }
}
