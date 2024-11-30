package model;

import java.util.ArrayList;
import java.util.List;

public class Continente {
    private String nome;
    private List<Pais> paises;

    public Continente(String nome) {
        this.nome = nome;
        this.paises = new ArrayList<>();
    }

    public void adicionarPais(Pais pais) {
        this.paises.add(pais);
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public String getNome() {
        return nome;
    }
}
