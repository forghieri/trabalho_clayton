package bichinho.core;

import java.util.Scanner;

public class AnimalFactory {
    private Scanner scanner;

    public AnimalFactory() {
        this.scanner = new Scanner(System.in);
    }

    public Animal criarAnimal() {
        System.out.println("Crie seu novo animal");
        System.out.print("Insira o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Insira a classe: ");
        String classe = scanner.nextLine();
        System.out.print("Insira a família: ");
        String familia = scanner.nextLine();

        Animal animal = new Animal(nome, classe, familia);
        System.out.println(animal);
        return animal;
    }
}
