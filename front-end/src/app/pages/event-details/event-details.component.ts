import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EventService } from '../../services/event.service';
import { iEvent } from '../../interfaces/iEvent';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-event-details',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './event-details.component.html',
  styleUrl: './event-details.component.css',
})
export class EventDetailsComponent {
  aRoute: ActivatedRoute = inject(ActivatedRoute);

  id: string = '';

  event: iEvent = {
    id: '',
    name: '',
    description: '',
    startDate: new Date(),
    endDate: new Date(),
    location: '',
    participants: [],
  };

  constructor(private eventService: EventService) {
    this.id = this.aRoute.snapshot.params['id'];
   
    this.eventService.getEvent(this.id).subscribe((event) => {
      this.event = event
      console.log(event);
    });
  }

  ngOnInit() {
    
  }
}
