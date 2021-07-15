package com.dio.bootcamp.workingday.repositories;



import com.dio.bootcamp.workingday.model.BancoHoras;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoHorasRepository extends JpaRepository<BancoHoras, Long>{
    
}