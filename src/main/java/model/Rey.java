package model;

/**
 *
 * Clase que simula el funcionamiento de la pieza "Rey" en el programa
 */
public class Rey extends Pieza {
    /**
     * Constructor vacio para el XML
     */
    public Rey() {
    }
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
    /**
     * Método que devuelve los puntos que vale un Rey
     * @return (Los puntos asignados al Rey)
     */
    @Override
    public int obtenerPuntosPieza() {
        return this.puntos;
    }
    /**
     * Crea y devuelve una copia exacta de este Rey.
     * @return Una nueva instancia del Rey con la misma posición, color y puntuación que la original.
     */
    @Override
    public Pieza copiarPieza() {
        return new Rey(this.getFila(), this.getColumna(), this.getColor(), this.puntos);
    }
    /**
     * Método con el cual representamos el peon en el tablero mediante su respectiva figura de UFT-8, basándonos en el color asignado.
     * @return (El símbolo del rey blanco o negro, dependiendo del color que tenga)
     */
    @Override
    protected char simbolo() {return this.getColor() == Color.BLANCA ? '♔' : '♚';}
}
