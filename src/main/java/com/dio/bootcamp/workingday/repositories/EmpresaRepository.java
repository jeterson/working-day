package com.dio.bootcamp.workingday.repositories;

import com.dio.bootcamp.workingday.model.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    
}
