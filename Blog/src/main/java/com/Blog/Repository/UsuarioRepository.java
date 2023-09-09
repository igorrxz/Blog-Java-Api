package com.Blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Blog.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
