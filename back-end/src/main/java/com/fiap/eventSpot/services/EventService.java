package com.fiap.eventSpot.services;

import com.fiap.eventSpot.dto.EventDTO;
import com.fiap.eventSpot.enums.UserRole;
import com.fiap.eventSpot.exceptions.AccessDeniedException;
import com.fiap.eventSpot.model.Event;
import com.fiap.eventSpot.model.User;
import com.fiap.eventSpot.repositories.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserService userService;

    public List<Event> listEvents() {
        return eventRepository.findAll();
    }

    public Event createEvent(Event event, Long userId) {
        User user = userService.obterUsuarioPorId(userId).orElseThrow(EntityNotFoundException::new);
        if (user.getRoles().contains(UserRole.ORGANIZER)) {
            event.setOrganizer(user);
            return eventRepository.save(event);
        } else {
            throw new AccessDeniedException("Only organizers can create events.");
        }
    }

    public Event registerUserForEvent(Long eventId, Long userId){
        Event event = eventRepository.findById(eventId).orElse(null);
        User user = userService.obterUsuarioPorId(userId).orElse(null);

        if (event != null && user != null) {
            event.getParticipants().add(user);
            user.getAttendedEvents().add(event);
            eventRepository.save(event);
            userService.atualizarUsuario(userId, user);
            return event;
        }else{
            return null;
        }
    }
}
