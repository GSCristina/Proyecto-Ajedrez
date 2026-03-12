package model;

public class Caballo extends Pieza implements PiezaSaltadora{
    public Caballo(int fila, int columna, Color color, int puntos) {
        super(fila, columna, color, puntos);
    }

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
    public int obtenerPuntosPieza() {
        return this.puntos;
    }

    @Override
    public Pieza copiarPieza() {
        return null;
    }

    @Override
    protected char simbolo() {return this.getColor() == Color.BLANCA ? '♘' : '♞';}
        return new Caballo(this.getFila(),this.getColumna(),this.getColor());
    }


    @Override
    public void Saltar() {
    }
}
