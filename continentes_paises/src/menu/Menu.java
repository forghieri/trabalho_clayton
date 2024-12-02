package menu;

import funcoes.FuncoesPais;
import funcoes.FuncoesContinente;
import dados.DadosPais;
import dados.DadosContinente;
import models.Pais;
import models.Continente;
import java.util.Scanner;

public class Menu {

    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar País");
            System.out.println("2 - Adicionar Continente");
            System.out.println("3 - Adicionar Fronteira");
            System.out.println("4 - Verificar Igualdade de Países");
            System.out.println("5 - Verificar Vizinhos Comuns");
            System.out.println("6 - Verificar Densidade Populacional");
            System.out.println("7 - País com Maior População");
            System.out.println("8 - País com Menor População");
            System.out.println("9 - País com Maior Dimensão Territorial");
            System.out.println("10 - País com Menor Dimensão Territorial");
            System.out.println("11 - Razão Territorial");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    Pais pais = DadosPais.adicionarPais(scanner);
                    System.out.println("Digite o nome do continente:");
                    String nomeContinente = scanner.nextLine();
                    Continente continente = new Continente(nomeContinente);
                    DadosPais.adicionarPaisAoContinente(pais, continente);
                    break;
                case 2:
                    Continente continenteAdicionado = DadosContinente.adicionarContinente(scanner);
                    System.out.println("Continente " + continenteAdicionado.getNome() + " adicionado.");
                    break;
                case 3:
                    System.out.println("Digite o código ISO do primeiro país:");
                    String codigoISO1 = scanner.nextLine();
                    System.out.println("Digite o código ISO do segundo país:");
                    String codigoISO2 = scanner.nextLine();
                    // Lógica para adicionar fronteira
                    break;
                case 4:
                    // Verificar Igualdade
                    break;
                case 5:
                    // Verificar vizinhos comuns
                    break;
                case 6:
                    // Densidade populacional
                    break;
                case 7:
                    // País com maior população
                    break;
                case 8:
                    // País com menor população
                    break;
                case 9:
                    // País com maior dimensão
                    break;
                case 10:
                    // País com menor dimensão
                    break;
                case 11:
                    // Razão Territorial
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
