package models;

public class Aluno {
    private final String name;
    private final double nota1;
    private final double nota2;
    private final double nota3;

    public Aluno(String name, double nota1, double nota2, double nota3) {
        this.name = name;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public double calcularNotaFinal() {
        return nota1 + nota2 + nota3;
    }

    public String verificarAprovacao() {
        double notaFinal = calcularNotaFinal();
        if (notaFinal >= 60) {
            return "PASS";
        } else {
            double pontosFaltantes = 60 - notaFinal;
            return String.format("FAILED%nFALTARAM %.2f PONTOS", pontosFaltantes);
        }
    }
}