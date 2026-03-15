package model;

public class Rey extends Pieza {
    public Rey(int fila, int columna, Color color, int puntos) {
        super(fila, columna, color, puntos);
    }

    /**
     * Comprueba si el Rey puede moverse a la casilla de destino.
     * El Rey puede moverse una casilla en cualquier dirección
     * @param nuevaFila La fila de destino.
     * @param nuevaColumna La columna de destino.
     * @param tablero El tablero actual.
     * @return true si el movimiento es de una sola casilla, false en caso contrario.
     */
    @Override
    public boolean puedeMover(int nuevaFila, int nuevaColumna, Tablero tablero) {
        int difFila = Math.abs(this.getFila() - nuevaFila);
        int difColumna = Math.abs(this.getColumna() - nuevaColumna);

        if (difFila == 0 && difColumna == 0) {
            return false;
        }
        return difFila <= 1 && difColumna <= 1;
    }

    @Override
    public int obtenerPuntosPieza() {
        return this.puntos;
    }

    @Override
    public Pieza copiarPieza() {
        return new Rey(this.getFila(), this.getColumna(), this.getColor(), this.puntos);
    }

    @Override
    protected char simbolo() {return this.getColor() == Color.BLANCA ? '♔' : '♚';}
}
