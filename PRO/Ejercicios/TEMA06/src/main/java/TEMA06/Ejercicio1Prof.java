package TEMA06;

import java.util.*;

public class Ejercicio1Prof {
    private Map<Integer, Integer> repeticiones = new HashMap<>();
    private int numeroSorteos;

    public Ejercicio1Prof(int numeroSorteos) {
        this.numeroSorteos = numeroSorteos;
    }

    public Set<Integer> generarSorteo() {
        Set<Integer> sorteo = new TreeSet<>();
        int numeroAleatorio;

        while (sorteo.size() < 6) {
            numeroAleatorio = (int) (49 * Math.random() + 1);
            sorteo.add(numeroAleatorio);
        }

        return sorteo;
    }

    public void inicializaDatos() {
        for (int i = 1; i <= 49; i++) {
            repeticiones.put(i, 0);
        }
    }

    public void generarDatos() {
        Set<Integer> sorteo;

        for (int i = 1; i <= this.numeroSorteos; i++) {
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

    public void generarDatos2() {
        Set<Integer> sorteo;
        inicializaDatos();

        for (int i = 1; i <= 10000; i++) {
            sorteo = generarSorteo();

            for (Integer n : sorteo) {
                repeticiones.put(n, repeticiones.get(n) + 1);
            }
        }
    }

    public Map<Integer, Integer> ordenarDatos() {
        Map<Integer, Integer> repeticionesAux = new TreeMap<>();
        int numeroMax, valorMax;

        while (!this.repeticiones.isEmpty()) {
            numeroMax = 0;
            valorMax = -1;

            for (Integer k : repeticiones.keySet()) {
                if (this.repeticiones.get(k) > valorMax) {
                    numeroMax = k;
                    valorMax = this.repeticiones.get(k);
                }
            }
            repeticionesAux.put(numeroMax, valorMax);
            this.repeticiones.remove(numeroMax);
        }
        return this.repeticiones = repeticionesAux;
    }

    public void imprimirDatos() {
        int contador = 0;

        System.out.println("Número Repeticiones");
        System.out.println("------ ------------");

        for (int k : this.repeticiones.keySet()) {
            System.out.printf("%6d %11d\n", k, this.repeticiones.get(k));

            contador++;

            if (contador == 6) {
                break;
            }
        }
    }

    public static void main(String args[]) {
        long inicio;
        double suma = 0, tActual = 0;
        int repeticiones = 10;
        for (int i = 1; i <= repeticiones; i++) {
            inicio = System.currentTimeMillis();

            Ejercicio1Prof e1 = new Ejercicio1Prof(1000000);

            e1.generarDatos();
            e1.ordenarDatos();
            e1.imprimirDatos();

            tActual = (System.currentTimeMillis() - inicio) / 1000.0;

            System.out.printf("Tiempo de ejecucion: %8.3f s.\n", tActual);

            suma += tActual;
        }
        System.out.printf("Tiempo de ejecucion: %8.3f s.\n", suma / repeticiones);
    }
}
