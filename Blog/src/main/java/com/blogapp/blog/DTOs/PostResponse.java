package com.blogapp.blog.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PostResponse {
    private List<PostDTO> content;
    private int pageNO;
    private int pageSize;
    private  int totalPage;
    private long totalelements;
    private boolean isLast;

}
