package model;

public class Alfil extends Pieza {
    public Alfil(int fila, int columna, Color color, int valor, char caracter) {
        super(fila, columna, color, valor, caracter);
    }

    @Override
    public String toString() {
        return this.getColor() == Color.BLANCA ? "♗" : "♝";
    }
}
