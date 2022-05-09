package TEMA06;

import java.util.*;

public class Ejercicio2 {
    private List<Character> listaCaracteres = new ArrayList<>();

    public List<Character> leerCadena(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            listaCaracteres.add(cadena.charAt(i));
        }

        return listaCaracteres;
    }

    public static void main(String args[]) {
        Ejercicio2 e2 = new Ejercicio2();
        
        System.out.print("Introduzca la cadena que quiere desglozar: ");
        Scanner tec = new Scanner(System.in);
        String cadena = tec.nextLine();
        
        System.out.println(e2.leerCadena(cadena));
        
        tec.close();
    }
}
