package bichinho.game;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public int exibirOpcoes() {
        System.out.println("\nO que o animal vai fazer agora?");
        System.out.println("1- Comer");
        System.out.println("2- Correr");
        System.out.println("3- Dormir");
        System.out.println("4- Morrer");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }
}
