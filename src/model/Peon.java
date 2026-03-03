package model;

public class Peon extends Pieza0 {
    @Override
    public String toString() {
        return this.getColor() == Color.BLANCA ? "♙" : "♟";
    }
}
