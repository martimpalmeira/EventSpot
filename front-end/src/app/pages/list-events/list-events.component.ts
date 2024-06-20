import { Component } from '@angular/core';
import { EventService } from '../../services/event.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { iEvent } from '../../interfaces/iEvent';
import { Router } from '@angular/router';
import { HeaderComponent } from '../../components/header/header.component';


@Component({
  selector: 'app-list-events',
  standalone: true,
  imports: [CommonModule, RouterModule, HeaderComponent],
  templateUrl: './list-events.component.html',
  styleUrl: './list-events.component.css'
})
export class ListEventsComponent {

  events: iEvent[] = [];

  constructor(private eventService: EventService, private router: Router) { }

  ngOnInit(): void {
    this.loadEvents();
  }

  loadEvents(): void {
    this.eventService.getEvents().subscribe(events => {
      this.events = events;
    });
  }


  navigateToEventDetail(id: string){
    this.router.navigateByUrl(`/event-details/${id}`);
  }

  // deleteEvent(id: number): void {
  //   this.eventService.deleteEvent(id).subscribe(() => {
  //     this.loadEvents();
  //   });
  // }
}
