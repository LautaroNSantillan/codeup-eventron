package com.mindhub.eventron.dtos;

import com.mindhub.eventron.models.EventronUser;
import com.mindhub.eventron.models.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter@NoArgsConstructor
public class EventronUserDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private LocalDate signupDate;
    private Set<Item> likedPosts;
    private Set<EventronUserDTO> following;
    private Set<EventronUserDTO> followers;
    private Set<Item> goingToEvents;
    private Set<Item> items;

    public EventronUserDTO(EventronUser user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.username = user.getUsername();
        this.signupDate = user.getSignupDate();
        this.likedPosts = user.getLikedPosts();
        this.following = user.getFollowing().stream()
                .map(EventronUserDTO::new)
                .collect(Collectors.toSet());
        this.followers = user.getFollowers().stream()
                .map(EventronUserDTO::new)
                .collect(Collectors.toSet());
        this.goingToEvents = user.getGoingToEvents();
        this.items = user.getItems();
    }
}
}
