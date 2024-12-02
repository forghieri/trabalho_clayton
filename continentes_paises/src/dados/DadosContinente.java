package dados;

import models.Continente;
import java.util.Scanner;

public class DadosContinente {

    public static Continente adicionarContinente(Scanner scanner) {
        System.out.println("Digite o nome do continente:");
        String nomeContinente = scanner.nextLine();

        Continente continente = new Continente(nomeContinente);
        return continente;
    }
}
