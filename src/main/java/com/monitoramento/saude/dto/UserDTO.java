package com.monitoramento.saude.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.monitoramento.saude.enums.UserRole;

import java.time.LocalDateTime;

public record UserDTO (
        Long usuario_id,
        String nomeCompleto,
        String email,
        String senha,
        UserRole regra,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
        LocalDateTime dataUpdate,
        String usuarioUpdate,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
        LocalDateTime dataCriacao) {
}
