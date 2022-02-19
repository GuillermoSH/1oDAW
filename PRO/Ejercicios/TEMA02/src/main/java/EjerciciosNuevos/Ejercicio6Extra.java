/**
 * Programa que reciba un número y lo descomponga en el producto de sus factores primos
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio6Extra {
    public static void factorizar(int num){
        int aux=2;

        while(num!=1){
            while(num%aux==0){
                System.out.println(aux);
                num/=aux;
            }
            aux++;
        }
    }
    public static void main(String args[]){
        Scanner tec=new Scanner(System.in);
        System.out.print("Introduce el número que quiere descomponer: ");
        int num=tec.nextInt();
        tec.close();

        factorizar(num);
    }
}
