package domain.model;

import java.time.LocalDate;

public class Compromisso {
    private final String descricao;
    private final LocalDate dataInicio;
    private final LocalDate dataFim;

    public Compromisso(String descricao, LocalDate dataInicio, LocalDate dataFim) {
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public boolean pertencePeriodo(LocalDate inicioPeriodo, Integer numeroDias) {
        LocalDate fimPeriodo = inicioPeriodo.plusDays(numeroDias);
        return (dataInicio.isEqual(inicioPeriodo) || dataInicio.isAfter(inicioPeriodo)) &&
                (dataFim.isEqual(fimPeriodo) || dataFim.isBefore(fimPeriodo) || dataFim.isAfter(fimPeriodo));
    }

    @Override
    public String toString() {
        return "Compromisso: " + descricao + " [Início: " + dataInicio + ", Fim: " + dataFim + "]";
    }
}