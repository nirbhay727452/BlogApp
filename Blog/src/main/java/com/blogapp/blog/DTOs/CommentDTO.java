package com.blogapp.blog.DTOs;

import lombok.Data;

@Data
public class CommentDTO {
    private long id;
    private String mail;
    private String name;
    private String body;;


}
