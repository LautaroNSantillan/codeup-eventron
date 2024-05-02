package com.mindhub.eventron.models;

import java.time.LocalDateTime;

public class Comment {
    private Integer id;
    private LocalDateTime createdAt;
    private Integer createdByUserId;
    private Integer postId;
    private String comment;
    private Integer commentRepliedToId;
}
