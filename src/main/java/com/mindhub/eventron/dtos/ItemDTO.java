package com.mindhub.eventron.dtos;

import com.mindhub.eventron.enums.ItemType;
import com.mindhub.eventron.models.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ItemDTO {
    private UUID id;
    private String title;
    private String body;
    private EventronUserDTO user;
    private LocalDateTime createdAt;
    private Set<EventronUserDTO> likedByUsers;
    private BigInteger likeCount;
    private BigInteger commentCount;
    private Set<CommentDTO> comments;
    private UUID mediaId;
    private ItemType type;
    private Set<EventronUserDTO> eventGoers;

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.body = item.getBody();
        this.user = new EventronUserDTO(item.getUser());
        this.createdAt = item.getCreatedAt();
        this.likedByUsers = item.getLikedByUsers().stream()
                .map(EventronUserDTO::new)
                .collect(Collectors.toSet());
        this.likeCount = item.getLikeCount();
        this.commentCount = item.getCommentCount();
        this.comments = item.getComments().stream()
                .map(CommentDTO::new)
                .collect(Collectors.toSet());
        this.mediaId = item.getMedia().getId();
        this.type = item.getType();
        this.eventGoers = item.getEventGoers().stream()
                .map(EventronUserDTO::new)
                .collect(Collectors.toSet());
    }
}
