package com.dio.bootcamp.workingday.repositories;

import com.dio.bootcamp.workingday.model.Calendario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarioRepository extends JpaRepository<Calendario, Long>{
    
}
