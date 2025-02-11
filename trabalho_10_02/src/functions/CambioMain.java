package functions;

import models.CurrencyConverter;

import java.util.Scanner;

public class CambioMain {
    public static void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Qual o valor do dólar? ");
        String inputDolar = scanner.nextLine().replace(",", "."); // Substitui vírgula por ponto
        double cotacaoDolar = Double.parseDouble(inputDolar); // Converte a string para double

        System.out.print("Quantos dólares serão comprados? ");
        String inputQuantidade = scanner.nextLine().replace(",", "."); // Substitui vírgula por ponto
        double valorDolar = Double.parseDouble(inputQuantidade); // Converte a string para double

        double valorReais = CurrencyConverter.converterDolarParaReal(cotacaoDolar, valorDolar);

        System.out.printf("Valor a ser pago em reais = %.2f%n", valorReais);
    }
}