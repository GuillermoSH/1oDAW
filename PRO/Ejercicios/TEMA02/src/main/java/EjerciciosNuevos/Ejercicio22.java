/**
 * Programa que reciba un número entero y lo imprima al revés. P.ej: si recibe el número 1759 debería 9571.
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio22 {
    public static long voltear(long n){
        long resultado=0;
        
        while(n>0){
            resultado=resultado+n%10;
            n=n/10;
            if(n>0){
                resultado=resultado*10;
            }
            
        }
        return resultado;
    }
    public static void main(String args[]){
        Scanner tec=new Scanner(System.in);
        System.out.print("\nIntroduce el número que quiere invertir: ");
        long n=tec.nextInt();
        tec.close();

        System.out.println("\nEl número "+n+" invertido es tal que: "+voltear(n));
    }
}
