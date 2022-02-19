/**
 * Programa que reciba un número de 3 cifras y diga si es un número de Armstrong
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio13 {
    public static void main(String args[]){
        System.out.print("Introduce el número de 3 cifras que quiera comprobar: ");
        Scanner tec=new Scanner(System.in);
        int n=tec.nextInt();
        tec.close();

        int suma,unidades,decenas,centenas;

        unidades=n%10;
        decenas=(n/10)%10;
        centenas=(n/100)%10;

        suma=(int)Math.pow(unidades,3)+(int)Math.pow(decenas,3)+(int)Math.pow(centenas,3);
        
        if(suma==n){
            System.out.println("\nSu número es un número de Armstrong.");
        } else{
            System.out.println("\nSu número no es un número de Armstrong.");
        }
    }
}
