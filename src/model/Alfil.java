package model;

public class Alfil extends Pieza {
    public Alfil(int fila, int columna, Color color, int puntos) {
        super(fila, columna, color, puntos);
    }

    @Override
    public boolean puedeMover(int nuevaFila, int nuevaColumna, Tablero tablero) {
        return false;
    }

    @Override
    public int obtenerPuntosPieza() {
        return this.puntos;
    }

    @Override
    public Pieza copiarPieza() {
        return null;
    }

    @Override
    protected char simbolo() {return this.getColor() == Color.BLANCA ? '♗' : '♝';}
}
