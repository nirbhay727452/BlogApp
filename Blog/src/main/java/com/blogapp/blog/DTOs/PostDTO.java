package com.blogapp.blog.DTOs;

import lombok.Data;
@Data
public class PostDTO {
    private long id;
    private  String content;
    private String description;
    private String title;

}
