package utils;

public class Utils {

    //Convertir letra de columna a número ---> "letraAColumna" (static)

    static int letraAColumna(char letra) {
        char minuscula = Character.toLowerCase(letra);
        if (minuscula >= 'a' && minuscula <= 'h') {
            return minuscula - 'a';
        }
        return -1;
    }

    //Convertir número del ajedrez a fila de matriz ---> "numeroAFila" (static)

    static int numeroAFila(int numeroFilaAjedrez) {
        if (numeroFilaAjedrez < 1 || numeroFilaAjedrez > 8) {
            throw new IllegalArgumentException("El número de fila debe estar entre 1 y 8");
        }
        return 8 - numeroFilaAjedrez;
    }


    //Metodo "validarFormatoJugada2 que recibe por parametro una jugada, si está vacío o no tiene la longitud exacta (5 letras: a2 a4) devuelve false.

    public boolean validarFormatoJugada2(String jugada) {
        if (jugada == null || jugada.length() != 5) {
            return false;
        }
        String formato = "[a-zA-Z][0-9] [a-zA-Z][0-9]";
        return jugada.matches(formato);
    }

}