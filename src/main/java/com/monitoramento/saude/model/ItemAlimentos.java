package com.monitoramento.saude.model;

import com.monitoramento.saude.enums.CategoriaAlimento;
import com.monitoramento.saude.enums.Unidade;
import jakarta.persistence.*;

@Entity(name = "itemAlimentos")
public class ItemAlimentos {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private CategoriaAlimento categoriaAlimento;

    @Enumerated(EnumType.STRING)
    private Unidade unidade;

    @ManyToOne
    @JoinColumn(name = "refeicao_id")
    private Refeicao refeicao;
}
