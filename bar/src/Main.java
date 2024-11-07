import bar.models.Cliente;
import bar.service.ContaCalculator;
import bar.view.RelatorioConta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura dos dados do cliente
        System.out.print("Sexo (F ou M): ");
        char sexo = scanner.next().charAt(0);

        System.out.print("Quantidade de cervejas: ");
        int quantidadeCervejas = scanner.nextInt();

        System.out.print("Quantidade de refrigerantes: ");
        int quantidadeRefrigerantes = scanner.nextInt();

        System.out.print("Quantidade de espetinhos: ");
        int quantidadeEspetinhos = scanner.nextInt();

        // Criando objeto Cliente
        Cliente cliente = new Cliente(sexo, quantidadeCervejas, quantidadeRefrigerantes, quantidadeEspetinhos);

        // Criando objetos de cálculo e relatório
        ContaCalculator contaCalculator = new ContaCalculator();
        RelatorioConta relatorio = new RelatorioConta(contaCalculator);

        // Gerar relatório
        relatorio.gerarRelatorio(cliente);

        scanner.close();
    }
}
