package com.Blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blog.Repository.PostRepository;
import com.Blog.model.Post;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
    
    @PostMapping
    public ResponseEntity<Post> criarPostagem (@RequestBody Post post) {
        return ResponseEntity.status(HttpStatus.CREATED).body(PostRepository.save(post));
    }

}
