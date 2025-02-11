package menu;

import java.util.Scanner;

public class MenuPrincipal {
    // Função para exibir o menu e retornar a opção escolhida
    public static int exibirMenu(Scanner scanner) {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Calcular área, perímetro e diagonal de um retângulo");
        System.out.println("2. Gerenciar dados de funcionários");
        System.out.println("3. Verificar nota final de alunos");
        System.out.println("4. Converter dólares para reais");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");

        // Verifica se a entrada é um número inteiro válido
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida! Digite um número.");
            scanner.next(); // Limpa o buffer do scanner
            System.out.print("Escolha uma opção: ");
        }

        return scanner.nextInt(); // Retorna a opção escolhida
    }

    // Função para executar o menu principal
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            opcao = exibirMenu(scanner); // Exibe o menu e obtém a opção do usuário

            switch (opcao) {
                case 1:
                    functions.RetanguloMain.executar();
                    break;
                case 2:
                    functions.FuncionarioMain.executar();
                    break;
                case 3:
                    functions.AlunoMain.executar();
                    break;
                case 4:
                    functions.CambioMain.executar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}