package impostoRenda.model;

public class Pessoa {
    private double rendaAnualSalario;
    private double rendaServicos;
    private double rendaCapital;
    private double gastosMedicos;
    private double gastosEducacionais;

    // Construtor
    public Pessoa(double rendaAnualSalario, double rendaServicos, double rendaCapital, double gastosMedicos, double gastosEducacionais) {
        this.rendaAnualSalario = rendaAnualSalario;
        this.rendaServicos = rendaServicos;
        this.rendaCapital = rendaCapital;
        this.gastosMedicos = gastosMedicos;
        this.gastosEducacionais = gastosEducacionais;
    }

    // Getters
    public double getRendaAnualSalario() {
        return rendaAnualSalario;
    }

    public double getRendaServicos() {
        return rendaServicos;
    }

    public double getRendaCapital() {
        return rendaCapital;
    }

    public double getGastosMedicos() {
        return gastosMedicos;
    }

    public double getGastosEducacionais() {
        return gastosEducacionais;
    }
}
