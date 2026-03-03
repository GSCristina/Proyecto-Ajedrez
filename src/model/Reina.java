package model;

public class Reina extends Pieza{
    @Override
    public String toString() {
        return this.getColor() == Color.BLANCA ? "♕" : "♛";
    }
}
