package com.mindhub.eventron.repositories;

import com.mindhub.eventron.models.EventronUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EventronUserRepository extends JpaRepository<EventronUser, UUID> {

}
