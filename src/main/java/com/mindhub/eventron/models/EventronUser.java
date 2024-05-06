package com.mindhub.eventron.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter@Setter@NoArgsConstructor
@Entity@AllArgsConstructor
public class EventronUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private String role;
    private LocalDate signupDate;

    @ManyToMany(mappedBy = "likedByUsers")
    private Set<Item> likedPosts;

    @ManyToMany
    @JoinTable(name = "follow",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "following_id"))
    private Set<EventronUser> following;

    @ManyToMany(mappedBy = "following")
    private Set<EventronUser> followers;
    @OneToMany(mappedBy = "createdByUser")
    private Set<Comment> comments;


    public EventronUser(String firstName, String lastName, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }
}
