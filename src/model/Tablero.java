package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tablero implements Serializable {
    private List<Pieza> piezasBlancas;
    private List<Pieza> piezasNegras;
    private List<Pieza> piezasEliminadas;

    public Tablero() {
        this.piezasBlancas = new ArrayList<>();
        this.piezasNegras = new ArrayList<>();
        this.piezasEliminadas = new ArrayList<>();

        inicializarTablero();
    }

    private void inicializarTablero() {

        piezasNegras.add(new Torre(0, 0, Color.NEGRA));
        piezasNegras.add(new Caballo(0, 1, Color.NEGRA));
        piezasNegras.add(new Alfil(0, 2, Color.NEGRA));
        piezasNegras.add(new Reina(0, 3, Color.NEGRA));
        piezasNegras.add(new Rey(0, 4, Color.NEGRA));
        piezasNegras.add(new Alfil(0, 5, Color.NEGRA));
        piezasNegras.add(new Caballo(0, 6, Color.NEGRA));
        piezasNegras.add(new Torre(0, 7, Color.NEGRA));

        for (int i = 0; i < 8; i++) {
            piezasNegras.add(new Peon(1, i, Color.NEGRA));
        }

        for (int i = 0; i < 8; i++) {
            piezasBlancas.add(new Peon(6, i, Color.BLANCA));
        }

        piezasBlancas.add(new Torre(7, 0, Color.BLANCA));
        piezasBlancas.add(new Caballo(7, 1, Color.BLANCA));
        piezasBlancas.add(new Alfil(7, 2, Color.BLANCA));
        piezasBlancas.add(new Reina(7, 3, Color.BLANCA));
        piezasBlancas.add(new Rey(7, 4, Color.BLANCA));
        piezasBlancas.add(new Alfil(7, 5, Color.BLANCA));
        piezasBlancas.add(new Caballo(7, 6, Color.BLANCA));
        piezasBlancas.add(new Torre(7, 7, Color.BLANCA));
    }
    public Pieza obtenerPieza(int fila, int columna) {

        for (Pieza p : piezasBlancas) {
            if (p.getFila() == fila && p.getColumna() == columna) {
                return p;
            }
        }

        for (Pieza p : piezasNegras) {
            if (p.getFila() == fila && p.getColumna() == columna) {
                return p;
            }
        }
        return null;
    }

    /**
     * Metodo con el cual obtenemos la puntuacion total de piezas vivas de un color
     * @param color pasamos el color por parametro para que nos diga solo las de ese color Blancas o Negras
     * @return devuelve la puntuacion total de piezas del mismo color (solo vivas)
     */
    public int obtenerPuntuacion(Color color) {
        int puntosTotales = 0;

        if (color == Color.BLANCA) {
            for (Pieza p : piezasBlancas) {
                puntosTotales += p.obtenerPuntosPieza();
            }
        }

        else if (color == Color.NEGRA) {
            for (Pieza p : piezasNegras) {
                puntosTotales += p.obtenerPuntosPieza();
            }
        }

        return puntosTotales;
    }

    @Override
    public String toString() {
        String tableroDibujado = "";

        for (int fila = 0; fila < 8; fila++) {
            tableroDibujado += (8 - fila) + " ";

            for (int col = 0; col < 8; col++) {
                Pieza p = obtenerPieza(fila, col);

                if (p != null) {

                    tableroDibujado += p.toString() + " ";
                } else {

                    if ((fila + col) % 2 == 0) {
                        tableroDibujado += "░ ";
                    } else {
                        tableroDibujado += "▓ ";
                    }
                }
            }
            tableroDibujado += "\n";
        }
        tableroDibujado += "  a b c d e f g h\n";
        return tableroDibujado;
    }
}
