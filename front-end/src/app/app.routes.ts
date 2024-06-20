import { Routes } from '@angular/router';
import { ListEventsComponent } from './pages/list-events/list-events.component';
import { UserEventsComponent } from './pages/user-events/user-events.component';
import { CreateEventComponent } from './pages/create-event/create-event.component';
import { EventDetailsComponent } from './pages/event-details/event-details.component';
import { MyEventsComponent } from './pages/my-events/my-events.component';

export const routes: Routes = [
  { path: 'home', component: ListEventsComponent },
  { path: 'create-event/:id', component: CreateEventComponent },
  { path: 'user-events-subscribed', component: UserEventsComponent },
  { path: 'my-events', component: MyEventsComponent },
  { path: 'event-details/:id', component: EventDetailsComponent },
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full',
  },
];
