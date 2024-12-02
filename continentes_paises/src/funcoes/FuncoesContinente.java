package funcoes;

import models.Pais;
import models.Continente;

import java.util.List;

public class FuncoesContinente {

    // Método para obter a dimensão total de um continente
    public static double obterDimensaoTotal(Continente continente) {
        double dimensaoTotal = 0;
        for (Pais pais : continente.getPaises()) {
            dimensaoTotal += pais.getDimensao();
        }
        return dimensaoTotal;
    }

    // Método para obter a população total de um continente
    public static long obterPopulacaoTotal(Continente continente) {
        long populacaoTotal = 0;
        for (Pais pais : continente.getPaises()) {
            populacaoTotal += pais.getPopulacao();
        }
        return populacaoTotal;
    }

    // Método para obter a densidade populacional de um continente
    public static double obterDensidadePopulacional(Continente continente) {
        double dimensaoTotal = obterDimensaoTotal(continente);
        long populacaoTotal = obterPopulacaoTotal(continente);
        return populacaoTotal / dimensaoTotal;
    }

    // Método para encontrar o país com maior população no continente
    public static Pais getPaisMaiorPopulacao(Continente continente) {
        Pais paisMaiorPopulacao = null;
        long maiorPopulacao = 0;

        for (Pais pais : continente.getPaises()) {
            if (pais.getPopulacao() > maiorPopulacao) {
                maiorPopulacao = pais.getPopulacao();
                paisMaiorPopulacao = pais;
            }
        }

        return paisMaiorPopulacao;
    }

    // Método para encontrar o país com menor população no continente
    public static Pais getPaisMenorPopulacao(Continente continente) {
        Pais paisMenorPopulacao = null;
        long menorPopulacao = Long.MAX_VALUE;

        for (Pais pais : continente.getPaises()) {
            if (pais.getPopulacao() < menorPopulacao) {
                menorPopulacao = pais.getPopulacao();
                paisMenorPopulacao = pais;
            }
        }

        return paisMenorPopulacao;
    }

    // Método para encontrar o país com maior dimensão territorial no continente
    public static Pais getPaisMaiorDimensao(Continente continente) {
        Pais paisMaiorDimensao = null;
        double maiorDimensao = 0;

        for (Pais pais : continente.getPaises()) {
            if (pais.getDimensao() > maiorDimensao) {
                maiorDimensao = pais.getDimensao();
                paisMaiorDimensao = pais;
            }
        }

        return paisMaiorDimensao;
    }

    // Método para encontrar o país com menor dimensão territorial no continente
    public static Pais getPaisMenorDimensao(Continente continente) {
        Pais paisMenorDimensao = null;
        double menorDimensao = Double.MAX_VALUE;

        for (Pais pais : continente.getPaises()) {
            if (pais.getDimensao() < menorDimensao) {
                menorDimensao = pais.getDimensao();
                paisMenorDimensao = pais;
            }
        }

        return paisMenorDimensao;
    }

    // Método para calcular a razão territorial (maior país / menor país)
    public static double calcularRazaoTerritorial(Continente continente) {
        Pais maiorPais = getPaisMaiorDimensao(continente);
        Pais menorPais = getPaisMenorDimensao(continente);

        if (maiorPais != null && menorPais != null) {
            return maiorPais.getDimensao() / menorPais.getDimensao();
        }
        return 0;
    }
}
