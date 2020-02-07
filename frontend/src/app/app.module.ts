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
import { CreateSourceComponent } from './create-source/create-source.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { StatusComponent } from './status/status.component';
import { LogoutComponent } from './logout/logout.component';
import { FeedEditComponent } from './feed-edit/feed-edit.component';
import { SourceEditComponent } from './source-edit/source-edit.component';
import { StorageManagerService } from './storage-manager.service';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    ArticleComponent,
    ArticleThumbnailComponent,
    FeedComponent,
    CreateFeedComponent,
    CreateSourceComponent,
    LoginComponent,
    NavbarComponent,
    StatusComponent,
    LogoutComponent,
    FeedEditComponent,
    SourceEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [StorageManagerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
