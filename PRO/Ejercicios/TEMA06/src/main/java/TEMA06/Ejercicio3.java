package TEMA06;

import java.util.*;
/**
 * Ejercicio 3. Implementa la función uneCadenas, con el siguiente prototipo:
 * List<Character> uneCadenas(List<Character> cad1, List<Character> cad2) que
 * devuelve una lista con la concatenación de cad1 y cad2
 * 
 * @author GuillermoSH
 */
public class Ejercicio3 {
    private List<Character> cadenaConcatenada = new ArrayList<>();

    public List<Character> uneCadenas(List<Character> cad1, List<Character> cad2) {
        for (Character caracter : cad1) {
            this.cadenaConcatenada.add(caracter);
        }
        for (Character caracter : cad2) {
            this.cadenaConcatenada.add(caracter);
        }

        return this.cadenaConcatenada;
    }

    public static void main(String args[]) {
        List<Character> cad1 = new ArrayList<>();
        List<Character> cad2 = new ArrayList<>();
        
        cad1.add('h');
        cad1.add('o');
        cad1.add('l');
        cad1.add('a');
        cad1.add(' ');
        cad2.add('q');
        cad2.add('u');
        cad2.add('e');
        cad2.add(' ');
        cad2.add('t');
        cad2.add('a');
        cad2.add('l');
        
        Ejercicio3 e3 = new Ejercicio3();

        System.out.println(e3.uneCadenas(cad1, cad2));
    }
}
