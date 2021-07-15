package com.dio.bootcamp.workingday.controller;

import com.dio.bootcamp.workingday.model.BancoHoras;
import com.dio.bootcamp.workingday.model.Ocorrencia;
import com.dio.bootcamp.workingday.services.BancoHorasService;
import com.dio.bootcamp.workingday.services.OcorrenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/banco-horas")
@Api(tags = {"BancoHoras"}, value = "Api Data Access BancoHoras")
public class BancoHorasController {

    @Autowired
    private BancoHorasService bancoHorasService;

    @PostMapping
    public ResponseEntity<BancoHoras> create(@RequestBody BancoHoras bancoHoras){
        bancoHoras =  bancoHorasService.save(bancoHoras);
        return ResponseEntity.status(HttpStatus.CREATED).body(bancoHoras);

    }
    @PutMapping
    public ResponseEntity<BancoHoras> update(@RequestBody BancoHoras bancoHoras){
        bancoHoras = bancoHorasService.save(bancoHoras);
        return ResponseEntity.ok(bancoHoras);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bancoHorasService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<BancoHoras>> getAll(Pageable page) {
        return ResponseEntity.ok(bancoHorasService.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BancoHoras> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bancoHorasService.getById(id));
    }
}
