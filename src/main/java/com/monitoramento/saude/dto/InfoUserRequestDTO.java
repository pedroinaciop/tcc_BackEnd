package com.monitoramento.saude.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.monitoramento.saude.enums.NivelAtividadeFisica;
import com.monitoramento.saude.enums.Sexo;
import com.monitoramento.saude.model.Usuario;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record InfoUserRequestDTO(
        Long id,

        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dataNascimento,
        Integer idade,

        Sexo sexoBiologico,

        NivelAtividadeFisica nivelAtividadeFisica,

        String objetivo,

        String alergias,

        String intolerancias,

        String doencasPreExistentes,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
        LocalDateTime dataAlteracao,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
        LocalDateTime dataRegistro,

        Usuario usuario) {
}