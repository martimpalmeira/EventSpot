package com.fiap.eventSpot.repositories;

import com.fiap.eventSpot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
