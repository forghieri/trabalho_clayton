package bichinho.game;

import bichinho.core.Animal;
import bichinho.core.AnimalFactory;

public class Jogo {
    private Animal animal;
    private AnimalFactory animalFactory;
    private Menu menu;

    public Jogo() {
        animalFactory = new AnimalFactory();
        menu = new Menu();
    }

    public void iniciar() {
        animal = animalFactory.criarAnimal();
        while (animal.isVivo()) {
            int opcao = menu.exibirOpcoes();
            executarAcao(opcao);
        }
    }

    private void executarAcao(int opcao) {
        switch (opcao) {
            case 1:
                animal.comer();
                break;
            case 2:
                animal.correr();
                break;
            case 3:
                animal.dormir();
                break;
            case 4:
                animal.morrer();
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    public void encerrar() {
        System.out.println("Obrigado por jogar!");
    }
}
