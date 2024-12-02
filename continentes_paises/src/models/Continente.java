package models;

import java.util.ArrayList;
import java.util.List;

public class Continente {
    private String nome;
    private List<Pais> paises;

    public Continente(String nome) {
        this.nome = nome;
        this.paises = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void adicionarPais(Pais pais) {
        paises.add(pais);
    }
}
