package com.ex2;

public class NotaFiscal {
    private final String razaoSocial;
    private final String cnpj;
    private final double valorBruto;
    private final double impostos;
    private final String observacoes;

    // Construtor privado para forçar o uso do Builder
    protected NotaFiscal(String razaoSocial, String cnpj, double valorBruto, double impostos, String observacoes) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.valorBruto = valorBruto;
        this.impostos = impostos;
        this.observacoes = observacoes;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public double getImpostos() {
        return impostos;
    }

    public String getObservacoes() {
        return observacoes;
    }
}
