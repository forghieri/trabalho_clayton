package functions;

import models.Aluno;

import java.util.Scanner;

public class AlunoMain {
    public static void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do aluno: ");
        String name = scanner.nextLine();

        System.out.print("Nota do primeiro trimestre: ");
        String input1 = scanner.nextLine().replace(",", ".");
        double nota1 = Double.parseDouble(input1);

        System.out.print("Nota do segundo trimestre: ");
        String input2 = scanner.nextLine().replace(",", ".");
        double nota2 = Double.parseDouble(input2);

        System.out.print("Nota do terceiro trimestre: ");
        String input3 = scanner.nextLine().replace(",", ".");
        double nota3 = Double.parseDouble(input3);

        Aluno aluno = new Aluno(name, nota1, nota2, nota3);

        System.out.printf("NOTA FINAL = %.32f%n", aluno.calcularNotaFinal());
        System.out.println(aluno.verificarAprovacao());
    }
}