package com.dio.bootcamp.workingday.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.dio.bootcamp.workingday.model.Calendario;
import com.dio.bootcamp.workingday.model.Movimentacao;
import com.dio.bootcamp.workingday.model.MovimentacaoPk;
import com.dio.bootcamp.workingday.model.Ocorrencia;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MovimentacaoDTO {
    
    @Min(value = 1)
    private Long calendarioId;
    @Min(value = 1)
    private Long ocorrenciaId;
    @NotNull
    @NotEmpty
    private String descricao;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataEntrada;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataSaida;
    @Min(value = 1)
    private Long usuarioId;
    @Min(value = 1)
    private Long movimentacaoId;
    private BigDecimal periodo;

    public Movimentacao convertToMovimentacao() {
        Movimentacao m = new Movimentacao();
        Calendario c = new Calendario();
        c.setId(calendarioId);
        m.setCalendario(c);
        Ocorrencia o = new Ocorrencia();
        o.setId(ocorrenciaId);
        m.setOcorrencia(o);
        
        m.setDataSaida(dataSaida);
        m.setDataEntrada(dataEntrada);        
        if(movimentacaoId == null || usuarioId == null ){
            m.setId(null);    
        }else {
            MovimentacaoPk pk = new MovimentacaoPk(movimentacaoId, usuarioId);
            m.setId(pk);
        }
        
        m.setPeriodo(periodo);
        m.setDescricao(descricao);
        return m;
    }

}
