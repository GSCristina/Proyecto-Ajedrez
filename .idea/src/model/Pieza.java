package model;

import java.util.Objects;

public abstract class Pieza {
    private int fila;
    private int columna;
    private String color;
    private int valor;
    private char caracter;

    public Pieza(int fila, int columna, String color, int valor, char caracter) {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
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
}
