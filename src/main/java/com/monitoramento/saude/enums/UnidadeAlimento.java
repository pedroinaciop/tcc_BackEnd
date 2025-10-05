package com.monitoramento.saude.enums;

public enum UnidadeAlimento {
    GRAMAS("g"),
    MILIGRAMAS("mg"),
    QUILOS("kg"),
    MILILITROS("ml"),
    LITROS("l"),
    COLHER("colher"),
    XICARA("xícara"),
    FATIA("fatia"),
    UNIDADE("unidade"),
    PEDACO("pedaço");

    private final String simbolo;

    UnidadeAlimento(String simbolo) {
        this.simbolo = simbolo;
    }
}
