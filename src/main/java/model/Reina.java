package model;

public class Reina extends Pieza {
    public Reina(int fila, int columna, Color color, int puntos) {
        super(fila, columna, color, puntos);
    }


    /**
     * Comprueba si la Reina puede moverse a una casilla.
     * La Reina se puede moverse en línea recta (horizontal, vertical o diagonal),
     * siempre y cuando no haya otras piezas bloqueando su trayectoria.
     * @param nuevaFila La fila del tablero a la que se quiere mover la Torre.
     * @param nuevaColumna La columna del tablero a la que se quiere mover la Torre.
     * @param tablero El tablero actual, necesario para comprobar si hay obstáculos en el camino.
     * @return true si el movimiento es legal para la Reina; false si es inválido o está bloqueado.
     */
    @Override
    public boolean puedeMover(int nuevaFila, int nuevaColumna, Tablero tablero) {
        if (this.getFila() == nuevaFila && this.getColumna() == nuevaColumna) {
            return false;
        }
        if (this.getFila() == nuevaFila || this.getColumna() == nuevaColumna) {
            return !tablero.hayPiezasEntre(this.getFila(), this.getColumna(), nuevaFila, nuevaColumna);
        }
        // Logica de movimiento diagonal se deberia de poder reusar para el alfil(borrar esta linea despues de revisar)
        if (Math.abs(nuevaFila - this.getFila()) == Math.abs(nuevaColumna - this.getColumna())) {
            return !tablero.hayPiezasEntre(this.getFila(), this.getColumna(), nuevaFila, nuevaColumna);
        }
            return false;
    }

    @Override
    public int obtenerPuntosPieza() {
        return this.puntos;
    }

    @Override
    public Pieza copiarPieza() {
        return new Reina(this.getFila(), this.getColumna(), this.getColor(), this.puntos);
    }

    @Override
    protected char simbolo() {return this.getColor() == Color.BLANCA ? '♕' : '♛';}
}




