package model;

public class Torre extends Pieza{
    @Override
    public String toString() {
        return this.getColor() == Color.BLANCA ? "♖" : "♜";
    }
}
