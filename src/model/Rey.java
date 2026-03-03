package model;

public class Rey extends Pieza0 {
    @Override
    public String toString() {
        return this.getColor() == Color.BLANCA ? "♔" : "♚";
    }
}
