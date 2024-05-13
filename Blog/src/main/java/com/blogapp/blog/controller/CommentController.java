package com.blogapp.blog.controller;

import com.blogapp.blog.DTOs.CommentDTO;
import com.blogapp.blog.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController
{
    private CommentService commentService;
    CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/post/{id}/comment/create")
    ResponseEntity<CommentDTO> createComment(@PathVariable(name = "id") Long postId,
                                 @RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(commentService.createComment(postId, commentDTO) , HttpStatus.CREATED);
    }
}
