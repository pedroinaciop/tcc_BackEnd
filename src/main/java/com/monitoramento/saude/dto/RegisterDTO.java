package com.monitoramento.saude.dto;

import com.monitoramento.saude.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.time.LocalDateTime;

public record RegisterDTO(String nomeCompleto,
                          String login,
                          String senha,
                          UserRole regra,
                          @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
                          LocalDateTime dataCriacao
) {
}
