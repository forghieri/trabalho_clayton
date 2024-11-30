package model;

import java.text.DecimalFormat;
import java.util.List;

public class Pais {

    private String codigoISO;
    private String nome;
    private double populacao;
    private double dimensao;
    private List<Pais> vizinhos;

    private DecimalFormat formato = new DecimalFormat("#,###.##");

    public Pais(String codigoISO, String nome, double populacao, double dimensao) {
        this.codigoISO = codigoISO;
        this.nome = nome;
        this.populacao = populacao;
        this.dimensao = dimensao;
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    public void setCodigoISO(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPopulacao() {
        return populacao;
    }

    public void setPopulacao(double populacao) {
        this.populacao = populacao;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public List<Pais> getVizinhos() {
        return vizinhos;
    }

    public void setVizinhos(List<Pais> vizinhos) {
        this.vizinhos = vizinhos;
    }

    public boolean isIgual(Pais pais) {
        return this.codigoISO.equals(pais.getCodigoISO());
    }

    public String getDimensaoFormatada() {
        return formato.format(this.dimensao);
    }

    public String getPopulacaoFormatada() {
        return formato.format(this.populacao);
    }

    public double calcularDensidadePopulacional() {
        return populacao / dimensao;
    }
}
