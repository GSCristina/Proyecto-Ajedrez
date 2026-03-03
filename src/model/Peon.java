package model;

public class Peon extends Pieza{
    @Override
    public String toString() {
        return this.getColor() == Color.BLANCA ? "♙" : "♟";
    }
}
