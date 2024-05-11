package com.mindhub.eventron.models;

import com.mindhub.eventron.enums.ItemType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity@Getter@Setter@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String body;
    @ManyToMany
    @JoinColumn(name="user_id")
    private EventronUser user;
    private LocalDateTime createdAt;
    @ManyToMany
    @JoinTable(name = "post_like",
    joinColumns =@JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Set<EventronUser> likedByUsers;
    private BigInteger likeCount;
    private BigInteger commentCount;
    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;
    @OneToOne
    @JoinColumn(name = "media_id")
    private ItemMedia media;
    @Enumerated(EnumType.STRING)
    private ItemType type;
    @ManyToMany(mappedBy = "goingToEvents")
    private Set<EventronUser> eventGoers;
}
