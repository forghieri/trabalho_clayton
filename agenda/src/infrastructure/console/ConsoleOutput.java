package infrastructure.console;

import domain.model.Compromisso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ConsoleOutput {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void displayMenu() {
        System.out.println("\n=== AGENDA DE COMPROMISSOS ===");
        System.out.println("1. Adicionar novo compromisso");
        System.out.println("2. Verificar compromissos");
        System.out.println("3. Sair");
    }

    public void displayCompromissos(List<Compromisso> compromissos, Integer numeroDias) {
        LocalDate inicio = LocalDate.now();
        System.out.printf("\nCompromissos de %s por %d dias:%n",
                inicio.format(FORMATTER), numeroDias);

        if (compromissos.isEmpty()) {
            System.out.println("Nenhum compromisso encontrado neste período.");
        } else {
            compromissos.forEach(System.out::println);
        }
    }

    public void displaySuccess() {
        System.out.println("Compromisso adicionado com sucesso!");
    }

    public void displayExit() {
        System.out.println("Saindo...");
    }

    public void displayError(String message) {
        System.out.println("Erro: " + message);
    }
}