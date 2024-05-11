package com.mindhub.eventron.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private EventronUser createdByUser;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Item post;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "comment_replied_to_id")
    private Comment repliedToComment;
}

