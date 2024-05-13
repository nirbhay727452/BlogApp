package com.blogapp.blog.services;

import com.blogapp.blog.DTOs.CommentDTO;

import java.util.List;

public interface CommentService {
    CommentDTO createComment(long postID, CommentDTO commentDTO);
    List<CommentDTO> getAllComment(long postId);
    CommentDTO getCommentById(Long postId, Long commentId);
}
