package com.dio.bootcamp.workingday.services;

import com.dio.bootcamp.workingday.exceptions.EntityNotFoundException;
import com.dio.bootcamp.workingday.model.CategoriaUsuario;
import com.dio.bootcamp.workingday.repositories.CategoriaUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaUsuarioService {

    @Autowired
    private CategoriaUsuarioRepository repository;


    public Page<CategoriaUsuario> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public CategoriaUsuario getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(CategoriaUsuario.class, id));
    }

    public CategoriaUsuario save(CategoriaUsuario obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
