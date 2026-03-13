package model;

public class Caballo extends Pieza implements PiezaSaltadora{

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
    @Override
    protected char simbolo() {
        return getColor() == Color.BLANCA ? '♘' : '♞';
    }

    @Override
    public int obtenerPuntosPieza() {
        return this.puntos;
    }

    @Override
    public Pieza copiarPieza() {
        return new Caballo(this.getFila(),this.getColumna(),this.getColor(),this.puntos);
    }

}