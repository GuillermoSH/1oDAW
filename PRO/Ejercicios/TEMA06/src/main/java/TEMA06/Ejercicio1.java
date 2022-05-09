package TEMA06;

import java.util.*;

public class Ejercicio1 {
    private Map<Integer, Integer> repeticiones = new LinkedHashMap<>();

    /**
     * Metodo que genera un set con la lista de numeros aleatorios
     * para un sorteo de 6 numeros.
     */
    public Set<Integer> generarSorteo() {
        Set<Integer> sorteo = new TreeSet<>();
        int numeroAleatorio;

        while (sorteo.size() < 6) {
            numeroAleatorio = (int) (49 * Math.random() + 1);
            sorteo.add(numeroAleatorio);
        }

        return sorteo;
    }

    /**
     * Metodo que cuenta el numero de repeticiones de cada numero
     * dentro de la lista de sorteos generados
     */
    public void generarDatos() {
        Set<Integer> sorteo;

        for (int i = 1; i <= 10000; i++) {
            sorteo = generarSorteo();

            for (Integer n : sorteo) {
                if (repeticiones.containsKey(n)) {
                    repeticiones.put(n, repeticiones.get(n) + 1);
                } else {
                    repeticiones.put(n, 1);
                }
            }
        }
    }

    /**
     * Metodo que ordena de menor a mayor el numero de repeticiones
     * que tiene cada numero en la lista de sorteos
     */
    public void ordenarDatos() {
        Map<Integer, Integer> mapAuxiliar = new TreeMap<>(Collections.reverseOrder());

        for (int key : repeticiones.keySet()) {
            mapAuxiliar.put(repeticiones.get(key), key);
        }

        this.repeticiones.clear();

        for (int key : mapAuxiliar.keySet()) {
            this.repeticiones.put(mapAuxiliar.get(key), key);
        }
    }

    /**
     * Metodo para mostrar la lista de repeticiones de los numeros
     * de cada sorteo
     */
    public void imprimirDatos() {
        int contador = 6;

        System.out.println("\nTop 6 numeros mas repetidos en los sorteos:\n");

        for (int key : this.repeticiones.keySet()) {
            contador--;
            
            System.out.printf("%21d %-21d\n",key,this.repeticiones.get(key));

            if (contador < 1) {
                break;
            }
        }
    }

    public static void main(String args[]) {
        Ejercicio1 e1 = new Ejercicio1();
        e1.generarDatos();
        e1.ordenarDatos();
        e1.imprimirDatos();
    }
}
