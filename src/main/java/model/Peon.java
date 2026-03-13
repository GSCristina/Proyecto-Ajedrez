package model;

public class Peon extends Pieza {
    public static final int PUNTOS=1;

    public Peon(int fila, int columna, Color color, int puntos) {
        super(fila, columna, color);
    }

    @Override
    public boolean puedeMover(int nuevaFila, int nuevaColumna, Tablero tablero) {
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
    public boolean puedeAtacar(Pieza piezaEnemiga, Tablero tablero){

        if(piezaEnemiga == null) return false;
        if(getColor() == piezaEnemiga.getColor()) return false;

        int direccion = (getColor() == Color.BLANCA) ? -1 : 1;

        int diferenciaFila = piezaEnemiga.getFila() - getFila();
        int diferenciaColumna = piezaEnemiga.getColumna() - getColumna();

        return diferenciaFila == direccion && Math.abs(diferenciaColumna) == 1;
    }

    @Override
    public int obtenerPuntosPieza() {
        return this.PUNTOS;
    }

    @Override
    public Pieza copiarPieza() {
        return null;
    }
    @Override
    protected char simbolo() {
        return getColor() == Color.BLANCA ? '♗' : '♝';
    }
}

