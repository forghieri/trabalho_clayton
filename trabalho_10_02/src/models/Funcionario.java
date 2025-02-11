package models;

public class Funcionario {
    private final String name;
    private double grossSalary;
    private final double tax;

    public Funcionario(String name, double grossSalary, double tax) {
        this.name = name;
        this.grossSalary = grossSalary;
        this.tax = tax;
    }

    public double calcularSalarioLiquido() {
        return grossSalary - tax;
    }

    public void aumentarSalario(double percentage) {
        grossSalary += grossSalary * (percentage / 100);
    }

    @Override
    public String toString() {
        return String.format("%s, $ %.2f", name, calcularSalarioLiquido());
    }
}