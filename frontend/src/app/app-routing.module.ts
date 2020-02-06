import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { FeedComponent } from './feed/feed.component';
import { CreateFeedComponent } from './create-feed/create-feed.component';
import { CreateSourceComponent } from './create-source/create-source.component';
import { LoginComponent } from './login/login.component';


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
  path: "register", component: RegisterComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

 }
