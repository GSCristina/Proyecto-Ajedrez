package model;

public class Caballo extends Pieza implements PiezaSaltadora{
    public Caballo(int fila, int columna, Color color) {
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
    public void Saltar() {

    }

    @Override
    public String toString() {
        return this.getColor() == Color.BLANCA ? "♘" : "♞";
    }
}
