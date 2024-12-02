package models;

import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String codigoISO;
    private String nome;
    private long populacao;
    private double dimensao;
    private List<Pais> fronteiras;

    public Pais(String codigoISO, String nome, long populacao, double dimensao) {
        this.codigoISO = codigoISO;
        this.nome = nome;
        this.populacao = populacao;
        this.dimensao = dimensao;
        this.fronteiras = new ArrayList<>();
    }

    public String getCodigoISO() {
        return codigoISO;
    }

    public String getNome() {
        return nome;
    }

    public long getPopulacao() {
        return populacao;
    }

    public double getDimensao() {
        return dimensao;
    }

    public List<Pais> getFronteiras() {
        return fronteiras;
    }

    public void adicionarFronteira(Pais pais) {
        if (!this.fronteiras.contains(pais)) {
            this.fronteiras.add(pais);
        }
    }
}
