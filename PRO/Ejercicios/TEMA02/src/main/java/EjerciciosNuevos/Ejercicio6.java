/**
 * Programa que reciba un numero e imprima todos los numeros primos 
 * comprendidos entre 1 y ese número (un número primo es si y solo si 
 * divisible entre él mismo y 1)
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio6 {
    public static void main(String args[]){
        int contador=0;
        
        Scanner tec=new Scanner(System.in);
        System.out.print("Introduce el numero 'n' del intervalo [1,n]: ");
        int n=tec.nextInt();
        tec.close();
        System.out.println("");
    
        for(int i=1;i<=n;i++){
            if(esPrimo(i)){
                contador++;
                System.out.println(i);
            }
        }
        System.out.println("\nTotal: "+contador);
    }
    /**
     * Programa que verifique si el número que se le pasa es primo o no
     * @param n número a comprobar
     * @return Comprobante si es primo o no
     */
    public static boolean esPrimo(int n){
        if(n==0 || n==1 || n==4){
            return false;
        }
        for(int i=2;i<n/2;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    
}
