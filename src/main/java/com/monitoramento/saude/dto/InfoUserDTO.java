package com.monitoramento.saude.dto;

import com.monitoramento.saude.enums.NivelAtividadeFisica;
import com.monitoramento.saude.enums.Sexo;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record InfoUserDTO (
    Long id,
    LocalDateTime dataRegistro,
    LocalDateTime dataNascimento,
    Integer idade,
    Sexo sexoBiologico,
    NivelAtividadeFisica nivelAtividadeFisica,
    String objetivo,
    String alergiasIntolerancias,
    String doencasPreExistentes,
    BigDecimal pesoAtual,
    BigDecimal pesoDesejado,
    BigDecimal medidaCintura,
    BigDecimal medidaQuadril,
    BigDecimal medidaTorax,
    BigDecimal medidaBraco,
    BigDecimal medidaAntebraco,
    BigDecimal medidaCoxa,
    BigDecimal medidaPanturrilha) {
}
