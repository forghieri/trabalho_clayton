package domain.usecase;

import domain.model.Agenda;
import domain.model.Compromisso;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class VerificarCompromissoUseCase {
    private final Agenda agenda;

    public VerificarCompromissoUseCase(Agenda agenda) {
        this.agenda = agenda;
    }

    public List<Compromisso> execute(LocalDate inicioPeriodo, Integer numeroDias) {
        return agenda.getCompromissos().stream()
                .filter(c -> c.pertencePeriodo(inicioPeriodo, numeroDias))
                .collect(Collectors.toList());
    }
}