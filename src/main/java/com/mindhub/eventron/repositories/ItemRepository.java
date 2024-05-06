package com.mindhub.eventron.repositories;

import com.mindhub.eventron.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
}
