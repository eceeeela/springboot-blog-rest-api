package com.springboot.blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // add primary key
    private Long id;
    private String name;

    // by default, jpa will provide a column name as a field name
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;


    // create many to many relationship
    // FetchType.EAGER means whenever we load User entity, along with that it will also load its roles
    // CascadeType.ALL: whenever we save User, it will also save Roles, because user is a parent type, and role is child
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), // primary key of the user table: id
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id") // primary key of the role table

    )
    private Set<Role> roles;
}
