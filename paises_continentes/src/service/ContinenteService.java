package service;

import model.Continente;
import model.Pais;

public class ContinenteService {

    public double calcularDimensaoTotal(Continente continente) {
        double dimensaoTotal = 0;
        for (Pais pais : continente.getPaises()) {
            dimensaoTotal += pais.getDimensao();
        }
        return dimensaoTotal;
    }

    public long calcularPopulacaoTotal(Continente continente) {
        long populacaoTotal = 0;
        for (Pais pais : continente.getPaises()) {
            populacaoTotal += pais.getPopulacao();
        }
        return populacaoTotal;
    }

    public double calcularDensidadePopulacional(Continente continente) {
        double dimensaoTotal = calcularDimensaoTotal(continente);
        long populacaoTotal = calcularPopulacaoTotal(continente);
        return populacaoTotal / dimensaoTotal;
    }

    public Pais obterPaisMaiorPopulacao(Continente continente) {
        Pais maiorPopulacao = null;
        for (Pais pais : continente.getPaises()) {
            if (maiorPopulacao == null || pais.getPopulacao() > maiorPopulacao.getPopulacao()) {
                maiorPopulacao = pais;
            }
        }
        return maiorPopulacao;
    }

    public Pais obterPaisMenorPopulacao(Continente continente) {
        Pais menorPopulacao = null;
        for (Pais pais : continente.getPaises()) {
            if (menorPopulacao == null || pais.getPopulacao() < menorPopulacao.getPopulacao()) {
                menorPopulacao = pais;
            }
        }
        return menorPopulacao;
    }

    public Pais obterPaisMaiorDimensao(Continente continente) {
        Pais maiorDimensao = null;
        for (Pais pais : continente.getPaises()) {
            if (maiorDimensao == null || pais.getDimensao() > maiorDimensao.getDimensao()) {
                maiorDimensao = pais;
            }
        }
        return maiorDimensao;
    }

    public Pais obterPaisMenorDimensao(Continente continente) {
        Pais menorDimensao = null;
        for (Pais pais : continente.getPaises()) {
            if (menorDimensao == null || pais.getDimensao() < menorDimensao.getDimensao()) {
                menorDimensao = pais;
            }
        }
        return menorDimensao;
    }

    public double obterRazaoTerritorial(Continente continente) {
        Pais maiorPais = obterPaisMaiorDimensao(continente);
        Pais menorPais = obterPaisMenorDimensao(continente);
        return maiorPais.getDimensao() / menorPais.getDimensao();
    }
}
