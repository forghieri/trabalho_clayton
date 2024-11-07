package bar.service;

import bar.models.Cliente;

public class ContaCalculator {

    private static final double PRECO_CERVEJA = 5.0;
    private static final double PRECO_REFRIGERANTE = 3.0;
    private static final double PRECO_ESPETINHO = 7.0;
    private static final double INGRESSO_MULHER = 8.0;
    private static final double INGRESSO_HOMEM = 10.0;
    private static final double COUVERT = 4.0;

    public double calcularConsumo(Cliente cliente) {
        double consumo = (cliente.getQuantidadeCervejas() * PRECO_CERVEJA) +
                (cliente.getQuantidadeRefrigerantes() * PRECO_REFRIGERANTE) +
                (cliente.getQuantidadeEspetinhos() * PRECO_ESPETINHO);
        return consumo;
    }

    public double calcularIngresso(Cliente cliente) {
        return cliente.getSexo() == 'F' || cliente.getSexo() == 'f' ? INGRESSO_MULHER : INGRESSO_HOMEM;
    }

    public double calcularCouvert(double consumo) {
        return consumo > 30 ? 0.0 : COUVERT;
    }

    public double calcularValorTotal(Cliente cliente) {
        double consumo = calcularConsumo(cliente);
        double ingresso = calcularIngresso(cliente);
        double couvert = calcularCouvert(consumo);
        return consumo + ingresso + couvert;
    }
}
