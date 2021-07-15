package com.dio.bootcamp.workingday.repositories;

import com.dio.bootcamp.workingday.model.CategoriaUsuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaUsuarioRepository extends JpaRepository<CategoriaUsuario, Long>{
    
}
