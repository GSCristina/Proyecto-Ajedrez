package model;

public class Reina extends Pieza {
    public Reina(int fila, int columna, Color color) {
        super(fila, columna, color);
    }

    @Override
    public boolean puedeMover(int nuevaFila, int nuevaColumna, Tablero tablero) {
        return false;
    }

    @Override
    public int obtenerPuntosPieza() {
        return 9;
    }

    @Override
    public Pieza copiarPieza() {
        return null;
    }


    @Override
    public String toString() {
        return this.getColor() == Color.BLANCA ? "♕" : "♛";
    }
}
