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

    public static void despedida() {

        System.out.println("Has terminado la partida");
    }

}






