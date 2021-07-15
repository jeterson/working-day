package com.dio.bootcamp.workingday.services;

import com.dio.bootcamp.workingday.exceptions.EntityNotFoundException;
import com.dio.bootcamp.workingday.model.Ocorrencia;
import com.dio.bootcamp.workingday.repositories.OcorrenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OcorrenciaService {

    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    public OcorrenciaService(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    public Page<Ocorrencia> findAll(Pageable pageable) {
        return ocorrenciaRepository.findAll(pageable);
    }

    public Ocorrencia getById(Long idJornada) {
        return ocorrenciaRepository.findById(idJornada)
                .orElseThrow(() -> new EntityNotFoundException(Ocorrencia.class, idJornada));
    }

    public Ocorrencia save(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }

    public void delete(Long id) {
        ocorrenciaRepository.deleteById(id);
    }

}
