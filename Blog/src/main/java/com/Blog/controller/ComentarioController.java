package com.Blog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Blog.Repository.ComentarioRepository;
import com.Blog.model.Comentario;

public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @PostMapping
    public ResponseEntity<Comentario> criarComentario(@RequestBody Comentario comentario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioRepository.save(comentario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> atualizarcomentarioagem(
            @PathVariable("id") Long idcomentario,
            @RequestBody Comentario comentarios) {
        Optional<Comentario> comentarioExistente = comentarioRepository.findById(idcomentario);

        if (comentarioExistente.isPresent()) {
            comentarioExistente.get().setTexto(comentarios.getTexto());
            comentarioExistente.get().setDataDeCriacao(comentarios.getDataDeCriacao());
            return ResponseEntity.status(HttpStatus.OK).body(comentarioRepository.save(comentarioExistente.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarItemPeloId(@PathVariable("id") Long id) {

        Optional<Comentario> comentarios = comentarioRepository.findById(id);
        if (comentarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        comentarioRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Comentario deletado com Sucesso!");
    }
}
