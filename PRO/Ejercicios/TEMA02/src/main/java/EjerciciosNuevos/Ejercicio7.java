/**
 * Programa que reciba dos números y calcule la potencia del primero elevado al segundo
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio7 {
    public static void main(String args[]){
        Scanner tec=new Scanner(System.in);
        
        System.out.print("Introduzca la base de la potencia: ");
        int base=tec.nextInt();
        
        System.out.print("\nIntroduzca el exponente de la potencia: ");
        tec.nextLine();
        int exponente=tec.nextInt();
        tec.close();

        int aux=base;
        
        for(int i=1;i<exponente;i++){
            aux*=base;
        }

        System.out.println("La potencia de "+base+" es igual a: "+aux);
    }
}
