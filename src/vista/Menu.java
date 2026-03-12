package vista;

import java.util.Scanner;

public class Menu {
    private Scanner sc;
    public Menu() {
        this.sc=new Scanner(System.in);
    }
    public int muestraMenu() {

        System.out.println("--- MENU PRINCIPAL ---");
        System.out.print("1. Seleccionar pieza");
        System.out.println("2. Reiniciar Tablero");
        System.out.println("3. Cargar Tablero");
        System.out.println("4. Guardar Tablero");
        System.out.println("5. Salir");
        System.out.print("Elige una opción:");

        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }
    public int mostrarMenuPieza() {
        System.out.println("\n---Pieza Seleccionada ---");
        System.out.println("1. Mover");
        System.out.println("2. Cancelar");
        System.out.print("Elige una opción:");

        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    public String pedirJugada(String colorTurno) {
        System.out.println("Turno de las piezas"+ colorTurno);
        System.out.print("Introduce tu jugada");
        return sc.nextLine();
    }

    public static void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);
    }
    public static void despedida() {

        System.out.println("Has terminado la partida");
    }

}






