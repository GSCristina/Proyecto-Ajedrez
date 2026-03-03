package model;

import java.util.Objects;

public abstract class Pieza {
    private int fila;
    private int columna;
    private Color color;
    private int valor;
    private char caracter;

    public Pieza(int fila, int columna, Color color, int valor, char caracter) {
        this.fila = fila;
        this.columna = columna;
        this.color = color;
        this.valor = valor;
        this.caracter = caracter;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }


    /**
     * Comprueba si la pieza puede moverse a una nueva posición del tablero.
     * @param nuevaFila
     * @param tablero
     * @param nuevaColumna
     */
    public abstract boolean puedeMover(int nuevaFila, int nuevaColumna,Tablero tablero);


    /**
     * Comprueba si la pieza puede atacar a otra.
     * No permite atacar a piezas del mismo color.
     * @param piezaEnemiga
     * @param tablero
     */
    public boolean puedeAtacar(Pieza piezaEnemiga, Tablero tablero){
        if (piezaEnemiga==null) return false;
        if (this.color==piezaEnemiga.color) return false;
        return puedeMover(piezaEnemiga.getFila(), piezaEnemiga.getColumna(), piezaEnemiga.getTablero());
    }


    /**
     * Mueve la pieza a una nueva posición.
     * Lanza IllegalArgumentException si el movimiento no está permitido.
     * @param nuevaColumna
     * @param nuevaFila
     * @param tablero
     */
    public void mover(int nuevaFila, int nuevaColumna, Tablero tablero) {
    }


    /**
     * Devuelve los puntos que vale la pieza.
     */
    public abstract int obtenerPuntosPieza();



    /**
     * Devuelve una copia de la pieza.
     */
    public abstract Pieza copiarPieza();



    /**
     * Devuelve el símbolo UTF-8 que representa la pieza.
     */
    protected abstract char simbolo();


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pieza pieza = (Pieza) o;
        return fila == pieza.fila && columna == pieza.columna && valor == pieza.valor && caracter == pieza.caracter && Objects.equals(color, pieza.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fila, columna, color, valor, caracter);
    }

    public String toString(){
        return String.valueOf(simbolo());
    }


}
