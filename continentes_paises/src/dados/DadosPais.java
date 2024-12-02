package dados;

import models.Pais;
import models.Continente;
import java.util.Scanner;

public class DadosPais {

    public static Pais adicionarPais(Scanner scanner) {
        System.out.println("Digite o código ISO do país:");
        String codigoISO = scanner.nextLine();

        System.out.println("Digite o nome do país:");
        String nome = scanner.nextLine();

        System.out.println("Digite a população do país:");
        long populacao = Long.parseLong(scanner.nextLine());

        System.out.println("Digite a dimensão (em Km²) do país:");
        double dimensao = Double.parseDouble(scanner.nextLine());

        Pais pais = new Pais(codigoISO, nome, populacao, dimensao);
        return pais;
    }

    public static void adicionarPaisAoContinente(Pais pais, Continente continente) {
        continente.adicionarPais(pais);
    }
}
