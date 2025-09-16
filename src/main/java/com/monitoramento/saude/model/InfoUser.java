package com.monitoramento.saude.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.monitoramento.saude.dto.InfoUserDTO;
import com.monitoramento.saude.enums.NivelAtividadeFisica;
import com.monitoramento.saude.enums.Sexo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity(name = "info_usuario")
public class InfoUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataRegistro;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Column(length = 3)
    private Integer idade;

    @Enumerated(EnumType.STRING)
    private Sexo sexoBiologico;

    @Enumerated(EnumType.STRING)
    private NivelAtividadeFisica nivelAtividadeFisica;

    @Column(length = 255)
    private String objetivo;

    @Column(length = 500)
    private String alergias;

    private String intolerancias;

    private String doencasPreExistentes;

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

    public InfoUser() {}

    public InfoUser(Long id, LocalDate dataRegistro, LocalDate dataNascimento, Integer idade, Sexo sexoBiologico, NivelAtividadeFisica nivelAtividadeFisica, String objetivo, String alergias, String intolerancias, String doencasPreExistentes, BigDecimal pesoAtual, BigDecimal pesoDesejado, BigDecimal medidaCintura, BigDecimal medidaQuadril, BigDecimal medidaTorax, BigDecimal medidaBracoDireito, BigDecimal medidaBracoEsquerdo, BigDecimal medidaAntebracoDireito, BigDecimal medidaAntebracoEsquerdo, BigDecimal medidaCoxaDireita, BigDecimal medidaCoxaEsquerda, BigDecimal medidaPanturrilhaDireita, BigDecimal medidaPanturrilhaEsquerda, BigDecimal altura, LocalDateTime dataAlteracao) {
        this.id = id;
        this.dataRegistro = dataRegistro;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.sexoBiologico = sexoBiologico;
        this.nivelAtividadeFisica = nivelAtividadeFisica;
        this.objetivo = objetivo;
        this.alergias = alergias;
        this.intolerancias = intolerancias;
        this.doencasPreExistentes = doencasPreExistentes;
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

    public InfoUser(InfoUserDTO dados) {
        dataRegistro = dados.dataRegistro();
        dataNascimento = dados.dataNascimento();
        idade = dados.idade();
        sexoBiologico = dados.sexoBiologico();
        nivelAtividadeFisica = dados.nivelAtividadeFisica();
        objetivo = dados.objetivo();
        alergias = dados.alergias();
        intolerancias = dados.intolerancias();
        doencasPreExistentes = dados.doencasPreExistentes();
        pesoAtual = dados.pesoAtual();
        pesoDesejado = dados.pesoDesejado();
        medidaCintura = dados.medidaCintura();
        medidaQuadril = dados.medidaQuadril();
        medidaTorax = dados.medidaQuadril();
        medidaBracoDireito = dados.medidaBracoDireito();
        medidaBracoEsquerdo = dados.medidaBracoEsquerdo();
        medidaAntebracoDireito = dados.medidaAntebracoDireito();
        medidaAntebracoEsquerdo = dados.medidaAntebracoEsquerdo();
        medidaCoxaDireita = dados.medidaCoxaDireita();
        medidaCoxaEsquerda = dados.medidaCoxaEsquerda();
        medidaPanturrilhaDireita = dados.medidaPanturrilhaDireita();
        medidaPanturrilhaEsquerda = dados.medidaPanturrilhaEsquerda();
        altura = dados.altura();
    }
}
