package infrastructure.console;

import aplication.dto.CompromissoDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleInput {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    public int getMenuOption() {
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public CompromissoDTO getCompromissoInput() {
        scanner.nextLine(); // Limpar buffer
        System.out.print("Digite a descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Digite a data de início (dd/mm/aaaa): ");
        LocalDate dataInicio = LocalDate.parse(scanner.nextLine(), FORMATTER);

        System.out.print("Digite a data de fim (dd/mm/aaaa): ");
        LocalDate dataFim = LocalDate.parse(scanner.nextLine(), FORMATTER);

        return new CompromissoDTO(descricao, dataInicio, dataFim);
    }

    public Integer getNumeroDias() {
        System.out.print("Digite o número de dias à frente: ");
        return scanner.nextInt();
    }

    public void close() {
        scanner.close();
    }
}