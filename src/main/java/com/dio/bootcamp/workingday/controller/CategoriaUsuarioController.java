package com.dio.bootcamp.workingday.controller;

import com.dio.bootcamp.workingday.model.CategoriaUsuario;
import com.dio.bootcamp.workingday.services.CategoriaUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/categorias")
@Api(tags = {"CategoriaUsuario"}, value = "Api Data Access CategoriaUsuario")
public class CategoriaUsuarioController {

    @Autowired
    private CategoriaUsuarioService service;

    @PostMapping
    public ResponseEntity<CategoriaUsuario> create(@RequestBody CategoriaUsuario obj){
        obj =  service.save(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);

    }
    @PutMapping
    public ResponseEntity<CategoriaUsuario> update(@RequestBody CategoriaUsuario obj){
        obj = service.save(obj);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<CategoriaUsuario>> getAll(Pageable page) {
        return ResponseEntity.ok(service.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaUsuario> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
