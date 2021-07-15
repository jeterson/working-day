package com.dio.bootcamp.workingday.controller;

import com.dio.bootcamp.workingday.model.JornadaTrabalho;
import com.dio.bootcamp.workingday.services.JornadaTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/jornada")
@Api(tags = {"JornadaTrabalho"}, value = "Api Data Access JornadaTrabalho")
public class JornadaTrabalhoController {

    @Autowired
    private JornadaTrabalhoService jornadaService;

    @PostMapping
    public ResponseEntity<JornadaTrabalho> create(@RequestBody JornadaTrabalho jornadaTrabalho){
        jornadaTrabalho =  jornadaService.save(jornadaTrabalho);
        return ResponseEntity.status(HttpStatus.CREATED).body(jornadaTrabalho);

    }
    @PutMapping
    public ResponseEntity<JornadaTrabalho> update(@RequestBody JornadaTrabalho jornadaTrabalho){
        jornadaTrabalho = jornadaService.save(jornadaTrabalho);
        return ResponseEntity.ok(jornadaTrabalho);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        jornadaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<JornadaTrabalho>> getAll(Pageable page) {
        return ResponseEntity.ok(jornadaService.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<JornadaTrabalho> getById(@PathVariable Long id) {
        return ResponseEntity.ok(jornadaService.getById(id));
    }
}
