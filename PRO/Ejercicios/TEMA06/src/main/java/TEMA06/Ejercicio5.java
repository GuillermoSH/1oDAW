package TEMA06;

import java.util.*;

/**
 * Ejercicio 5. Implementa un método genérico al que se le pasa una lista de
 * valores de la clase genérica T y devuelve otra donde se han eliminado las
 * repeticiones.
 * 
 * @author GuillermoSH
 */
public class Ejercicio5<T extends Comparable> {
    public List<T> eliminarRepetidos(List<T> lista) {
        int aux = 1;
        for (int i = 0; i < lista.size(); i++) {
            for (int j = aux; j < lista.size(); j++) {
                if (lista.get(i).compareTo(lista.get(j)) == 0) {
                    lista.remove(j);
                    j--;
                }
            }
            aux++;
        }
        return lista;
    }

    public static void main(String[] args) {
        Ejercicio5<Integer> e51 = new Ejercicio5<>();

        List<Integer> lista1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6));
        System.out.println(e51.eliminarRepetidos(lista1));

        Ejercicio5<String> e52 = new Ejercicio5<>();
        List<String> lista2 = new ArrayList<>(Arrays.asList("hola", "que", "tal", "?", "que", "?", "hola"));
        System.out.println(e52.eliminarRepetidos(lista2));

        Ejercicio5<Double> e53 = new Ejercicio5<>();
        List<Double> lista3 = new ArrayList<>(Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5, 1.1, 2.2, 3.3, 4.4, 5.5, 6.6));
        System.out.println(e53.eliminarRepetidos(lista3));
    }
}
