/**
 * Programa que pida números al usuario hasta que el usuario introduzca 0 y dé la suma de todos los números introducidos
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio3Extra {
    public static void main(String args[]){
        int numero,suma=0;

        do{
            System.out.print("Introduce un número a sumar (el 0 cierra el programa): ");
            Scanner tec=new Scanner(System.in);
            numero=tec.nextInt();

            suma+=numero;
        } while(numero!=0);
            System.out.println("La suma de los números es: "+suma);
            System.exit(1);
    }
}
