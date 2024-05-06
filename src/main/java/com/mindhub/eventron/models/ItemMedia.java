package com.mindhub.eventron.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity@Getter@Setter@NoArgsConstructor
public class ItemMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToOne
    private Item item;
    private String mediaFile;
}
