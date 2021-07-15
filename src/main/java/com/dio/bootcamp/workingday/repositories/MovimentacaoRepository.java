package com.dio.bootcamp.workingday.repositories;

import com.dio.bootcamp.workingday.model.Movimentacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long>{
    
}
