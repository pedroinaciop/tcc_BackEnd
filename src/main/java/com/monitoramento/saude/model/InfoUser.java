package com.monitoramento.saude.model;

import com.monitoramento.saude.enums.NivelAtividadeFisica;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.monitoramento.saude.dto.InfoUserDTO;
import com.monitoramento.saude.enums.Sexo;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "info_usuario")
public class InfoUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(length = 500)
    private String intolerancias;

    @Column(length = 500)
    private String doencasPreExistentes;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime dataAlteracao;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime dataRegistro;

    public InfoUser() {}

    public InfoUser(Long id, LocalDateTime dataRegistro, LocalDate dataNascimento, Integer idade, Sexo sexoBiologico, NivelAtividadeFisica nivelAtividadeFisica, String objetivo, String alergias, String intolerancias, String doencasPreExistentes, LocalDateTime dataAlteracao) {
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
    }
}
