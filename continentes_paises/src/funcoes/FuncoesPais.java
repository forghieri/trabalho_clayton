package funcoes;

import java.util.ArrayList;
import java.util.List;

import models.Pais;


public class FuncoesPais {

    public static boolean verificarIgualdadePais(Pais pais1, Pais pais2) {
        return pais1.getCodigoISO().equals(pais2.getCodigoISO());
    }

    public static boolean verificarFronteira(Pais pais1, Pais pais2) {
        return pais1.getFronteiras().contains(pais2);
    }

    public static double calcularDensidadePopulacional(Pais pais) {
        return pais.getPopulacao() / pais.getDimensao();
    }

    public static List<Pais> vizinhosComuns(Pais pais1, Pais pais2) {
        List<Pais> vizinhosComuns = new ArrayList<>();
        for (Pais vizinho1 : pais1.getFronteiras()) {
            for (Pais vizinho2 : pais2.getFronteiras()) {
                if (vizinho1.equals(vizinho2)) {
                    vizinhosComuns.add(vizinho1);
                }
            }
        }
        return vizinhosComuns;
    }
}
