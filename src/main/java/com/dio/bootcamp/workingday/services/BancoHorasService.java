package com.dio.bootcamp.workingday.services;

import com.dio.bootcamp.workingday.exceptions.EntityNotFoundException;
import com.dio.bootcamp.workingday.model.BancoHoras;
import com.dio.bootcamp.workingday.repositories.BancoHorasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BancoHorasService {

    private BancoHorasRepository bancoHorasRepository;

    @Autowired
    public BancoHorasService(BancoHorasRepository bancoHorasRepository) {
        this.bancoHorasRepository = bancoHorasRepository;
    }

    public Page<BancoHoras> findAll(Pageable pageable) {
        return bancoHorasRepository.findAll(pageable);
    }

    public BancoHoras getById(Long id) {
        return bancoHorasRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(BancoHoras.class, id));
    }

    public BancoHoras save(BancoHoras bancoHoras) {
        return bancoHorasRepository.save(bancoHoras);
    }

    public void delete(Long id) {
        bancoHorasRepository.deleteById(id);
    }

}
