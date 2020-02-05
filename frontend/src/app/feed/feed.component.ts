import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {
  private selectedFeed:string;
  private feeds:any;
  private articles:any;
  private token:string;
  constructor(private client:HttpClient) { }

  ngOnInit() {
    console.log("FEED!");
    this.selectedFeed = "61";
    this.token = localStorage.getItem('userToken');
    this.client.get<any>('http://localhost:8080/api/feeds/get?token=' + this.token).subscribe(data => {
      console.log(data);
      this.feeds = data;
      if(this.feeds){
        this.selectedFeed = this.feeds[0].id;
      }
    })
  }

  onChange(newValue){
    console.log(newValue);
    this.selectedFeed = newValue;
    let sources = this.feeds.filter(f => f.id == this.selectedFeed)[0].sources;
    console.log(sources);

    this.articles = [];
    sources.forEach(element => {
      this.client.get<any>("http://localhost:8080/api/articles/bySource/" + element.id).subscribe(result => {
        this.articles = this.articles.concat(result);
        this.articles = this.splitUp(this.articles, 4);
        console.log(this.articles);
      })
    });
  }

  splitUp(arr, n) {
    let rest = arr.length % n, // how much to divide
        restUsed = rest, // to keep track of the division over the elements
        partLength = Math.floor(arr.length / n),
        result = [];

    for(let i = 0; i < arr.length; i += partLength) {
        let end = partLength + i,
            add = false;

        if(rest !== 0 && restUsed) { // should add one element for the division
            end++;
            restUsed--; // we've used one division element now
            add = true;
        }

        result.push(arr.slice(i, end)); // part of the array

        if(add) {
            i++; // also increment i in the case we added an extra element for division
        }
    }
    return result;
  }
}
