package com.dio.bootcamp.workingday.services;

import com.dio.bootcamp.workingday.exceptions.EntityNotFoundException;
import com.dio.bootcamp.workingday.model.Empresa;
import com.dio.bootcamp.workingday.repositories.EmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    
    @Autowired
    private EmpresaRepository empresaRepository;

    public Page<Empresa> findAll(Pageable pageable) {
        return empresaRepository.findAll(pageable);
    }

    public Empresa getById(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Empresa.class, id));
    }

    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }
}
