import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ArticleComponent } from './article/article.component';
import { ArticleThumbnailComponent } from './article-thumbnail/article-thumbnail.component';
import { FeedComponent } from './feed/feed.component';
import { CreateFeedComponent } from './create-feed/create-feed.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    ArticleComponent,
    ArticleThumbnailComponent,
    FeedComponent,
    CreateFeedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
