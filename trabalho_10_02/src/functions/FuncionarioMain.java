package functions;

import models.Funcionario;

import java.util.Scanner;

public class FuncionarioMain {
    public static void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String name = scanner.nextLine();

        System.out.print("Salário bruto: ");
        double grossSalary = scanner.nextDouble();

        System.out.print("Imposto: ");
        double tax = scanner.nextDouble();

        // Consumir a quebra de linha pendente
        scanner.nextLine();

        Funcionario funcionario = new Funcionario(name, grossSalary, tax);

        System.out.println("Funcionário: " + funcionario);

        System.out.print("Qual a porcentagem para aumentar o salário? ");
        String input = scanner.nextLine().replace(",", "."); // Substitui vírgula por ponto
        double percentage = Double.parseDouble(input); // Converte a string para double

        funcionario.aumentarSalario(percentage);

        System.out.println("Dados atualizados: " + funcionario);
    }
}