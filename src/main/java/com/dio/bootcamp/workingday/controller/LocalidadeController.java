package com.dio.bootcamp.workingday.controller;

import com.dio.bootcamp.workingday.model.Localidade;
import com.dio.bootcamp.workingday.services.LocalidadeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/localidade")
@Api(tags = {"Localidade"}, value = "Api Data Access Localidade")
public class LocalidadeController {

    @Autowired
    private LocalidadeService service;

    @PostMapping
    public ResponseEntity<Localidade> create(@RequestBody Localidade obj){
        obj =  service.save(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);

    }
    @PutMapping
    public ResponseEntity<Localidade> update(@RequestBody Localidade obj){
        obj = service.save(obj);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Localidade>> getAll(Pageable page) {
        return ResponseEntity.ok(service.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Localidade> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
