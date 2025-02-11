package models;

public class Retangulo {
    private final double width;
    private final double height;

    public Retangulo(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calcularArea() {
        return width * height;
    }

    public double calcularPerimetro() {
        return 2 * (width + height);
    }

    public double calcularDiagonal() {
        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }
}