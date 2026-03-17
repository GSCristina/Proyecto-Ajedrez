package vista;

import utils.Utils;

import java.util.Scanner;

public class Menu {

    public Menu() {
    }

    /**
     * Metodo que muestra el menu del tablero
     * @return Devuelve la opcion escogida por el jugador
     */
    public int muestraMenu() {

        System.out.println("--- MENU PRINCIPAL ---");
        System.out.println("1. Seleccionar pieza");
        System.out.println("2. Reiniciar Tablero");
        System.out.println("3. Cargar Tablero");
        System.out.println("4. Guardar Tablero");
        System.out.println("5. Salir");
        System.out.print("");

        int opcion = Utils.pideEnteroAcotado("Elige una opción:","Opción errónea",1,5);
        return opcion;
    }

    /**
     * Metodo que muestra las opciones de cada pieza
     * @return Opcion escogida por el jugador
     */
    public int mostrarMenuPieza() {
        System.out.println("\n---Pieza Seleccionada ---");
        System.out.println("1. Mover");
        System.out.println("2. Cancelar");
        int opcion = Utils.pideEnteroAcotado("Elige una opción:","Opción errónea",1,2);
        return opcion;
    }

    /**
     * Metodo que devuleve una despedida
     */
    public static void despedida() {

        System.out.println("Has terminado la partida");
    }

}






