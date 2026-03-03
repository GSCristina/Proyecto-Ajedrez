package model;

public class Reina extends Pieza {
    public Reina(int fila, int columna, Color color, int valor, char caracter) {
        super(fila, columna, color, valor, caracter);
    }

    @Override
    public String toString() {
        return this.getColor() == Color.BLANCA ? "♕" : "♛";
    }
}
