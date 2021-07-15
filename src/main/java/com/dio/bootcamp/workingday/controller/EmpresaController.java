package com.dio.bootcamp.workingday.controller;

import com.dio.bootcamp.workingday.model.BancoHoras;
import com.dio.bootcamp.workingday.model.Empresa;
import com.dio.bootcamp.workingday.model.Ocorrencia;
import com.dio.bootcamp.workingday.services.BancoHorasService;
import com.dio.bootcamp.workingday.services.EmpresaService;
import com.dio.bootcamp.workingday.services.OcorrenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/empresa")
@Api(tags = {"Empresa"}, value = "Api Data Access Empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody Empresa empresa){
        empresa =  empresaService.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);

    }
    @PutMapping
    public ResponseEntity<Empresa> update(@RequestBody Empresa empresa){
        empresa = empresaService.save(empresa);
        return ResponseEntity.ok(empresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Empresa>> getAll(Pageable page) {
        return ResponseEntity.ok(empresaService.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getById(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.getById(id));
    }
}
