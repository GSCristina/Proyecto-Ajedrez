package model;

import model.Color;
import model.Pieza;
import model.Tablero;
import model.Pieza;

public class Peon extends Pieza {
    /**
     * Constructor vacio para el XML
     */
    public Peon() {
    }

    public Peon(int fila, int columna, Color color, int puntos) {
        super(fila, columna, color, puntos);
    }


    /**
     * Método que comprueba que el movimiento del peon es legal y posible dadas las circunstancias
     * @param nuevaFila (Fila destino)
     * @param nuevaColumna (Columna destino)
     * @param tablero (Tablero actual en el que se basa la jugada)
     * @return (True si es posible moverse o false si es imposible)
     */
    @Override
    public boolean puedeMover(int nuevaFila, int nuevaColumna, Tablero tablero) {
        int direccion;
        int filaInicial;

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

        // Movimiento hacia delante
        if(diferenciaColumna == 0){

            // Avance de una casilla
            if(diferenciaFila == direccion && destino == null){
                return true;
            }

            // Avance de dos casillas desde posición inicial
            if (getFila() == filaInicial &&
                    diferenciaFila == 2 * direccion &&
                    destino == null &&
                    tablero.obtenerPieza(getFila() + direccion, getColumna()) == null) {
                return true;
            }
        }

        // Ataque diagonal
        if (Math.abs(diferenciaColumna) == 1 &&
                diferenciaFila == direccion &&
                destino != null &&
                destino.getColor() != getColor()) {
            return true;
        }

        return false;
    }

    /**
     * Método que comprueba que el peon pueda atacar.
     * @param piezaEnemiga (Pieza enemiga a la que comprobamos si puede atacar)
     * @param tablero (Tablero actual en la que se basa la jugada)
     * @return (True si puede realizar el ataque a la piezaEnemiga o false si no es posible)
     */

    @Override
    public boolean puedeAtacar(Pieza piezaEnemiga, Tablero tablero){

        if(piezaEnemiga == null) return false;
        if(getColor() == piezaEnemiga.getColor()) return false;

        int direccion = (getColor() == Color.BLANCA) ? -1 : 1;

        int diferenciaFila = piezaEnemiga.getFila() - getFila();
        int diferenciaColumna = piezaEnemiga.getColumna() - getColumna();

        return diferenciaFila == direccion && Math.abs(diferenciaColumna) == 1;
    }

    /**
     * Método que devuelve los puntos que vale un peon
     * @return (Los puntos asignados al peon)
     */
    @Override
    public int obtenerPuntosPieza() {
        return this.puntos;
    }

    /**
     * Método que permite copiar el estado de la pieza en el tablero, posicion, color y puntos
     * @return (Devuelve un nuevo Peon que representa el peon en el momento que se copia)
     */
    @Override
    public Pieza copiarPieza() {return  new Peon(this.getFila(), this.getColumna(), this.getColor(), this.puntos);}

    /**
     * Método con el cual representamos el peon en el tablero mediante su respectiva figura de UFT-8, basándonos en el color asignado.
     * @return (El símbolo de peon blanco o negro, dependiendo del color que tenga)
     */
    @Override
    protected char simbolo() {
        return this.getColor() == Color.BLANCA ? '♙' : '♟';
    }
}