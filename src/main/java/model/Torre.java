package model;

public class Torre extends Pieza {
    public Torre(int fila, int columna, Color color, int puntos) {
        super(fila, columna, color, puntos);
    }


    /**
     * Comprueba si la Torre puede moverse a una casilla.
     * La Torre solo puede moverse en línea recta (horizontal o verticalmente),
     * siempre y cuando no haya otras piezas bloqueando su trayectoria.
     * @param nuevaFila La fila del tablero a la que se quiere mover la Torre.
     * @param nuevaColumna La columna del tablero a la que se quiere mover la Torre.
     * @param tablero El tablero actual, necesario para comprobar si hay obstáculos en el camino.
     * @return true si el movimiento es legal para la Torre; false si es inválido o está bloqueado.
     */
    @Override
    public boolean puedeMover(int nuevaFila, int nuevaColumna, Tablero tablero) {
        if (this.getFila() == nuevaFila && this.getColumna() == nuevaColumna) {
            return false;
        }
        if (this.getFila() != nuevaFila && this.getColumna() != nuevaColumna) {
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

    /**
     * Crea y devuelve una copia exacta de esta Torre.
     * @return Una nueva instancia de Torre con la misma posición, color y puntuación que la original.
     */
    @Override
    public Pieza copiarPieza() {
        return new Torre(this.getFila(), this.getColumna(), this.getColor(), this.puntos);
    }

    @Override
    protected char simbolo() {return getColor() == Color.BLANCA ? '♖' : '♜';}
}


