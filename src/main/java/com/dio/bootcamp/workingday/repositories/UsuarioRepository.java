package com.dio.bootcamp.workingday.repositories;

import com.dio.bootcamp.workingday.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
