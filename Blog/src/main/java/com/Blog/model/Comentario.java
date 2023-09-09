package com.Blog.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_comentarios")
public class Comentario {

    @Column(columnDefinition = "TEXT")
    private String texto;

    @Column(nullable = false)
    private LocalDate dataDeCriacao;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;

}
