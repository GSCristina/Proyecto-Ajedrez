package model;

/**
 *
 * Clase que simula el funcionamiento de la pieza "Alfil" en el programa
 */
public class Alfil extends Pieza {
    /**
     * Constructor vacio para Xml
     */
    public Alfil() {
    }
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
    /**
     * Método que devuelve los puntos que vale un Alfil
     * @return (Los puntos asignados al Alfil)
     */
    @Override
    public int obtenerPuntosPieza() {
        return this.puntos;
    }
    /**
     * Crea y devuelve una copia exacta de este Alfil.
     * @return Una nueva instancia de Alfil con la misma posición, color y puntuación que la original.
     */
    @Override
    public Pieza copiarPieza() {
        return new Alfil(this.getFila(), this.getColumna(), this.getColor(), this.puntos);
    }
    /**
     * Método con el cual representamos el peon en el tablero mediante su respectiva figura de UFT-8, basándonos en el color asignado.
     * @return (El símbolo del alfil blanco o negro, dependiendo del color que tenga)
     */
    @Override
    protected char simbolo() {return this.getColor() == Color.BLANCA ? '♗' : '♝';}
}
