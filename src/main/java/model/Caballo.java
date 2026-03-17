package model;

/**
 *
 * Clase que simula el funcionamiento de la pieza "Caballo" en el programa
 */
public class Caballo extends Pieza implements PiezaSaltadora{
    /**
     * Constuctor vacio para XML
     */
    public Caballo() {
    }
    public Caballo(int fila, int columna, Color color, int puntos) {
        super(fila, columna, color, puntos);
    }

    /**
     * Metodo que comprueba los posibles movimientos del caballo, si lo puede hacer devuelve true,
     * y si no false
     * @param nuevaFila
     * @param nuevaColumna
     * @param tablero
     * @return
     */
    @Override
    public boolean puedeMover(int nuevaFila, int nuevaColumna, Tablero tablero) {
        boolean movimientoValido=false;
        if (getFila() + 2== nuevaFila && getColumna() + 1== nuevaColumna) {
            movimientoValido=true;
        }
        else if (getFila() + 2 == nuevaFila && getColumna() - 1 == nuevaColumna) {
            movimientoValido=true;
        }
        else if (getFila() - 2 == nuevaFila && getColumna() + 1 == nuevaColumna) {
            movimientoValido=true;
        }
        else if (getFila() - 2 == nuevaFila && getColumna() - 1 == nuevaColumna) {
            movimientoValido=true;
        }
        else if (getFila() + 1 == nuevaFila && getColumna() + 2 == nuevaColumna) {
            movimientoValido=true;
        }
        else if (getFila() + 1 == nuevaFila && getColumna() - 2 == nuevaColumna) {
            movimientoValido=true;
        }
        else if (getFila() - 1 == nuevaFila && getColumna() + 2 == nuevaColumna) {
            movimientoValido=true;
        }
        else if (getFila() - 1 == nuevaFila && getColumna() - 2 == nuevaColumna) {
            movimientoValido=true;
        }

        return movimientoValido;
    }
    /**
     * Método con el cual representamos el peon en el tablero mediante su respectiva figura de UFT-8, basándonos en el color asignado.
     * @return (El símbolo del caballo blanco o negro, dependiendo del color que tenga)
     */
    @Override
    protected char simbolo() {
        return getColor() == Color.BLANCA ? '♘' : '♞';
    }
    /**
     * Método que devuelve los puntos que vale un Caballo
     * @return (Los puntos asignados al Caballo)
     */
    @Override
    public int obtenerPuntosPieza() {
        return this.puntos;
    }
    /**
     * Crea y devuelve una copia exacta de este Caballo.
     * @return Una nueva instancia del caballo con la misma posición, color y puntuación que la original.
     */
    @Override
    public Pieza copiarPieza() {
        return new Caballo(this.getFila(),this.getColumna(),this.getColor(),this.puntos);
    }

}