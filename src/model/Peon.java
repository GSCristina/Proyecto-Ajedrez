package model;

public class Peon extends Pieza {
    public Peon(int fila, int columna, Color color) {
        super(fila, columna, color);
    }

    @Override
    public boolean puedeMover(int nuevaFila, int nuevaColumna, Tablero tablero) {

        if(fila<0 || fila >7 || columna < 0 || columna >7){
            return false;
        }

        int direccion;  //Dirección en la que se puede mover el peón.
        int filaInicial;    //Fila en la que empieza el peón.

        /**
         * Determina la dirección en las que se mueven y la fila inicial de los peones basandose en el color.
         */

        if(getColor() == Color.BLANCA){
            direccion = -1;
            filaInicial = 6;
        }else{
            direccion = 1;
            filaInicial = 1;
        }
        int diferenciaFila = nuevaFila - getFila();
        int diferenciaColumna = nuevaColumna - getColumna();
        Pieza destino = tablero.obtenerPieza(nuevaFila,nuevaColumna);

        if(diferenciaColumna == 0){
            /**
             * Avance de una casilla
             */
            if(diferenciaFila == direccion && destino == null){
                return true;
            }

            /**
             * Avance de dos casillas(Solo en posición original)
             */
            if (getFila() == filaInicial &&
                    diferenciaFila == 2 * direccion &&
                    destino == null &&
                    tablero.obtenerPieza(getFila() + direccion, getColumna()) == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int obtenerPuntosPieza() {
        return 1;
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
    public String toString() {
        return this.getColor() == Color.BLANCA ? "♙" : "♟";
    }
}
