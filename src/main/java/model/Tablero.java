package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="tablero")
public class Tablero implements Serializable {
    @XmlElement(name = "piezasBlancas",type = Pieza.class)
    private List<Pieza> piezasBlancas;
    @XmlElement(name = "piezasNegras",type = Pieza.class)
    private List<Pieza> piezasNegras;
    @XmlElement(name = "piezasEliminadas",type = Pieza.class)
    private List<Pieza> piezasEliminadas;

    public Tablero() {
        this.piezasBlancas = new ArrayList<>();
        this.piezasNegras = new ArrayList<>();
        this.piezasEliminadas = new ArrayList<>();

        inicializarTablero();
    }

    /**
     * Metodo con el que iniciamos una partida de ajedrez colocamos las fichas en la posición que
     * le corresponde a cada una y según el color de estas
     */
    private void inicializarTablero() {

        piezasNegras.add(new Torre(0, 0, Color.NEGRA,5));
        piezasNegras.add(new Caballo(0, 1, Color.NEGRA,3));
        piezasNegras.add(new Alfil(0, 2, Color.NEGRA,3));
        piezasNegras.add(new Reina(0, 3, Color.NEGRA,9));
        piezasNegras.add(new Rey(0, 4, Color.NEGRA,100));
        piezasNegras.add(new Alfil(0, 5, Color.NEGRA,9));
        piezasNegras.add(new Caballo(0, 6, Color.NEGRA,3));
        piezasNegras.add(new Torre(0, 7, Color.NEGRA,5));

        for (int i = 0; i < 8; i++) {
            piezasNegras.add(new Peon(1, i, Color.NEGRA,1));
        }

        for (int i = 0; i < 8; i++) {
            piezasBlancas.add(new Peon(6, i, Color.BLANCA,1));
        }

        piezasBlancas.add(new Torre(7, 0, Color.BLANCA,5));
        piezasBlancas.add(new Caballo(7, 1, Color.BLANCA,3));
        piezasBlancas.add(new Alfil(7, 2, Color.BLANCA,9));
        piezasBlancas.add(new Reina(7, 3, Color.BLANCA,9));
        piezasBlancas.add(new Rey(7, 4, Color.BLANCA,100));
        piezasBlancas.add(new Alfil(7, 5, Color.BLANCA,9));
        piezasBlancas.add(new Caballo(7, 6, Color.BLANCA,3));
        piezasBlancas.add(new Torre(7, 7, Color.BLANCA,5));
    }

    /**
     * Metodo que busca y devuelve la pieza que se encuentra en una coordenada específica del tablero.
     * Recorre las listas de piezas activas (blancas y negras) buscando coincidencias.
     * * @param fila La fila del tablero que se quiere consultar (de 0 a 7).
     * @param columna La columna del tablero que se quiere consultar (de 0 a 7).
     * @return El objeto Pieza que ocupa esa casilla, o null si la casilla está vacía.
     */
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
     * Metodo para borrar todo el contenido de las lista de golpe.
     */
    public void vaciarPiezas() {
        this.piezasBlancas.clear();
        this.piezasNegras.clear();
        this.piezasEliminadas.clear();
    }

