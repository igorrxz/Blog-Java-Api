package com.Blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    
}
