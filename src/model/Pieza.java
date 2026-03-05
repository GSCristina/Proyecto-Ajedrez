package model;

import java.util.Objects;
import java.io.Serializable;

public abstract class Pieza implements Serializable {
    protected int fila;
    protected int columna;
    protected final Color color;

    /**
     * Constructor que lanza excepción si se sobrepasa de las filas y columnas límites,
     * además de comprobar que tenga asignado un color, lanzando excepción en caso negativo.
     */
    public Pieza(int fila, int columna, Color color) {

        if (comprobarCasillaValida(fila, columna)) {
            throw new IllegalArgumentException("La posición debe estar entre 0 y 7");
        }

        if (color == null) {
            throw new IllegalArgumentException("El color no puede ser null");
        }

        this.fila = fila;
        this.columna = columna;
        this.color = color;
    }

    private static boolean comprobarCasillaValida(int fila, int columna) {
        return fila < 0 || fila > 7 || columna < 0 || columna > 7;
    }

    public int getFila() {
        return fila;
    }

    /**
     * Setter que comprueba que la fila este comprendida entre 0 y 7, en el caso de que no,
     * lanza una excepción.
     *
     * @param fila
     */
    public void setFila(int fila) {
        if (fila < 0 || fila > 7) {
            throw new IllegalArgumentException("La fila debe estar entre 0 y 7");
        }
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }


    /**
     * Setter que comprueba que la colimna este comprendida entre 0 y 7, en el caso
     * de que no, lanza una exepción.
     *
     * @param columna
     */
    public void setColumna(int columna) {
        if (columna < 0 || columna > 7) {
            throw new IllegalArgumentException("La columna debe estar entre 0 y 7");
        }
        this.columna = columna;
    }

    public Color getColor() {
        return color;
    }


    /**
     * Comprueba si la pieza puede moverse a una nueva posición del tablero.
     *
     * @param nuevaFila
     * @param tablero
     * @param nuevaColumna
     */
    public abstract boolean puedeMover(int nuevaFila, int nuevaColumna, Tablero tablero);


    /**
     * Comprueba si la pieza puede atacar a otra.
     * No permite atacar a piezas del mismo color.
     *
     * @param piezaEnemiga
     * @param tablero
     */
    public boolean puedeAtacar(Pieza piezaEnemiga, Tablero tablero) {
        if (piezaEnemiga == null) return false;
        if (this.color == piezaEnemiga.color) return false;
        return puedeMover(piezaEnemiga.getFila(), piezaEnemiga.getColumna(), tablero);
    }


    /**
     * Mueve la pieza a una nueva posición.
     * Lanza IllegalArgumentException si el movimiento no está permitido.
     *
     * @param nuevaColumna
     * @param nuevaFila
     * @param tablero
     */
    public void mover(int nuevaFila, int nuevaColumna, Tablero tablero) {
        if (nuevaFila < 0 || nuevaFila > 7 || nuevaColumna < 0 || nuevaColumna > 7) {
            throw new IllegalArgumentException("No se puede mover la pieza fuera del tablero");
        }
        if (!puedeMover(nuevaFila, nuevaColumna, tablero)) {
            throw new IllegalArgumentException("Esta pieza no permite este movimiento");
        }
        Pieza piezaDestino = tablero.obtenerPieza(nuevaFila, nuevaColumna);
        if (piezaDestino != null) {
            if (piezaDestino instanceof Rey) {
                throw new IllegalArgumentException("No se puede atacar al rey");
            }
            if (piezaDestino.getColor() == this.color) {
                throw new IllegalArgumentException("No puedes atacar una pieza de tu mismo color");
            }
        }

        int filaActual = this.fila;
        int columnaActual = this.columna;



        /*tablero.colocarPieza(null, filaActual, columnaActual);

        this.fila=nuevaFila;
        this.columna=nuevaColumna;

        tablero.colocarPieza(this, nuevaFila, nuevaColumna);
    }*/


        /**
         * Devuelve los puntos que vale la pieza.
         */
//    public abstract int obtenerPuntosPieza();


        /**
         * Devuelve una copia de la pieza.
         */
        //   public abstract Pieza copiarPieza();


        /**
         * Devuelve el símbolo UTF-8 que representa la pieza.
         */
        //  protected abstract char simbolo();

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pieza pieza = (Pieza) o;
        return fila == pieza.fila && columna == pieza.columna && color == pieza.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna, color);
    }

    public abstract int obtenerPuntosPieza();

    public abstract Pieza copiarPieza();

    protected abstract char simbolo();

    @Override
    public String toString() {
        return "Pieza{" +
                "fila=" + fila +
                ", columna=" + columna +
                ", color=" + color +
                '}';
    }
}
