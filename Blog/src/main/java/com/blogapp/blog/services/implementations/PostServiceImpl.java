package com.blogapp.blog.services.implementations;

import com.blogapp.blog.DTOs.PostDTO;
import com.blogapp.blog.entity.Post;
import com.blogapp.blog.exception.ResourceNotFoundException;
import com.blogapp.blog.repository.PostRepository;
import com.blogapp.blog.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private Post convertDTOtoEntity(PostDTO postDTO){
        Post newPost = new Post();
        newPost.setTitle(postDTO.getTitle());
        newPost.setDescription(postDTO.getDescription());
        newPost.setContent(postDTO.getContent());
        return newPost;
    }

    private PostDTO convertEntityTODTO( Post post){
        PostDTO newpostDTO = new PostDTO();
        newpostDTO.setContent(post.getContent());
        newpostDTO.setDescription(post.getDescription());
        newpostDTO.setTitle(post.getTitle());
        newpostDTO.setId(post.getId());
        return newpostDTO;

    }

    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @Override
    public PostDTO createPost(PostDTO postDTO) {
        //convert DTO to Entity
        Post post = convertDTOtoEntity(postDTO);

        Post savedPost =  postRepository.save(post);

        //convert savedPost to DTO
        PostDTO responsepostDTO = convertEntityTODTO(savedPost);
        return responsepostDTO;
    }

    @Override
    public List<PostDTO> getAllPost() {
        List<Post> listOfPost = postRepository.findAll();
        return listOfPost.stream().map(post -> convertEntityTODTO(post)).collect(Collectors.toList());
    }

    @Override
    public PostDTO getPostById(Long id) throws ResourceNotFoundException{
        Optional<Post> post = postRepository.findById(id);
        if(post.isEmpty()) {
            throw  new ResourceNotFoundException("post","id",Long.toString(id));
        }
        return convertEntityTODTO(post.get());
    }

    @Override
    public PostDTO updatePostById(PostDTO postDTO, Long id) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isEmpty())
            throw  new ResourceNotFoundException("post","id",Long.toString(id));
        Post updatedPost = post.get();
        updatedPost.setContent(postDTO.getContent());
        updatedPost.setDescription(postDTO.getDescription());
        updatedPost.setTitle(postDTO.getTitle());

        Post savedPost = postRepository.save(updatedPost);
        return convertEntityTODTO(savedPost);
    }

    @Override
    public PostDTO deletePostById(long id) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isEmpty())
            throw  new ResourceNotFoundException("post","id",Long.toString(id));
        postRepository.deleteById(id);
        return convertEntityTODTO(post.get());
    }


}
