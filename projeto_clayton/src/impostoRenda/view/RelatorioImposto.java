package impostoRenda.view;

import impostoRenda.model.Pessoa;
import impostoRenda.service.ImpostoCalculator;

public class RelatorioImposto {

    private ImpostoCalculator calculadora;

    public RelatorioImposto(ImpostoCalculator calculadora) {
        this.calculadora = calculadora;
    }

    public void gerarRelatorio(Pessoa pessoa) {
        double impostoSalario = calculadora.calcularImpostoSalario(pessoa);
        double impostoServicos = calculadora.calcularImpostoServicos(pessoa);
        double impostoCapital = calculadora.calcularImpostoCapital(pessoa);
        double impostoBruto = impostoSalario + impostoServicos + impostoCapital;
        double abatimento = calculadora.calcularAbatimento(pessoa, impostoBruto);
        double impostoDevido = impostoBruto - abatimento;

        System.out.println("\n### RELATÓRIO DE IMPOSTO DE RENDA ###");
        System.out.println("* CONSOLIDADO DE RENDA:");
        System.out.printf("Imposto sobre salário: R$ %.2f%n", impostoSalario);
        System.out.printf("Imposto sobre serviços: R$ %.2f%n", impostoServicos);
        System.out.printf("Imposto sobre ganho de capital: R$ %.2f%n", impostoCapital);

        System.out.println("\n* DEDUÇÕES:");
        System.out.printf("Máximo dedutível: R$ %.2f%n", impostoBruto * 0.30);
        System.out.printf("Gastos dedutíveis: R$ %.2f%n", pessoa.getGastosMedicos() + pessoa.getGastosEducacionais());

        System.out.println("\n* RESUMO:");
        System.out.printf("Imposto bruto total: R$ %.2f%n", impostoBruto);
        System.out.printf("Abatimento: R$ %.2f%n", abatimento);
        System.out.printf("Imposto devido: R$ %.2f%n", impostoDevido);
    }
}
