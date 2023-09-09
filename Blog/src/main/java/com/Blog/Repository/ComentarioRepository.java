package com.Blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Blog.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    
}
