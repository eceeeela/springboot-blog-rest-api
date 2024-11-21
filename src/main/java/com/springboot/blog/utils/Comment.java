package com.springboot.blog.utils;

import com.springboot.blog.entity.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Pageable;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)  // the FetchType.LAZY tells hibernate to only fetch the related entities from the database when you use the relationship
    @JoinColumn(name = "post_id", nullable = false)  // to specify foriegn key
    private Post post; // one post can have many comments
}
