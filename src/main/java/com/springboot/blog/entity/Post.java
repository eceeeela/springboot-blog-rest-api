package com.springboot.blog.entity;


import com.springboot.blog.utils.Comment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
// A Lombok annotation that generates boilerplate code like getters, setters, toString(), equals(), and hashCode() methods.
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        // Sets the name of the database table as posts.
        // Enforces unique values for the title column in the database. This means no two rows can have the same title.
        name = "posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
)
public class Post {
    @Id
    // Denotes the primary key of the entity. Each record in the posts table will have a unique identifier.

    @GeneratedValue(
            strategy = GenerationType.IDENTITY
            // Uses the database's auto-increment feature.
            // The database generates a unique value for the id when a new row is inserted.
    )
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "content", nullable = false)
    private String content;


    // use set instead of list in here cuz set is not duplicable
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true) // remove parent it will be removed as well
    private Set<Comment> comments = new HashSet<>();
}
