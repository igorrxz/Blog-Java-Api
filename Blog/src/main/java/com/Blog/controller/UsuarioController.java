package com.Blog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.Blog.Repository.UsuarioRepository;
import com.Blog.model.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> cadastrarCategoria(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<Usuario>> listarUsuarios(Pageable paginacao) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarPeloId(@PathVariable("id") Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            usuarioExistente.get().setEmail(usuario.getEmail());
            usuarioExistente.get().setSenha(usuario.getSenha());
            usuarioExistente.get().setNome(usuario.getNome());
            usuarioExistente.get().setSobrenome(usuario.getSobrenome());

            return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuarioExistente.get()));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerPeloId(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        usuarioRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuario deletada com sucesso!");
    }

}
