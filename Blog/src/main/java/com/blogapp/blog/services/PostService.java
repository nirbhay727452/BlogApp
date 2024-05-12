package com.blogapp.blog.services;

import com.blogapp.blog.DTOs.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
    List<PostDTO> getAllPost();
    PostDTO getPostById(Long id);

    PostDTO updatePostById(PostDTO postDTO, Long id);

    PostDTO deletePostById(long id);
}
