package com.blogapp.blog.services.implementations;

import com.blogapp.blog.DTOs.CommentDTO;
import com.blogapp.blog.entity.Comment;
import com.blogapp.blog.entity.Post;
import com.blogapp.blog.exception.ResourceNotFoundException;
import com.blogapp.blog.repository.CommentRepository;
import com.blogapp.blog.repository.PostRepository;
import com.blogapp.blog.services.CommentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    //convert comment entity to comment dto;
    CommentDTO convertCommentEntityToCommentDTO(Comment comment){
        CommentDTO newCommentDTO = new CommentDTO();
        newCommentDTO.setBody(comment.getBody());
        newCommentDTO.setName(comment.getName());
        newCommentDTO.setMail(comment.getMail());
        newCommentDTO.setId(comment.getId());
        return newCommentDTO;
    }


    //convert comment dto to comment entity
    Comment convertCommentDTOtoCommentEntity(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setBody(commentDTO.getBody());
        comment.setName(commentDTO.getName());
        comment.setMail(commentDTO.getMail());
        return comment;
    }

    @Override
    public CommentDTO createComment(long postID, CommentDTO commentDTO) throws ResourceNotFoundException{
        Comment comment = convertCommentDTOtoCommentEntity(commentDTO);
        //retrieve post enity by id
        Optional<Post> optPost = postRepository.findById(postID);
        if(optPost.isEmpty())
            throw new ResourceNotFoundException("post","Id",Long.toString(postID));
        Post post = optPost.get();

        //set post to comment
        comment.setPost(post);

        //save to db
        Comment savedComment = commentRepository.save(comment);
        System.out.println(savedComment.toString());
        return convertCommentEntityToCommentDTO(savedComment);
    }
}
