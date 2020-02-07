import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { FeedComponent } from './feed/feed.component';
import { CreateFeedComponent } from './create-feed/create-feed.component';
import { CreateSourceComponent } from './create-source/create-source.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { ArticleComponent } from './article/article.component';
import { FeedEditComponent } from './feed-edit/feed-edit.component';
import { SourceEditComponent } from './source-edit/source-edit.component';


const routes: Routes = [
  {
    path:'feed', component: FeedComponent
  },
  {
    path: 'feed-new', component: CreateFeedComponent
  },
  {
    path: 'source-new', component: CreateSourceComponent
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'logout', component: LogoutComponent
  },
  {
    path: 'article/:articleId', component: ArticleComponent
  },
  {
    path: 'feed/:feedId', component: FeedEditComponent
  },
  {
    path: 'source/:sourceId', component: SourceEditComponent
  },
  {
  path: "register", component: RegisterComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

 }
