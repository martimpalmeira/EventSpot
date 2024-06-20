import { Component } from '@angular/core';
import { iEvent } from '../../interfaces/iEvent';
import { EventService } from '../../services/event.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-my-events',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './my-events.component.html',
  styleUrl: './my-events.component.css'
})
export class MyEventsComponent {
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

  updateEvent(id:string):void{
    this.router.navigateByUrl(`/create-event/${id}`);
  }

  deleteEvent(id: string): void {
    this.eventService.deleteEvent(id).subscribe(() => {
      this.loadEvents();
    });
  }
}
