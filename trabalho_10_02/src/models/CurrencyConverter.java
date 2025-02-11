package models;

public class CurrencyConverter {
    private static final double IOF = 0.06;

    public static double converterDolarParaReal(double cotacaoDolar, double valorDolar) {
        return valorDolar * cotacaoDolar * (1 + IOF);
    }
}