    /**
     * Metodo que reinicia el tablero usando el metodo "vaciarPiezas" e inicia una nueva partida
     */
    public void reiniciarTablero() {
        vaciarPiezas();
        inicializarTablero();
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

    /**Metodo que recibe una pieza y mirando su color la metera en la lista de piezasBlancas o piezasNegras.
     * @param pieza le pasaremos la pieza que queremos añadir y segun su color la metera en una lista u otra
     */
    public void añadirPieza(Pieza pieza) {
        if (pieza == null) return;

        if (pieza.getColor() == Color.BLANCA) {
            this.piezasBlancas.add(pieza);
        } else if (pieza.getColor() == Color.NEGRA) {
            this.piezasNegras.add(pieza);
        }
    }

    /**
     * Metodo que crea una copia exacta (clon) del estado actual del tablero.
     * Internamente crea un tablero nuevo, lo vacía y clona una a una todas las
     * piezas vivas y eliminadas manteniendo sus posiciones exactas.
     * * @return Un nuevo objeto Tablero que es una copia independiente del original.
     */
    public Tablero obtenerCopia() {

        Tablero copiaTablero = new Tablero();
        copiaTablero.vaciarPiezas();

        for (Pieza p : this.piezasBlancas) {
            copiaTablero.añadirPieza(p.copiarPieza());
        }

        for (Pieza p : this.piezasNegras) {
            copiaTablero.añadirPieza(p.copiarPieza());
        }

        for (Pieza p : this.piezasEliminadas) {
            copiaTablero.piezasEliminadas.add(p.copiarPieza());
        }

        return copiaTablero;
    }
    /**
     * Metodo que mueve la pieza desde su posicion de origen (Fila y Columna) a una posicion destino si en el destino
     * encuentra una pieza la manda a la lista de eliminados. Control de que el usuario coja una casilla que se encuntre
     * vacia, si es asi no hace nada.
     * @param fOrig Fila en la que se encuentre la pieza inicialmente
     * @param cOrig Columna en la que se encuentre la pieza inicialmente
     * @param fDest Fila a la que vamos a mandar la pieza
     * @param cDest Columna a la que vamos a mandar la pieza
     */
    public void moverYatacar(int fOrig, int cOrig, int fDest, int cDest) {

        Pieza piezaAMover = obtenerPieza(fOrig, cOrig);

        if (piezaAMover == null) {
            return;
        }
        if (fDest < 0 || fDest > 7 || cDest < 0 || cDest > 7) {
            throw new IllegalArgumentException("No se puede mover la pieza fuera del tablero");
        }


        Pieza piezaDestino = obtenerPieza(fDest, cDest);
        if (piezaDestino != null) {
            if (piezaDestino instanceof Rey) {
                throw new IllegalArgumentException("No se puede atacar al rey");
            }
            if (piezaDestino.getColor() == piezaAMover.getColor()) {
                throw new IllegalArgumentException("No puedes atacar una pieza de tu mismo color");
            }
            if (piezaDestino.getColor() == Color.BLANCA) {
                piezasBlancas.remove(piezaDestino);
            } else {
                piezasNegras.remove(piezaDestino);
            }
            piezasEliminadas.add(piezaDestino);
        }
        piezaAMover.mover(fDest, cDest, this);
    }

    /**
     * Metodo que comprueba si existen piezas bloqueando el camino (horizontal, vertical o diagonal)
     * entre una casilla de origen y una de destino. No evalúa saltos como el del Caballo.
     * @param fOrig La fila de la casilla donde se encuentra la pieza actualmente (0-7).
     * @param cOrig La columna de la casilla donde se encuentra la pieza actualmente (0-7).
     * @param fDest La fila de la casilla a la que se quiere mover (0-7).
     * @param cDest La columna de la casilla a la que se quiere mover (0-7).
     * @return true si hay al menos una pieza estorbando en el trayecto; false si el camino está libre.
     */
    public boolean hayPiezasEntre(int fOrig, int cOrig, int fDest, int cDest){
        int difFila = fDest - fOrig;
        int difColumna = cDest - cOrig;

        int pasoFila = 0;
        if (difFila > 0) pasoFila = 1;
        else if (difFila < 0) pasoFila = -1;

        int pasoColumna = 0;
        if (difColumna > 0) pasoColumna = 1;
        else if (difColumna < 0) pasoColumna = -1;

        if (Math.abs(difFila) != Math.abs(difColumna) && difFila != 0 && difColumna != 0) {
            return false;
        }

        int fActual = fOrig + pasoFila;
        int cActual = cOrig + pasoColumna;

        while (fActual != fDest || cActual != cDest) {
            if (obtenerPieza(fActual, cActual) != null) {
                return true;
            }
            fActual += pasoFila;
            cActual += pasoColumna;
        }
        return false;
    }
    /**
     * Método que comprueba si el Rey de un color específico está siendo amenazado (en jaque).
     * Busca al Rey de ese color en el tablero y luego verifica si alguna de las
     * piezas enemigas vivas tiene la capacidad de atacarle en su casilla actual.
     * * @param color El color del equipo que queremos comprobar (BLANCA o NEGRA).
     * @return true si el Rey está en jaque, false si está a salvo.
     */
    public boolean estaEnJaque(Color color) {
        Pieza miRey = null;

        List<Pieza> misPiezas = (color == Color.BLANCA) ? piezasBlancas : piezasNegras;
        List<Pieza> piezasEnemigas = (color == Color.BLANCA) ? piezasNegras : piezasBlancas;

        for (Pieza p : misPiezas) {
            if (p instanceof Rey) {
                miRey = p;
                break;
            }
        }
        if (miRey == null) {
            return false;
        }
        for (Pieza enemiga : piezasEnemigas) {
            if (enemiga.puedeAtacar(miRey, this)) {
                return true;
            }
        }
        return false;
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
        tableroDibujado += "  1  2  3  4 5  6 7  8\n";
        return tableroDibujado;
    }
}
