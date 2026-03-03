package model;

public class Rey extends Pieza {
    @Override
    public String toString() {
        return this.getColor() == Color.BLANCA ? "♔" : "♚";
    }
}
