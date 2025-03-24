package domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Agenda {
    private final List<Compromisso> compromissos;

    public Agenda() {
        this.compromissos = new ArrayList<>();
    }

    public void adicionar(Compromisso compromisso) {
        compromissos.add(compromisso);
    }

    public List<Compromisso> getCompromissos() {
        return Collections.unmodifiableList(compromissos);
    }
}