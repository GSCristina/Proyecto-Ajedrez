package utils;

import java.util.Scanner;

public class Utils {

    /**
     * Método que muestra un mensaje en pantalla
     * @param mensaje (Mensaje a enseñar en pantalla)
     */
    public static void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);
    }

    /**
     * Método que pide un número entero, pero lanza error si es un entero fuera del mínimo y máximo.
     * @param mensaje (Mensaje pidiendo el entero en cuestión)
     * @param mensajeError (Mensaje lanzado en caso de que el entero esté fuera de mínimo y máximo)
     * @param min (Entero mínimo que recibe)
     * @param max (Entero máximo que recibe)
     * @return (Devuelve el número introducido después de comprobar que está en el rango deseado)
     */
    public static int pideEnteroAcotado(String mensaje, String mensajeError, int min, int max) {
        int numero;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(mensaje);
            numero = sc.nextInt();
            if (numero < min || numero > max) {
                System.out.println(mensajeError);
            }
        } while (numero < min || numero > max);
        return numero;
    }
}