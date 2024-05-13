package com.blogapp.blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
    name="post",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
        )
public class Post extends BaseClass{
    @Column(name = "title", nullable = false) // column name and properties
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(name = "description", nullable = false)
    private String description;
    @OneToMany(mappedBy = "post" , cascade = CascadeType.ALL , orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();
}
