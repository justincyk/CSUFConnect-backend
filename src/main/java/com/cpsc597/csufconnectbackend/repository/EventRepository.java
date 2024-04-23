package com.cpsc597.csufconnectbackend.repository;

import com.cpsc597.csufconnectbackend.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {
}
