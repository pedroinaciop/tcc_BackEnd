package com.monitoramento.saude.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.monitoramento.saude.dto.InfoUserDTO;
import com.monitoramento.saude.dto.UserDTO;
import com.monitoramento.saude.enums.NivelAtividadeFisica;
import com.monitoramento.saude.enums.Sexo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity(name = "info_usuario")
public class InfoUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private LocalDateTime dataRegistro;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private LocalDateTime dataNascimento;

    @Column(length = 3)
    private Integer idade;

    @Enumerated(EnumType.STRING)
    private Sexo sexoBiologico;

    @Enumerated(EnumType.STRING)
    private NivelAtividadeFisica nivelAtividadeFisica;

    @Column(length = 255)
    private String objetivo;

    @Column(length = 500)
    private String alergiasIntolerancias;

    private String doencasPreExistentes;

    private BigDecimal pesoAtual;

    private BigDecimal pesoDesejado;

    private BigDecimal medidaCintura;

    private BigDecimal medidaQuadril;

    private BigDecimal medidaTorax;

    private BigDecimal medidaBraco;

    private BigDecimal medidaAntebraco;

    private BigDecimal medidaCoxa;

    private BigDecimal medidaPanturrilha;

    public InfoUser(LocalDateTime dataRegistro, LocalDateTime dataNascimento, Integer idade, Sexo sexoBiologico, NivelAtividadeFisica nivelAtividadeFisica, String objetivo, String alergiasIntolerancias, String doencasPreExistentes, BigDecimal pesoAtual, BigDecimal pesoDesejado, BigDecimal medidaCintura, BigDecimal medidaQuadril, BigDecimal medidaTorax, BigDecimal medidaBraco, BigDecimal medidaAntebraco, BigDecimal medidaCoxa, BigDecimal medidaPanturrilha) {
        this.dataRegistro = dataRegistro;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.sexoBiologico = sexoBiologico;
        this.nivelAtividadeFisica = nivelAtividadeFisica;
        this.objetivo = objetivo;
        this.alergiasIntolerancias = alergiasIntolerancias;
        this.doencasPreExistentes = doencasPreExistentes;
        this.pesoAtual = pesoAtual;
        this.pesoDesejado = pesoDesejado;
        this.medidaCintura = medidaCintura;
        this.medidaQuadril = medidaQuadril;
        this.medidaTorax = medidaTorax;
        this.medidaBraco = medidaBraco;
        this.medidaAntebraco = medidaAntebraco;
        this.medidaCoxa = medidaCoxa;
        this.medidaPanturrilha = medidaPanturrilha;
    }

    public InfoUser(InfoUserDTO dados) {
        dataRegistro = dados.dataRegistro();
        dataNascimento = dados.dataNascimento();
        idade = dados.idade();
        sexoBiologico = dados.sexoBiologico();
        nivelAtividadeFisica = dados.nivelAtividadeFisica();
        objetivo = dados.objetivo();
        alergiasIntolerancias = dados.alergiasIntolerancias();
        doencasPreExistentes = dados.doencasPreExistentes();
        pesoAtual = dados.pesoAtual();
        pesoDesejado = dados.pesoDesejado();
        medidaCintura = dados.medidaCintura();
        medidaQuadril = dados.medidaQuadril();
        medidaTorax = dados.medidaQuadril();
        medidaBraco = dados.medidaBraco();
        medidaAntebraco = dados.medidaAntebraco();
        medidaCoxa = dados.medidaCoxa();
        medidaPanturrilha = dados.medidaPanturrilha();
    }
}
