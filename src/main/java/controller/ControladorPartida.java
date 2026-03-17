package controller;

import model.*;
import vista.Menu;
import utils.Utils;
import DataAccess.XMLManager;

/**
 * Clase que controla el flujo principal de la partida.
 * Se encarga de gestionar el turno, mostrar el estado del tablero,
 * permitir seleccionar piezas, moverlas y guardar/cargar la partida.
 */
public class ControladorPartida {

    private Tablero tablero;
    private Color turno;
    private Pieza piezaSeleccionada;
    private Menu menu;

    /**
     * Constructor del controlador.
     * Inicializa el tablero, establece el turno inicial y crea el menú.
     */
    public ControladorPartida(){
        tablero = new Tablero();
        turno = Color.BLANCA;
        piezaSeleccionada = null;
        menu = new Menu();
    }

    /**
     * Metodo que inicia una partida.
     * Contiene el bucle del menú hasta que el usuario decide salir.
     */
    public void iniciarPartida(){

        boolean salir = false;

        while (!salir){

            estadoActual();

            int opcion = menu.muestraMenu();

            switch (opcion){

                case 1:
                    System.out.println("\n");
                    System.out.println(tablero);
                    seleccionarPieza();
                    break;

                case 2:
                    tablero.reiniciarTablero();
                    Utils.mostrarMensaje("Tablero reiniciado correctamente");
                    break;

                case 3:
                    cargarTablero();
                    break;

                case 4:
                    guardarTablero();
                    break;

                case 5:
                    salir = true;
                    Menu.despedida();
                    break;

                default:
                    Utils.mostrarMensaje("Opción no válida");
            }
        }
    }

    /**
     * Muestra el estado actual de la partida.
     * Incluye el tablero, la puntuación de cada jugador y el turno actual.
     */
    private void estadoActual(){

        Utils.mostrarMensaje(tablero.toString());

        Utils.mostrarMensaje("Puntos blancas: " +
                tablero.obtenerPuntuacion(Color.BLANCA));

        Utils.mostrarMensaje("Puntos negras: " +
                tablero.obtenerPuntuacion(Color.NEGRA));

        Utils.mostrarMensaje("Turno actual: " + turno);
    }

    /**
     * Permite al jugador seleccionar una pieza del tablero, pide la posición de la pieza y comprueba:
     * Que exista una pieza en esa casilla
     * Que sea del turno del jugador
     */
    private void seleccionarPieza() {

        int fila = Utils.pideEnteroAcotado("Introduce fila (0-7)", "Fila incorrecta",0,7);
        int columna = Utils.pideEnteroAcotado("Introduce columna (0-7)", "Columna incorrecta",0,7);

        Pieza pieza = tablero.obtenerPieza(fila, columna);

        if (pieza == null) {
            Utils.mostrarMensaje("No hay pieza en esa posición");
            return;
        }

        if (pieza.getColor() != turno) {
            Utils.mostrarMensaje("No es tu turno");
            return;
        }

        piezaSeleccionada = pieza;

        int opcion = menu.mostrarMenuPieza();

        if (opcion == 1) {
            moverPieza();
        } else {
            piezaSeleccionada = null;
            Utils.mostrarMensaje("Selección cancelada");
        }
    }

    /**
     * Permite mover la pieza seleccionada a otra posición del tablero.
     * Si en la casilla destino existe una pieza de otro color que no sea el suyo se produce un ataque.
     * Si el movimiento no es válido se lanza la excepción.
     */
    private void moverPieza(){

        if (piezaSeleccionada == null){
            return;
        }

        int filaDestino = Utils.pideEnteroAcotado("Introduce fila destino (0-7)", "Fila incorrecta",0,7);
        int columnaDestino = Utils.pideEnteroAcotado("Introduce columna destino (0-7)", "Columna incorrecta",0,7);

        try{

            tablero.moverYatacar(
                    piezaSeleccionada.getFila(),
                    piezaSeleccionada.getColumna(),
                    filaDestino,
                    columnaDestino
            );

            cambiarTurno();

        }catch(Exception e){

            Utils.mostrarMensaje("Movimiento inválido: " + e.getMessage());
        }

        piezaSeleccionada = null;
    }

    /**
     * Cambia el turno de juego.
     */
    private void cambiarTurno(){

        if (turno == Color.BLANCA){
            turno = Color.NEGRA;
        } else {
            turno = Color.BLANCA;
        }
    }

    /**
     * Guarda el estado actual del tablero.
     */
    private void guardarTablero(){

        boolean guardado = XMLManager.writeXML(tablero, "tablero.xml");

        if (guardado) {
            Utils.mostrarMensaje("Tablero guardado correctamente en XML");
        } else {
            Utils.mostrarMensaje("Error al guardar el tablero");
        }
    }

    /**
     * Carga el tablero desde un archivo XML.
     */
    private void cargarTablero(){

        try{

            tablero = XMLManager.readXML(new Tablero(), "tablero.xml");

            Utils.mostrarMensaje("Tablero cargado correctamente desde XML");

        }catch(Exception e){

            Utils.mostrarMensaje("Error al cargar el tablero");
        }
    }
}