import { Routes } from '@angular/router';
import { ListEventsComponent } from './pages/list-events/list-events.component';
import { UserEventsComponent } from './pages/user-events/user-events.component';
import { UserFavoritesComponent } from './pages/user-favorites/user-favorites.component';
import { CreateEventComponent } from './pages/create-event/create-event.component';
import { EventDetailsComponent } from './pages/event-details/event-details.component';

export const routes: Routes = [
    {path: 'home', component: ListEventsComponent},
    {path: 'create-event', component: CreateEventComponent},
    {path: 'user-events', component: UserEventsComponent},
    {path: 'favorite-events', component: UserFavoritesComponent},
    {path: 'event-details/:id', component: EventDetailsComponent}
];
