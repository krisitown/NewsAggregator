import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { FeedComponent } from './feed/feed.component';
import { CreateFeedComponent } from './create-feed/create-feed.component';


const routes: Routes = [
  {
    path:'feed', component: FeedComponent
  },
  {
    path: 'feed-new', component: CreateFeedComponent
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
