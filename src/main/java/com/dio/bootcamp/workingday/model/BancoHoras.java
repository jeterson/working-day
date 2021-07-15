package com.dio.bootcamp.workingday.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BancoHoras {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public class BancoHorasPk implements Serializable {
        private Long bancoHorasId;
        private Long movimentoId;
        private Long usuarioId;

    }
    @EmbeddedId
    private BancoHorasPk id;
    private LocalDateTime dataTrabalho;
    private BigDecimal quantidadeHoras;
    private BigDecimal saldoHoras;



}
