package com.dio.bootcamp.workingday.controller;

import com.dio.bootcamp.workingday.model.Ocorrencia;
import com.dio.bootcamp.workingday.services.OcorrenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/ocorrencia")
@Api(tags = {"Ocorrencia"}, value = "Api Data Access Ocorrencia")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    @PostMapping
    public ResponseEntity<Ocorrencia> create(@RequestBody Ocorrencia ocorrencia){
        ocorrencia =  ocorrenciaService.save(ocorrencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(ocorrencia);

    }
    @PutMapping
    public ResponseEntity<Ocorrencia> update(@RequestBody Ocorrencia ocorrencia){
        ocorrencia = ocorrenciaService.save(ocorrencia);
        return ResponseEntity.ok(ocorrencia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ocorrenciaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Ocorrencia>> getAll(Pageable page) {
        return ResponseEntity.ok(ocorrenciaService.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ocorrenciaService.getById(id));
    }
}
