package com.mindhub.eventron.dtos;

import com.mindhub.eventron.models.Comment;
import com.mindhub.eventron.models.EventronUser;
import com.mindhub.eventron.models.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Getter@NoArgsConstructor
public class CommentDTO {
    private Integer id;
    private LocalDateTime createdAt;
    private EventronUserDTO createdByUser;
    private ItemDTO post;
    private String comment;
    private CommentDTO repliedToComment;

    public CommentDTO(Comment comment){
        this.id=comment.getId();
        this.createdAt=comment.getCreatedAt();
        this.createdByUser=new EventronUserDTO(comment.getCreatedByUser());
        this.post=new ItemDTO(comment.getPost());
        this.comment=comment.getComment();
        this.repliedToComment=getRepliedToComment();

    }
}
