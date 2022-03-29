package ExamenPRO;

import java.util.*;

/**
 * 1) Realiza un método que reciba una cadena de caracteres y devuelva un array
 * de caracteres con
 * todos los caracteres de la cadena original en orden inverso. (2puntos)
 */
public class Ejercicio1 {
    public char[] invertir(String s) {
        char[] res = new char[s.length()];

        for (int i = s.length() - 1, j = 0; i >= 0 && j < s.length(); i--, j++) {
            res[i] = s.charAt(j);
        }
        return res;
    }

    public static void main(String args[]) {
        Scanner tec = new Scanner(System.in);
        System.out.print("Introduzca la cadena de caracteres que quiere invertir: ");
        String cadCaracteres = tec.nextLine();
        Ejercicio1 e = new Ejercicio1();

        e.invertir(cadCaracteres);
        System.out.println("El resultado es: " + Arrays.toString(e.invertir(cadCaracteres)));
    }
}
