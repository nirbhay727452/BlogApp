package com.blogapp.blog.services;

import com.blogapp.blog.DTOs.PostDTO;
import com.blogapp.blog.DTOs.PostResponse;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO);
    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDTO getPostById(Long id);

    PostDTO updatePostById(PostDTO postDTO, Long id);

    PostDTO deletePostById(long id);
}
