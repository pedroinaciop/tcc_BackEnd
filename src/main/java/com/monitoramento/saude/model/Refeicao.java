package com.monitoramento.saude.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.monitoramento.saude.enums.TipoRefeicao;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "refeicao")
public class Refeicao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MMMM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private TipoRefeicao tipoRefeicao;

    @OneToMany(mappedBy = "refeicao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemAlimentos> alimentos = new ArrayList<>();
}
