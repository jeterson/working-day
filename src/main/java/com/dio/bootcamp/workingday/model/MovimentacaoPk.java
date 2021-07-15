package com.dio.bootcamp.workingday.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable    
public class MovimentacaoPk implements Serializable {
    private Long movimentacaoId;
    private Long usuarioId;
}