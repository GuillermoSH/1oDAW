/**
 * Programa que reciba un número, n, y nos dé la suma de los números comprendidos entre [1,n]
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio3 {
    public static void main(String []args){
        int suma=0;

        System.out.println("Introduzca el número n del intervalo [1,n]: ");
        Scanner tec=new Scanner(System.in);
        int n=tec.nextInt();
        tec.close();

        for(int i=1;i<=n;i++){
           suma+=i;
        }

        System.out.println("\nLa suma de los números comprendidos en el intervalo es de: "+suma);
    }
}
