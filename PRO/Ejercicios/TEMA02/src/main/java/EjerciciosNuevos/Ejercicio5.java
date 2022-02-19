/**
 * Programa que reciba un numero, n, y muestre las tablas de multiplicar del 2 hasta n
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio5 {
    public static void main(String []args){
        System.out.println("Introduce el número máx que quiere calcular de la tabla de multiplicar del 2: ");
        Scanner tec=new Scanner(System.in);
        int n=tec.nextInt();
        tec.close();

        System.out.println("\nTabla de multiplicar del 2:");
        for(int i=1;i<=n;i++){
            int resultado=i*2;

            System.out.print(""+resultado+"  ");
        }
    }
}
