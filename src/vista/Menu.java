package vista;

public class Menu {
    public static void muestraMenu() {
        System.out.println("--- MENU PRINCIPAL ---");
        System.out.println("1. Seleccionar pieza");
        System.out.println("2. Reiniciar tablero");
        System.out.println("3. Cargar tablero");
        System.out.println("4. Guardar tablero");
        System.out.println("0. Salir");
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    public static void despedida(){
        System.out.println("Has terminado la partida");
    }
}

