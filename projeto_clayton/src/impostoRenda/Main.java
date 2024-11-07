package impostoRenda;

import impostoRenda.model.Pessoa;
import impostoRenda.service.ImpostoCalculator;
import impostoRenda.view.RelatorioImposto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        System.out.print("Digite a renda anual com salário: ");
        double rendaAnualSalario = scanner.nextDouble();

        System.out.print("Digite a renda anual com prestação de serviços: ");
        double rendaServicos = scanner.nextDouble();

        System.out.print("Digite a renda anual com ganho de capital: ");
        double rendaCapital = scanner.nextDouble();

        System.out.print("Digite os gastos médicos anuais: ");
        double gastosMedicos = scanner.nextDouble();

        System.out.print("Digite os gastos educacionais anuais: ");
        double gastosEducacionais = scanner.nextDouble();

        // Criando objeto Pessoa
        Pessoa pessoa = new Pessoa(rendaAnualSalario, rendaServicos, rendaCapital, gastosMedicos, gastosEducacionais);

        // Calculadora de imposto
        ImpostoCalculator calculadora = new ImpostoCalculator();

        // Gerar relatório
        RelatorioImposto relatorio = new RelatorioImposto(calculadora);
        relatorio.gerarRelatorio(pessoa);
    }
}
