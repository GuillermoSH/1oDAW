/**
 * Programa que imprima el "lucky number" de una persona. Éste se consigue reduciendo la fecha de nacimineto a un sólo dígito.
 * P.Ej. si la fecha de nacimiento es 11-02-1973, entonces el sería:
 * 11+2+1973=1986
 * 1+9+8+6=24
 * 2+4=6
 * Entonces el resultado sería 6.
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio16 {
    /**
     * Esta función realiza la suma de los dígitos y el desplazamiento de los mismos para poder sumarlos luego
     * @param n dígito separado del número inicial
     * @return suma de los digitos del número dado
     */
    public static int sumaCifras(int n){
        int suma=0;
        while(n>0){
            suma+=n%10; //sumar el dígito de la derecha
            n/=10; //desplazar el número un lugar a la derecha
        } return suma;
    }
    public static void main(String args[]){
        Scanner tec=new Scanner(System.in);
        System.out.print("INTRODUCE TU FECHA DE NACIMIENTO");
        System.out.print("\n  Día: ");
        int dia=tec.nextInt();
        System.out.print("  Mes: ");
        int mes=tec.nextInt();
        System.out.print("  Año: ");
        int anio=tec.nextInt();

        int suma=dia+mes+anio;

        while(suma>9){
            suma=sumaCifras(suma);
        }
        System.out.println("\nEl lucky number es: "+suma);
    }
}
