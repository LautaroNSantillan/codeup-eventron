package com.mindhub.eventron.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity@Getter@Setter@NoArgsConstructor
public class EventLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String line1;
    private String line2;
    private String country;
    private String state;
    private String postal;

}
