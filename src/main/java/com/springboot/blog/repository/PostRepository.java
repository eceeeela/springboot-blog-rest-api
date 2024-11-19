package com.springboot.blog.repository;

import com.springboot.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

// dont need @Repository because JpaRepository 里面有一个了（大概是这个意思）这个东西里面会take care

// communicate to CRUD
public interface PostRepository extends JpaRepository<Post, Long> {
}
