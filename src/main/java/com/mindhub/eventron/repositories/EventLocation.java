package com.mindhub.eventron.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventLocation extends JpaRepository<EventLocation, UUID> {
}
