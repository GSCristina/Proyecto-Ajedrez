package controller;

import model.*;
import vista.Menu;
import utils.Utils;


public class ControladorPartida {

    private Tablero tablero;
    private Color turno;
    private Pieza piezaSeleccionada;
    private Menu menu;

    public ControladorPartida(){
        tablero = new Tablero();
        turno = Color.BLANCA;
        piezaSeleccionada = null;
        menu = new Menu();
    }

    public void iniciarPartida(){

        boolean salir = false;

        while (!salir){

            estadoActual();

            int opcion = menu.muestraMenu();

            switch (opcion){

                case 1:
                    seleccionarPieza();
                    break;

                case 2:
                    tablero.reiniciarTablero();
                    Menu.mostrarMensaje("Tablero reiniciado correctamente");
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
                    Menu.mostrarMensaje("Opción no válida");
            }
        }
    }

    private void estadoActual(){
        Menu.mostrarMensaje(tablero.toString());
        Menu.mostrarMensaje("Puntos blancas: " + tablero.obtenerPuntuacion(Color.BLANCA));
        Menu.mostrarMensaje("Puntos negras: " + tablero.obtenerPuntuacion(Color.NEGRA));
        Menu.mostrarMensaje("Turno actual: " + turno);
    }

    private void seleccionarPieza() {



        Pieza pieza = tablero.obtenerPieza(fila, columna);

        if (pieza == null) {
            Menu.mostrarMensaje("No hay pieza en esa posición");
            return;
        }

        if (pieza.getColor() != turno) {
            Menu.mostrarMensaje("No es tu turno");
            return;
        }

        piezaSeleccionada = pieza;

        int opcion = menu.mostrarMenuPieza();
        if (opcion == 1) {
            moverPieza();
        } else {
            piezaSeleccionada = null;
            Menu.mostrarMensaje("Selección cancelada");
        }
    }

    private void moverPieza(){

        if (piezaSeleccionada == null){
            return;
        }



        try{

            tablero.moverYatacar(
                    piezaSeleccionada.getFila(),
                    piezaSeleccionada.getColumna(),
                    filaDestino,
                    columnaDestino
            );

            cambiarTurno();

        }catch(Exception e){

            Menu.mostrarMensaje("Movimiento inválido: " + e.getMessage());
        }

        piezaSeleccionada = null;
    }
    private void cambiarTurno(){

        if (turno == Color.BLANCA){
            turno = Color.NEGRA;
        } else {
            turno = Color.BLANCA;
        }
    }

    private void guardarTablero(){


    }

    private void cargarTablero(){


    }
}
