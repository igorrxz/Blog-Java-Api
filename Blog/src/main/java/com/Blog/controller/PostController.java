package com.Blog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blog.Repository.PostRepository;
import com.Blog.model.Post;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public ResponseEntity<List<Post>> listarPostagens () {
        return ResponseEntity.status(HttpStatus.OK).body(postRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> buscarPostagemPeloId(@PathVariable("id") Long idPost) {
        return ResponseEntity.status(HttpStatus.OK).body(postRepository.findById(idPost));
    }

    @PostMapping
    public ResponseEntity<Post> criarPostagem(@RequestBody Post post) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postRepository.save(post));
    }

     @PutMapping("/{id}")
    public ResponseEntity<Post> atualizarPostagem(
            @PathVariable("id") Long idPost,
            @RequestBody Post posts) {
        Optional<Post> postExistente = postRepository.findById(idPost);

        if (postExistente.isPresent()) {
            postExistente.get().setConteudo(posts.getConteudo());
            postExistente.get().setDataDeCriacao(posts.getDataDeCriacao());
            postExistente.get().setTitulo(posts.getTitulo());
            return ResponseEntity.status(HttpStatus.OK).body(postRepository.save(postExistente.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarItemPeloId(@PathVariable("id") Long id) {

        Optional<Post> posts = postRepository.findById(id);
        if (posts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
       postRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Post deletado com Sucesso!");
    }
}
