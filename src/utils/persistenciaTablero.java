package utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class persistenciaTablero {

    //Un método para, dado un tablero de ajedrez y una cadena con una ruta, guardar el tablero con sus piezas en la ruta especificada.

    /**
     * Guarda el tablero en la ruta especificada.
     *
     * @param tablero Matriz o representación del tablero
     * @param ruta    Ruta del archivo (ej. "partida.txt")
     */
    public void guardarTablero(String[][] tablero, String ruta) {
        File archivo = new File(ruta);

        try {
            PrintWriter escritor = new PrintWriter(archivo);
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[i].length; j++) {
                    escritor.print(tablero[i][j] + " ");
                }
                escritor.println();
            }
            escritor.close();
            System.out.println("Tablero guardado correctamente en " + ruta);
        } catch (Exception e) {
            System.out.println("Error al guardar el tablero: " + e.getMessage());
        }
    }

    //Un método que, dada una ruta, reconstruya el tablero almacenado en dicha ruta y lo devuelva.

    /**
     * Lee un archivo de texto en la ruta especificada y reconstruye
     * la matriz del tablero de ajedrez.
     *
     * @param ruta Ubicación del archivo guardado.
     * @return Una matriz String[][] de 8x8 con las piezas, o null si hay error.
     * @throws java.io.FileNotFoundException si el archivo no se encuentra en la ruta especificada.
     */
    public String[][] cargarTableroDesdeRuta(String ruta) throws FileNotFoundException {
        String[][] tablero = new String[8][8];
        File archivo = new File(ruta);

        if (!archivo.exists()) {
            throw new FileNotFoundException("No se encontró el archivo en: " + ruta);
        }

        try (Scanner lector = new Scanner(archivo)) {

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (lector.hasNext()) {
                        tablero[i][j] = lector.next();
                    } else
                        tablero[i][j] = null;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());


            System.out.println("Tablero cargado con éxito desde " + ruta);
            String[][] tablero1 = tablero;
            return tablero1;

        }return null;
    }
}