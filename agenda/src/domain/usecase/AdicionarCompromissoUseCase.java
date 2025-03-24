package domain.usecase;

import domain.model.Agenda;
import domain.model.Compromisso;

public class AdicionarCompromissoUseCase {
    private final Agenda agenda;

    public AdicionarCompromissoUseCase(Agenda agenda) {
        this.agenda = agenda;
    }

    public void execute(Compromisso compromisso) {
        agenda.adicionar(compromisso);
    }
}