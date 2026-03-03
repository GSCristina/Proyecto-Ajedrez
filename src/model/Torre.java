package model;

public class Torre extends Pieza0 {
    @Override
    public String toString() {
        return this.getColor() == Color.BLANCA ? "♖" : "♜";
    }
}
