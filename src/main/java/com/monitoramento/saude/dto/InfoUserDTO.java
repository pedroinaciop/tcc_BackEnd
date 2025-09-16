package com.monitoramento.saude.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.monitoramento.saude.enums.NivelAtividadeFisica;
import com.monitoramento.saude.enums.Sexo;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record InfoUserDTO (
        Long id,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataRegistro,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento,

        Integer idade,
        Sexo sexoBiologico,
        NivelAtividadeFisica nivelAtividadeFisica,
        String objetivo,
        String alergias,
        String intolerancias,
        String doencasPreExistentes,
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
        LocalDate dataAlteracao) {
}
