package com.fiap.eventSpot.controllers;

import com.fiap.eventSpot.model.Event;
import com.fiap.eventSpot.model.User;
import com.fiap.eventSpot.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> listEvents() {
        return eventService.listEvents();
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event, @RequestParam(name = "organizerId") Long organizerId) {
        return ResponseEntity.ok(eventService.createEvent(event, organizerId));
    }

    @PostMapping("/{eventId}/register/{userId}")
    public ResponseEntity<Event> registerUserForEvent(
            @PathVariable Long eventId,
            @PathVariable Long userId) {
        return ResponseEntity.ok(eventService.registerUserForEvent(eventId, userId));
    }

}
