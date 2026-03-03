package model;

public class Alfil extends Pieza{
    @Override
    public String toString() {
        return this.getColor() == Color.BLANCA ? "♗" : "♝";
    }
}
