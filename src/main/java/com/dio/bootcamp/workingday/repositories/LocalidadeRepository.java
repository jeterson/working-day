package com.dio.bootcamp.workingday.repositories;

import com.dio.bootcamp.workingday.model.Localidade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalidadeRepository extends JpaRepository<Localidade, Long>{
    
}