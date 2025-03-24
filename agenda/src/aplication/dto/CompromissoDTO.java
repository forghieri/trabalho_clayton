package aplication.dto;

import java.time.LocalDate;

public class CompromissoDTO {
    public final String descricao;
    public final LocalDate dataInicio;
    public final LocalDate dataFim;

    public CompromissoDTO(String descricao, LocalDate dataInicio, LocalDate dataFim) {
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
}