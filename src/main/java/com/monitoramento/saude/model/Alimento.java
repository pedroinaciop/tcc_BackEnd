package com.monitoramento.saude.model;

import com.monitoramento.saude.enums.UnidadeAlimento;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "alimento")
public class Alimento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome_alimento;

    @Enumerated(EnumType.STRING)
    private UnidadeAlimento unidade_alimento;

    private BigDecimal quantidade;

    @ManyToOne
    @JoinColumn(name = "refeicao_id")
    private Refeicao refeicao;
}
