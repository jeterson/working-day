package com.dio.bootcamp.workingday.services;

import com.dio.bootcamp.workingday.exceptions.EntityNotFoundException;
import com.dio.bootcamp.workingday.model.Movimentacao;
import com.dio.bootcamp.workingday.repositories.MovimentacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository MovimentacaoRepository;


    public Page<Movimentacao> findAll(Pageable pageable) {
        return MovimentacaoRepository.findAll(pageable);
    }

    public Movimentacao getById(Long id) {
        return MovimentacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Movimentacao.class, id));
    }

    public Movimentacao save(Movimentacao obj) {
        return MovimentacaoRepository.save(obj);
    }

    public void delete(Long id) {
        MovimentacaoRepository.deleteById(id);
    }

}
