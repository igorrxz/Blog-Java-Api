package com.Blog.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;
    
    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String conteudo;

    @Column(nullable = false)
    private LocalDate dataDeCriacao;

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;

}
