package com.blogapp.blog.controller;

import com.blogapp.blog.DTOs.PostDTO;
import com.blogapp.blog.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private PostService postService;
    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping("/create")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){
        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<PostDTO> getAllPost(){
        return postService.getAllPost();
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }
    @PutMapping("{id}")
    public PostDTO updatePostById(@RequestBody PostDTO postDTO, @PathVariable long id){
        return postService.updatePostById(postDTO,id);
    }

    @DeleteMapping("{id}")
    public PostDTO deleteProductbyId(@PathVariable long id){
        return postService.deletePostById(id);
    }

}
