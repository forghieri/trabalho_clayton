package bichinho.core;

public class Animal {
    private String nome;
    private String classe;
    private String familia;
    private int idade;
    private boolean estadoVivo;
    private int caloria;
    private int forca;

    public Animal(String nome, String classe, String familia) {
        this.nome = nome;
        this.classe = classe;
        this.familia = familia;
        this.idade = 0;
        this.estadoVivo = true;
        this.caloria = 10;
        this.forca = 10;
    }

    public void comer() {
        if (!estadoVivo) {
            System.out.println("O animal está morto e não pode comer.");
            return;
        }
        if (caloria < 100) {
            caloria += 10;
            forca -= 2;
            System.out.println("O animal comeu! Agora sua força é " + forca + " e suas calorias valem " + caloria);
        } else {
            System.out.println("O animal está cheio e não pode comer mais.");
        }
    }

    public void correr() {
        if (!estadoVivo) {
            System.out.println("O animal está morto e não pode correr.");
            return;
        }
        if (caloria > 0) {
            caloria -= 5;
            forca -= 5;
            System.out.println("O animal está correndo! Agora sua força é " + forca + " e suas calorias valem " + caloria);
        } else {
            System.out.println("O animal está exausto e não pode correr.");
        }
    }

    public void dormir() {
        if (!estadoVivo) {
            System.out.println("O animal está morto e não pode dormir.");
            return;
        }
        forca += 10;
        caloria -= 2;
        System.out.println("O animal está dormindo! Sua força aumentou para " + forca + " e suas calorias diminuíram para " + caloria);
    }

    public void morrer() {
        forca = 0;
        estadoVivo = false;
        System.out.println("O animal morreu! GAME OVER!");
    }

    public boolean isVivo() {
        return estadoVivo;
    }

    @Override
    public String toString() {
        return "O animal se chama " + nome + " da classe " + classe + " da família " + familia + 
               ". Possui força " + forca + ", calorias " + caloria + " e idade " + idade + ".";
    }
}
