import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import { HttpClient } from '@angular/common/http';
import {CommonModule } from '@angular/common';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  private article:any;
  constructor(private route:ActivatedRoute, private http:HttpClient) { }

  ngOnInit() {
    let articleId = this.route.snapshot.paramMap.get('articleId');
    this.http.get("http://localhost:8080/api/articles/get/" + articleId).subscribe(data => {
      this.article = data;
    })
  }

}
