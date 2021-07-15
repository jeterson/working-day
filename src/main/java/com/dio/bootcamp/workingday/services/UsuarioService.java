package com.dio.bootcamp.workingday.services;

import com.dio.bootcamp.workingday.exceptions.EntityNotFoundException;
import com.dio.bootcamp.workingday.model.Usuario;
import com.dio.bootcamp.workingday.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    public Usuario getById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Usuario.class, id));
    }

    public Usuario save(Usuario obj) {
        return usuarioRepository.save(obj);
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

}
