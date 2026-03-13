package model;

public class Alfil extends Pieza {

    public Alfil(int fila, int columna, Color color, int puntos) {
        super(fila, columna, color, puntos);
    }

    /**
     * Comprueba si el Alfil puede moverse a la casilla de destino.
     * La diferencia de filas debe ser igual a la diferencia de columnas.
     * @param nuevaFila La fila de destino.
     * @param nuevaColumna La columna de destino.
     * @param tablero El tablero actual para comprobar obstáculos.
     * @return true si el movimiento es diagonal y el camino está libre, false en caso contrario.
     */
    @Override
    public boolean puedeMover(int nuevaFila, int nuevaColumna, Tablero tablero) {
        int difFila = Math.abs(this.getFila() - nuevaFila);
        int difColumna = Math.abs(this.getColumna() - nuevaColumna);

        if (difFila == 0 || difFila != difColumna) {
            return false;
        }
        if (tablero.hayPiezasEntre(this.getFila(), this.getColumna(), nuevaFila, nuevaColumna)) {
            return false;
        }
        return true;
    }

    @Override
    public int obtenerPuntosPieza() {
        return this.puntos;
    }

    @Override
    public Pieza copiarPieza() {
        return new Alfil(this.getFila(), this.getColumna(), this.getColor(), this.puntos);
    }

    @Override
    protected char simbolo() {return this.getColor() == Color.BLANCA ? '♗' : '♝';}
}
