package com.blogapp.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
    name="posts",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
        )
public class Post extends BaseClass{
    @Column(name = "title", nullable = false) // column name and properties
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(nullable = false)
    private String content;
}
