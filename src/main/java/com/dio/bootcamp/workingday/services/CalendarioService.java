package com.dio.bootcamp.workingday.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.dio.bootcamp.workingday.model.Calendario;
import com.dio.bootcamp.workingday.controller.dto.*;
import com.dio.bootcamp.workingday.model.TipoData;
import com.dio.bootcamp.workingday.repositories.CalendarioRepository;
import com.dio.bootcamp.workingday.repositories.TipoDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CalendarioService {
    
 

    @Autowired
    private CalendarioRepository calendarioRepository;
    @Autowired
    private TipoDataRepository tipoDataRepository;

    @Autowired
    private RestTemplate restTemplate;


    public void importarFeriadosNacionais() {
        ResponseEntity<CalendarioApiDTO[]> dados = restTemplate.getForEntity("https://dadosbr.github.io/feriados/nacionais.json", CalendarioApiDTO[].class);
        List<CalendarioApiDTO> dadosList = Arrays.asList(dados.getBody());
        TipoData tipoData = tipoDataRepository.findByDescricao("NACIONAL").get();
        
        List<Calendario> calendarios = dadosList.stream().map(c -> {
            Calendario calendario = new Calendario();
            int ano = LocalDate.now().getYear();
            if(c.getDate().isEmpty()) {
               calendario.setDataEspecial(null); 
            }else {
                c.setDate(c.getDate() + "/"+ano);
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");           
                calendario.setDataEspecial( LocalDate.parse(c.getDate(), fmt).atTime(0, 0));
            }
            
            calendario.setDescricao(c.getDescription());
            calendario.setTipoData(tipoData);
            return calendario;
        }).collect(Collectors.toList());

        calendarioRepository.saveAll(calendarios);
    }

}
