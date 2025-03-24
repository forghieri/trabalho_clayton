package aplication.service;

import aplication.dto.CompromissoDTO;
import domain.model.Agenda;
import domain.model.Compromisso;
import domain.usecase.AdicionarCompromissoUseCase;
import domain.usecase.VerificarCompromissoUseCase;

import java.time.LocalDate;
import java.util.List;

public class AgendaService {
    private final AdicionarCompromissoUseCase adicionarUseCase;
    private final VerificarCompromissoUseCase verificarUseCase;

    public AgendaService(Agenda agenda) {
        this.adicionarUseCase = new AdicionarCompromissoUseCase(agenda);
        this.verificarUseCase = new VerificarCompromissoUseCase(agenda);
    }

    public void adicionarCompromisso(CompromissoDTO dto) {
        Compromisso compromisso = new Compromisso(dto.descricao, dto.dataInicio, dto.dataFim);
        adicionarUseCase.execute(compromisso);
    }

    public List<Compromisso> verificarCompromissos(Integer numeroDias) {
        return verificarUseCase.execute(LocalDate.now(), numeroDias);
    }
}