package bichinho.app;

import bichinho.game.Jogo;

public class BichinhoVirtualApp {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.iniciar();
        jogo.encerrar();
    }
}
