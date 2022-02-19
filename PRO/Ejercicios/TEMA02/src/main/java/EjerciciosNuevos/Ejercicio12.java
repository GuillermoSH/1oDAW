/**
 * Programa que reciba un número y diga si es primo
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio12 {
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
    public static void main(String args[]){
        System.out.print("Introduce el número que quieres comprobar: ");
        Scanner tec=new Scanner(System.in);
        int n=tec.nextInt();
        tec.close();

        if(esPrimo(n)==true){
            System.out.println("\nSu número es primo.");
        } else{
            System.out.println("\nSu número no es primo.");
        }
    }
}
