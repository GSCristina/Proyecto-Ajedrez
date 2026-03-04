package model;

public class Alfil extends Pieza {
    public Alfil(int fila, int columna, Color color) {
        super(fila, columna, color);
    }

    @Override
    public boolean puedeMover(int nuevaFila, int nuevaColumna, Tablero tablero) {
        return false;
    }

    @Override
    public int obtenerPuntosPieza() {
        return 3;
    }

    @Override
    public Pieza copiarPieza() {
        return null;
    }

    @Override
    protected char simbolo() {
        return 0;
    }

    @Override
    public String toString() {
        return this.getColor() == Color.BLANCA ? "♗" : "♝";
    }
}
