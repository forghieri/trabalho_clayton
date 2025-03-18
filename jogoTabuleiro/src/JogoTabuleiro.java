import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Classe Dado
class Dado {
    private Integer numeroAtual;
    private Random random;

    public Dado() {
        this.random = new Random();
    }

    public Integer rolar() {
        numeroAtual = random.nextInt(6) + 1; // Gera número entre 1 e 6
        return numeroAtual;
    }
}

// Classe Jogador
class Jogador {
    private Integer casaAtual;
    private Integer meuNumero;

    public Jogador(int numero) {
        this.casaAtual = 0;
        this.meuNumero = numero;
    }

    public Integer jogar(Dado dado, int casasMaximas) {
        int movimento = dado.rolar();
        int novaPosicao = casaAtual + movimento;

        // Verifica se a nova posição ultrapassa o máximo
        if (novaPosicao > casasMaximas) {
            System.out.println("Jogador " + meuNumero + " rolou " + movimento +
                    ", mas não pode avançar (ultrapassaria a casa " + casasMaximas + ")");
            return casaAtual;
        } else {
            casaAtual = novaPosicao;
            return casaAtual;
        }
    }

    public Integer getCasaAtual() {
        return casaAtual;
    }

    public Integer getMeuNumero() {
        return meuNumero;
    }
}

// Classe Tabuleiro
class Tabuleiro {
    private Integer numeroCasas;

    public Tabuleiro(int numeroCasas) {
        this.numeroCasas = numeroCasas;
    }

    public Integer getNumeroCasas() {
        return numeroCasas;
    }
}

// Classe Jogo
class Jogo {
    private Tabuleiro meuTabuleiro;
    private ArrayList<Jogador> meusJogadores;
    private Dado meuDado;
    private int jogadorAtual;

    public Jogo() {
        meuTabuleiro = new Tabuleiro(50); // Tabuleiro com 100 casas
        meusJogadores = new ArrayList<>();
        meuDado = new Dado();
        jogadorAtual = 0;

        // Cria 2 jogadores por padrão
        meusJogadores.add(new Jogador(1));
        meusJogadores.add(new Jogador(2));
    }

    public void proximaJogada() {
        Jogador jogador = meusJogadores.get(jogadorAtual);
        int casasMaximas = meuTabuleiro.getNumeroCasas();
        int novaPosicao = jogador.jogar(meuDado, casasMaximas);

        if (novaPosicao == casasMaximas) {
            System.out.println("Jogador " + jogador.getMeuNumero() + " venceu ao chegar exatamente na casa " + casasMaximas + "!");
        } else {
            System.out.println("Jogador " + jogador.getMeuNumero() +
                    " avançou para a casa " + novaPosicao);
        }

        jogadorAtual = (jogadorAtual + 1) % meusJogadores.size();
    }

    public void informarPosicoes() {
        for (Jogador j : meusJogadores) {
            System.out.println("Jogador " + j.getMeuNumero() +
                    " está na casa " + j.getCasaAtual());
        }
    }

    public void reiniciar() {
        meusJogadores.clear();
        meusJogadores.add(new Jogador(1));
        meusJogadores.add(new Jogador(2));
        jogadorAtual = 0;
    }
}

public class JogoTabuleiro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jogo jogo = null;

        while (true) {
            System.out.println("\nMENU");
            System.out.println("1 - Iniciar nova partida");
            System.out.println("2 - Executar jogada");
            System.out.println("3 - Informar posições");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    jogo = new Jogo();
                    System.out.println("Nova partida iniciada!");
                    break;
                case 2:
                    if (jogo == null) {
                        System.out.println("Inicie uma nova partida primeiro!");
                    } else {
                        jogo.proximaJogada();
                    }
                    break;
                case 3:
                    if (jogo == null) {
                        System.out.println("Inicie uma nova partida primeiro!");
                    } else {
                        jogo.informarPosicoes();
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}