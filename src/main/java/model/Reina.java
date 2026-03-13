package model;

public class Reina extends Pieza {
    public static final int PUNTOS=9;

    public Reina(int fila, int columna, Color color, int puntos) {
        super(fila, columna, color);
    }

    @Override
    public boolean puedeMover(int nuevaFila, int nuevaColumna, Tablero tablero) {
        return false;
    }

    @Override
    public int obtenerPuntosPieza() {
        return PUNTOS;
    }

    @Override
    public Pieza copiarPieza() {
        return null;
    }

    @Override
    protected char simbolo() {return this.getColor() == Color.BLANCA ? '♕' : '♛';}

}
