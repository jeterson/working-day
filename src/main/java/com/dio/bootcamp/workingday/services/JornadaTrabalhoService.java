package com.dio.bootcamp.workingday.services;

import com.dio.bootcamp.workingday.exceptions.EntityNotFoundException;
import com.dio.bootcamp.workingday.model.JornadaTrabalho;
import com.dio.bootcamp.workingday.repositories.JornadaTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class JornadaTrabalhoService  {

    private JornadaTrabalhoRepository jornadaRepository;

    @Autowired
    public JornadaTrabalhoService(JornadaTrabalhoRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    public Page<JornadaTrabalho> findAll(Pageable pageable) {
        return jornadaRepository.findAll(pageable);
    }

    public JornadaTrabalho getById(Long idJornada) {
        return jornadaRepository.findById(idJornada).orElseThrow(() -> new EntityNotFoundException(JornadaTrabalho.class, idJornada));
    }

    public JornadaTrabalho save(JornadaTrabalho jornadaTrabalho) {
        return jornadaRepository.save(jornadaTrabalho);
    }
    public void delete(Long id) {
        jornadaRepository.deleteById(id);
    }

}
