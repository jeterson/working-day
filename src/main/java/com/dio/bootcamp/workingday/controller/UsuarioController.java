package com.dio.bootcamp.workingday.controller;

import com.dio.bootcamp.workingday.model.Usuario;
import com.dio.bootcamp.workingday.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/usuarios")
@Api(tags = {"Usuario"}, value = "Api Data Access Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario obj){
        obj =  service.save(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);

    }
    @PutMapping
    public ResponseEntity<Usuario> update(@RequestBody Usuario obj){
        obj = service.save(obj);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Usuario>> getAll(Pageable page) {
        return ResponseEntity.ok(service.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
