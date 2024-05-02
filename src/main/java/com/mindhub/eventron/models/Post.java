package com.mindhub.eventron.models;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Set;

public class Post {
    private Integer id;
    private String title;
    private String body;
    private Integer userId;
    private LocalDateTime createdAt;
    private BigInteger likeCount;
    private BigInteger commentCount;
    private Set<Comment> comments;
}
