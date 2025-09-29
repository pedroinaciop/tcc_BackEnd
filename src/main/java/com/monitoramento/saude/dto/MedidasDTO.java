package com.monitoramento.saude.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.time.LocalDate;

public record MedidasDTO(
        Long id,

        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dataRegistro,

        BigDecimal pesoAtual,

        BigDecimal pesoDesejado,

        BigDecimal medidaCintura,
        BigDecimal medidaQuadril,
        BigDecimal medidaTorax,

        BigDecimal medidaBracoDireito,
        BigDecimal medidaBracoEsquerdo,

        BigDecimal medidaAntebracoDireito,
        BigDecimal medidaAntebracoEsquerdo,

        BigDecimal medidaCoxaDireita,
        BigDecimal medidaCoxaEsquerda,

        BigDecimal medidaPanturrilhaDireita,
        BigDecimal medidaPanturrilhaEsquerda,

        BigDecimal altura,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDateTime dataAlteracao
) {
}
