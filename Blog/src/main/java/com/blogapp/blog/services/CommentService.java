package com.blogapp.blog.services;

import com.blogapp.blog.DTOs.CommentDTO;

public interface CommentService {
    CommentDTO createComment(long postID, CommentDTO commentDTO);
}
