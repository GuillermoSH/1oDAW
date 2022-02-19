/**
 * Programa que reciba un número, n, e imprima los n primeros números de la sucesión de Fibonacci
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio14 {
    public static void main(String args[]){
        System.out.print("Introduzca la cantidad de números de Fibonacci que quiere ver: ");
        Scanner tec=new Scanner(System.in);
        int n=tec.nextInt(),n1=0,n2=1;
        tec.close();
        
        n=n-2;

        System.out.println(n1);
        System.out.println(n2);

        for(int i=0;i<n;i++){
            n2+=n1;
            n1=n2-n1;
            System.out.println(n2);
        }
    }
}
