package com.dio.bootcamp.workingday.controller;

import javax.validation.Valid;

import com.dio.bootcamp.workingday.controller.dto.MovimentacaoDTO;
import com.dio.bootcamp.workingday.model.Movimentacao;
import com.dio.bootcamp.workingday.services.MovimentacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/movimentacao")
@Api(tags = {"Movimentacao"}, value = "Api Data Access Movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService service;

    @PostMapping
    public ResponseEntity<Movimentacao> create(@RequestBody @Valid MovimentacaoDTO dto){
        Movimentacao obj = service.save(dto.convertToMovimentacao());
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);

    }
    @PutMapping
    public ResponseEntity<Movimentacao> update(@RequestBody @Valid MovimentacaoDTO dto){
        Movimentacao obj = service.save(dto.convertToMovimentacao());
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Movimentacao>> getAll(Pageable page) {
        return ResponseEntity.ok(service.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
