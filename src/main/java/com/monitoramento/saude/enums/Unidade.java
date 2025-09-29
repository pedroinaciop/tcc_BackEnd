package com.monitoramento.saude.enums;

public enum Unidade {
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

    Unidade(String simbolo) {
        this.simbolo = simbolo;
    }
}
