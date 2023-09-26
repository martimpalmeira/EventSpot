package com.fiap.eventSpot.repositories;

import com.fiap.eventSpot.model.Event;
import com.fiap.eventSpot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
