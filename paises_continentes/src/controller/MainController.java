package controller;

import model.Continente;
import model.Pais;
import service.ContinenteService;
import dados.PaisesData;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class MainController {

    private ContinenteService continenteService;
    private Continente continente;

    public MainController() {
        continenteService = new ContinenteService();
        continente = new Continente("América do Sul");
        adicionarPaisesAoContinente();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Mostrar Dimensão Total do Continente");
            System.out.println("2. Mostrar População Total do Continente");
            System.out.println("3. Mostrar Densidade Populacional do Continente");
            System.out.println("4. Mostrar País com Maior População");
            System.out.println("5. Mostrar País com Menor População");
            System.out.println("6. Mostrar País com Maior Dimensão Territorial");
            System.out.println("7. Mostrar País com Menor Dimensão Territorial");
            System.out.println("8. Mostrar Razão Territorial entre Maior e Menor País");
            System.out.println("9. Mostrar Quantidade Total de Países e Listagem Completa");
            System.out.println("10. Sair");
            System.out.println("\nEscolha:");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a linha de quebra após o número

            switch (opcao) {
                case 1:
                    System.out.println("Dimensão total do continente: " + formatarArea(continenteService.calcularDimensaoTotal(continente)) + " km²");
                    break;
                case 2:
                    System.out.println("População total do continente: " + formatarPopulacao(continenteService.calcularPopulacaoTotal(continente)));
                    break;
                case 3:
                    System.out.println("Densidade populacional do continente: " + formatarNumero(continenteService.calcularDensidadePopulacional(continente)) + " habitantes por km²");
                    break;
                case 4:
                    Pais paisMaiorPopulacao = continenteService.obterPaisMaiorPopulacao(continente);
                    System.out.println("País com maior população: " + paisMaiorPopulacao.getCodigoISO() + " - " + paisMaiorPopulacao.getNome());
                    System.out.println("População: " + formatarPopulacao(paisMaiorPopulacao.getPopulacao()));
                    break;
                case 5:
                    Pais paisMenorPopulacao = continenteService.obterPaisMenorPopulacao(continente);
                    System.out.println("País com menor população: " + paisMenorPopulacao.getCodigoISO() + " - " + paisMenorPopulacao.getNome());
                    System.out.println("População: " + formatarPopulacao(paisMenorPopulacao.getPopulacao()));
                    break;
                case 6:
                    Pais paisMaiorDimensao = continenteService.obterPaisMaiorDimensao(continente);
                    System.out.println("País com maior dimensão territorial: " + paisMaiorDimensao.getCodigoISO() + " - " + paisMaiorDimensao.getNome());
                    System.out.println("Dimensão: " + formatarArea(paisMaiorDimensao.getDimensao()));
                    break;
                case 7:
                    Pais paisMenorDimensao = continenteService.obterPaisMenorDimensao(continente);
                    System.out.println("País com menor dimensão territorial: " + paisMenorDimensao.getCodigoISO() + " - " + paisMenorDimensao.getNome());
                    System.out.println("Dimensão: " + formatarArea(paisMenorDimensao.getDimensao()));
                    break;
                case 8:
                    double razaoTerritorial = continenteService.obterRazaoTerritorial(continente);
                    System.out.println("Razão territorial entre maior e menor país: " + razaoTerritorial);
                    break;
                case 9:
                    mostrarQuantidadeEPaises();
                    break;
                case 10:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void adicionarPaisesAoContinente() {
        List<Pais> paises = PaisesData.obterPaisesDaAmericaDoSul();
        for (Pais pais : paises) {
            continente.adicionarPais(pais);
        }
    }

    private void mostrarQuantidadeEPaises() {
        List<Pais> paises = continente.getPaises();
        System.out.println("Quantidade total de países no continente: " + paises.size());

        System.out.println("\nListagem dos países:");
        for (Pais pais : paises) {
            System.out.println("País: " + pais.getCodigoISO() + " - " + pais.getNome());
            System.out.println("População: " + formatarPopulacao(pais.getPopulacao()));
            System.out.println("Dimensão: " + formatarArea(pais.getDimensao()) + " km²");
            System.out.println("Densidade populacional: " + formatarNumero(pais.getPopulacao() / pais.getDimensao()) + " habitantes por km²");
            System.out.println("-----------------------------------------------------");
        }
    }

    private String formatarNumero(double numero) {
        DecimalFormat formato = new DecimalFormat("#,###.##");
        return formato.format(numero);
    }

    private String formatarPopulacao(double populacao) {
        if (populacao >= 1_000_000) {
            double populacaoEmMilhoes = populacao / 1_000_000;
            DecimalFormat formato = new DecimalFormat("#,###.0");
            return formato.format(populacaoEmMilhoes) + " milhões";
        } else {
            DecimalFormat formato = new DecimalFormat("#,###");
            return formato.format(populacao);
        }
    }

    private String formatarArea(double area) {
        DecimalFormat formato = new DecimalFormat("#,###,###");
        return formato.format(area);
    }
}
