package functions;

import models.Retangulo;

import java.util.Scanner;

public class RetanguloMain {
    public static void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entre com a largura do retângulo: ");
        double width = scanner.nextDouble();

        System.out.print("Entre com a altura do retângulo: ");
        double height = scanner.nextDouble();

        Retangulo retangulo = new Retangulo(width, height);

        System.out.printf("AREA = %.2f%n", retangulo.calcularArea());
        System.out.printf("PERIMETRO = %.2f%n", retangulo.calcularPerimetro());
        System.out.printf("DIAGONAL = %.2f%n", retangulo.calcularDiagonal());
    }
}