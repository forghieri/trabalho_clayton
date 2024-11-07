package bar.view;

import bar.models.Cliente;
import bar.service.ContaCalculator;

public class RelatorioConta {

    private ContaCalculator contaCalculator;

    public RelatorioConta(ContaCalculator contaCalculator) {
        this.contaCalculator = contaCalculator;
    }

    public void gerarRelatorio(Cliente cliente) {
        double consumo = contaCalculator.calcularConsumo(cliente);
        double ingresso = contaCalculator.calcularIngresso(cliente);
        double couvert = contaCalculator.calcularCouvert(consumo);
        double valorTotal = contaCalculator.calcularValorTotal(cliente);

        // Relatório
        System.out.println("\nRELATÓRIO:");
        System.out.printf("Consumo = R$ %.2f%n", consumo);
        if (couvert == 0.0) {
            System.out.println("Isento de Couvert");
        } else {
            System.out.printf("Couvert = R$ %.2f%n", couvert);
        }
        System.out.printf("Ingresso = R$ %.2f%n", ingresso);
        System.out.printf("\nValor a pagar = R$ %.2f%n", valorTotal);
    }
}
