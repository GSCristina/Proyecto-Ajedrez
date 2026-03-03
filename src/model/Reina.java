package model;

public class Reina extends Pieza0 {
    @Override
    public String toString() {
        return this.getColor() == Color.BLANCA ? "♕" : "♛";
    }
}
