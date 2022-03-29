package ExamenPRO;

import java.util.*;
import java.io.*;

public class Ejercicio3 {
    private int columnas = 13, filas = 20;
    private String[][] estaturas = new String[filas][columnas];

    public void leerDatos() throws FileNotFoundException {
        // String fichero = "D:\\Programacion\\PRO\\Ejercicios\\TEMA04\\src\\main\\java\\ExamenPRO\\DatosEjercicio3Examen2Eval.txt";
        String fichero = "/media/daw/Toshiba DDe/Programacion/PRO/Ejercicios/TEMA04/src/main/java/ExamenPRO/DatosEjercicio3Examen2Eval.txt";
        String linea;
        String[] lineaDatos;
        Scanner fDatos = new Scanner(new File(fichero));
        int i = 0;

        while (fDatos.hasNextLine()) {
            linea = fDatos.nextLine();
            lineaDatos = linea.split("[ ]+"); // separador por un espacio o más
            String nomPais = lineaDatos[0];

            for (int j = 0; j < lineaDatos.length; j++) {
                if (j == 0) {
                    estaturas[i][j] = nomPais;
                } else {
                    estaturas[i][j] = lineaDatos[j];
                }
            }
            i++;
        }
        fDatos.close();
    }

    public int[] media() {
        int media[] = new int[columnas];
        int suma = 0;

        for (int i = 0; i < filas - 1; i++) {
            for (int j = 1; j < columnas; j++) {
                suma += Integer.parseInt(estaturas[i][j]);
            }
            media[i] += suma / estaturas[0].length - 1;
        }

        return media;
    }

    public int[] min() {
        int min[] = new int[columnas];

        for (int i = 0; i < filas; i++) {
            min[i] = Integer.parseInt(estaturas[0][1]);
            for (int j = 1; j < columnas; j++) {
                if (Integer.parseInt(estaturas[i][j]) < min[i]) {
                    min[i] = Integer.parseInt(estaturas[i][j]);
                }
            }
        }
        return min;
    }

    public int[] max() {
        int max[] = new int[columnas];

        for (int i = 0; i < filas; i++) {
            max[i] = Integer.parseInt(estaturas[0][1]);
            for (int j = 1; j < columnas; j++) {
                if (Integer.parseInt(estaturas[i][j]) > max[i]) {
                    max[i] = Integer.parseInt(estaturas[i][j]);
                }
            }
        }
        return max;
    }

    public void imprimir() {
        System.out.println("                     ESTATURAS POR PAISES                         | MIN MAX MEDIA");
        System.out.println("----------------------------------------------------------------- | --- --- -----");

        int min[] = min();
        int max[] = max();
        int media[] = media();

        for (int i = 0; i < filas; i++) {
            System.out.printf("%65s | %3d %3d %3d", Arrays.toString(estaturas[i]), min[i], max[i], media[i]);
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        Ejercicio3 e = new Ejercicio3();

        e.leerDatos();
        e.imprimir();
    }
}
