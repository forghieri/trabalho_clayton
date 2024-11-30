package service;

import model.Pais;
import java.text.DecimalFormat;
import java.util.List;

public class PaisService {

    private DecimalFormat formato = new DecimalFormat("#,###.##");

    public boolean isIgual(Pais pais1, Pais pais2) {
        return pais1.isIgual(pais2);
    }

    public String calcularDensidadePopulacional(Pais pais) {
        double densidade = pais.getPopulacao() / pais.getDimensao();
        return formato.format(densidade);
    }

    public String calcularRazaoTerritorial(Pais pais, List<Pais> paises) {
        double somaDimensao = 0;
        for (Pais p : paises) {
            somaDimensao += p.getDimensao();
        }
        double dimensaoMedia = somaDimensao / paises.size();
        double razao = pais.getDimensao() / dimensaoMedia;
        return formato.format(razao);
    }
}
