package model;

public class Caballo extends Pieza implements PiezaSaltadora{
    public Caballo(int fila, int columna, Color color, int valor, char caracter) {
        super(fila, columna, color, valor, caracter);
    }

    @Override
    public void Saltar() {

    }

    @Override
    public String toString() {
        return this.getColor() == Color.BLANCA ? "♘" : "♞";
    }
}
