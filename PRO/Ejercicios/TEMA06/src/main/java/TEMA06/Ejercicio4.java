package TEMA06;

import java.util.*;

/**
 * Ejercicio 4. Generar una lista de 6 números aleatorios ordenados
 * descendentemente.
 * 
 * @author GuillermoSH
 */
public class Ejercicio4 {
    private Set<Integer> numerosAleatorios = new TreeSet<>(Collections.reverseOrder());

    public Set<Integer> generarAleatorios() {
        while (numerosAleatorios.size() < 6) {
            numerosAleatorios.add((int)(100*Math.random()));
        }
        
        return numerosAleatorios;
    }

    public static void main(String args[]) {
        Ejercicio4 e4 = new Ejercicio4();

        System.out.println(e4.generarAleatorios());
    }
}
