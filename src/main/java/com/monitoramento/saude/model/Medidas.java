package com.monitoramento.saude.model;

import com.monitoramento.saude.dto.MedidasDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "medidas")
public class Medidas {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataRegistro;

    private BigDecimal pesoAtual;

    private BigDecimal pesoDesejado;

    private BigDecimal medidaCintura;

    private BigDecimal medidaQuadril;

    private BigDecimal medidaTorax;

    private BigDecimal medidaBracoDireito;
    private BigDecimal medidaBracoEsquerdo;

    private BigDecimal medidaAntebracoDireito;
    private BigDecimal medidaAntebracoEsquerdo;

    private BigDecimal medidaCoxaDireita;
    private BigDecimal medidaCoxaEsquerda;

    private BigDecimal medidaPanturrilhaDireita;
    private BigDecimal medidaPanturrilhaEsquerda;

    private BigDecimal altura;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime dataAlteracao;

    public Medidas() {}

    public Medidas(Long id, LocalDate dataRegistro, BigDecimal pesoAtual, BigDecimal pesoDesejado, BigDecimal medidaCintura, BigDecimal medidaQuadril, BigDecimal medidaTorax, BigDecimal medidaBracoDireito, BigDecimal medidaBracoEsquerdo, BigDecimal medidaAntebracoDireito, BigDecimal medidaAntebracoEsquerdo, BigDecimal medidaCoxaDireita, BigDecimal medidaCoxaEsquerda, BigDecimal medidaPanturrilhaDireita, BigDecimal medidaPanturrilhaEsquerda, BigDecimal altura, LocalDateTime dataAlteracao) {
        this.id = id;
        this.dataRegistro = dataRegistro;
        this.pesoAtual = pesoAtual;
        this.pesoDesejado = pesoDesejado;
        this.medidaCintura = medidaCintura;
        this.medidaQuadril = medidaQuadril;
        this.medidaTorax = medidaTorax;
        this.medidaBracoDireito = medidaBracoDireito;
        this.medidaBracoEsquerdo = medidaBracoEsquerdo;
        this.medidaAntebracoDireito = medidaAntebracoDireito;
        this.medidaAntebracoEsquerdo = medidaAntebracoEsquerdo;
        this.medidaCoxaDireita = medidaCoxaDireita;
        this.medidaCoxaEsquerda = medidaCoxaEsquerda;
        this.medidaPanturrilhaDireita = medidaPanturrilhaDireita;
        this.medidaPanturrilhaEsquerda = medidaPanturrilhaEsquerda;
        this.altura = altura;
        this.dataAlteracao = dataAlteracao;
    }

    public Medidas(MedidasDTO dados) {
        dataRegistro = dados.dataRegistro();
        pesoAtual = dados.pesoAtual();
        pesoDesejado = dados.pesoDesejado();
        medidaCintura = dados.medidaCintura();
        medidaQuadril = dados.medidaQuadril();
        medidaTorax = dados.medidaTorax();
        medidaBracoDireito = dados.medidaBracoDireito();
        medidaBracoEsquerdo = dados.medidaBracoEsquerdo();
        medidaAntebracoDireito = dados.medidaAntebracoDireito();
        medidaAntebracoEsquerdo = dados.medidaAntebracoEsquerdo();
        medidaCoxaDireita = dados.medidaCoxaDireita();
        medidaCoxaEsquerda = dados.medidaCoxaEsquerda();
        medidaPanturrilhaDireita = dados.medidaPanturrilhaDireita();
        medidaPanturrilhaEsquerda = dados.medidaPanturrilhaEsquerda();
        altura = dados.altura();
        dataAlteracao = dados.dataAlteracao();
    }
}