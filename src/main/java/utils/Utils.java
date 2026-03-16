package utils;

import java.util.Scanner;

public class Utils {

    public static void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);
    }

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