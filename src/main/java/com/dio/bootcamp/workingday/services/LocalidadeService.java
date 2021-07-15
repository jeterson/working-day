package com.dio.bootcamp.workingday.services;

import com.dio.bootcamp.workingday.exceptions.EntityNotFoundException;
import com.dio.bootcamp.workingday.model.Localidade;
import com.dio.bootcamp.workingday.repositories.LocalidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LocalidadeService {

    @Autowired
    private LocalidadeRepository repository;


    public Page<Localidade> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Localidade getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Localidade.class, id));
    }

    public Localidade save(Localidade obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
