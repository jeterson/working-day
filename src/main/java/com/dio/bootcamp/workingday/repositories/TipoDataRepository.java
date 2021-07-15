package com.dio.bootcamp.workingday.repositories;

import java.util.Optional;

import com.dio.bootcamp.workingday.model.TipoData;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDataRepository extends JpaRepository<TipoData, Long>{
    
    Optional<TipoData> findByDescricao(String descricao);
}
