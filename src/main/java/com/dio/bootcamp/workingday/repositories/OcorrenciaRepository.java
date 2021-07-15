package com.dio.bootcamp.workingday.repositories;


import com.dio.bootcamp.workingday.model.Ocorrencia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long>{
    
}
