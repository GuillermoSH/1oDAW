/**
 * Programa que diga cuántos dígitos tiene un número introducido por teclado
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio8 {
    public static void main(String args[]){
        Scanner tec=new Scanner(System.in);
        System.out.print("Introduce el número que quiere analizar: ");
        int n=tec.nextInt();
        tec.close();
        
        int aux=n,digitos=2;
        
        for(int i=1;i<=n;i++){
            aux/=10;
            
            if(aux<10){
                break;
            }

            digitos++;
        }

        System.out.println("El número "+n+" tiene "+digitos+" dígitos.");
    }
}
