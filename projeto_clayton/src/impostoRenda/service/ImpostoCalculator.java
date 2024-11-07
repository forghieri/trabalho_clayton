package impostoRenda.service;

import impostoRenda.model.Pessoa;

public class ImpostoCalculator {

    public double calcularImpostoSalario(Pessoa pessoa) {
        double salarioMensal = pessoa.getRendaAnualSalario() / 12;
        if (salarioMensal < 3000) {
            return 0.0;  // Isento
        } else if (salarioMensal < 5000) {
            return pessoa.getRendaAnualSalario() * 0.10;  // 10% de imposto
        } else {
            return pessoa.getRendaAnualSalario() * 0.20;  // 20% de imposto
        }
    }

    public double calcularImpostoServicos(Pessoa pessoa) {
        return pessoa.getRendaServicos() * 0.15;  // 15% sobre prestação de serviços
    }

    public double calcularImpostoCapital(Pessoa pessoa) {
        return pessoa.getRendaCapital() * 0.20;  // 20% sobre ganho de capital
    }

    public double calcularAbatimento(Pessoa pessoa, double impostoBruto) {
        double abatimentoMaximo = impostoBruto * 0.30;
        double gastosDedutiveis = pessoa.getGastosMedicos() + pessoa.getGastosEducacionais();
        return Math.min(abatimentoMaximo, gastosDedutiveis);
    }
}
