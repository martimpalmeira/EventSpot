
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { iEvent } from '../interfaces/iEvent';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private apiUrl = 'http://localhost:3000/events';

  constructor(private http: HttpClient) { }

  getEvents(): Observable<iEvent[]> {
    return this.http.get<iEvent[]>(this.apiUrl);
  }

  getEvent(id: string): Observable<iEvent> {
    return this.http.get<iEvent>(`${this.apiUrl}/${id}`);
  }

  createEvent(event: iEvent): Observable<iEvent> {
    return this.http.post<iEvent>(this.apiUrl, event);
  }

  updateEvent(id: string, event: iEvent): Observable<iEvent> {
    return this.http.put<iEvent>(`${this.apiUrl}/${id}`, event);
  }

  deleteEvent(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
