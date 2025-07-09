package com.ex2;

public class NFBuilder {
    private String razaoSocial;
    private String cnpj;
    private double valorBruto;
    private double impostos;
    private String observacoes;

    public NFBuilder razaoSocial(String razaoSocial){
        this.razaoSocial = razaoSocial;
        return this;
    }
    public NFBuilder cnpj(String cnpj){
        this.cnpj = cnpj;
        return this;
    }
    public NFBuilder valorBruto(double valorBruto){
        this.valorBruto = valorBruto;
        return this;
    }
    public NFBuilder impostos(double impostos){
        this.impostos = impostos;
        return this;
    }
    public NFBuilder observacoes(String observacoes){
        this.observacoes = observacoes;
        return this;
    }

    public NotaFiscal build(){
        return new NotaFiscal(razaoSocial, cnpj, valorBruto, impostos, observacoes);
    }
}
