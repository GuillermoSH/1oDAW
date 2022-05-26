package TEMA06;

import java.util.*;

/**
 * Ejercicio 7. Implementa una función a la que se le pasan dos listas de
 * enteros ordenados en sentido creciente y nos devuelva una única lista,
 * también ordenada, fusión de las dos anteriores. Existirán la posibilidad de
 * que la lista generada esté ordenada ascendentemente o descentemente.
 * Desarrolla el algoritmo de forma no destructiva, es decir, que las listas
 * utilizadas como parámetros de entrada se mantengan intactas.
 * 
 * @author GuillermoSH
 */
public class Ejercicio7<T extends Comparable> {
    public List<T> ordenaListasUnidas(List<Integer> lista1, List<Integer> lista2, boolean ascendente) {
        List<T> listaOrdenada = new ArrayList<>();
        int i;
        int j;

        for (i = j = 0; i < lista1.size() && j < lista2.size();) {
            if (lista1.get(i).compareTo(lista2.get(j)) < 0) {
                
            }
        }

        if (!ascendente) {
            Collections.sort(listaOrdenada, Collections.reverseOrder());
        }

        return listaOrdenada;
    }

    public static void main(String[] args) {
        Ejercicio7 e7 = new Ejercicio7();
        List<Integer> lista1 = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11));
        List<Integer> lista2 = new ArrayList<>(Arrays.asList(2, 4, 6, 5, 8, 10, 12));

        System.out.print("¿Desea que la lista sea en orden ascendente? (y/n): ");
        Scanner respuesta = new Scanner(System.in);
        String ascendente = respuesta.nextLine();

        if (ascendente.equals("y") || ascendente.equals("Y")) {
            System.out.println(e7.ordenaListasUnidas(lista1, lista2, true));
        } else {
            System.out.println(e7.ordenaListasUnidas(lista1, lista2, false));
        }
        respuesta.close();
    }
}
