import model.Pieza;
import model.Tablero;
import controller.ControladorPartida;

public class Main {
    static void main(String[] args) {
        ControladorPartida juego = new ControladorPartida();
        juego.iniciarPartida();
    }
}
