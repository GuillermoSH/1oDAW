/**
* Programa que reciba tres números y diga cuál es el menor y el mayor
*/
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio1{
    public static void main(String args[]){
        Scanner tec=new Scanner(System.in);

        System.out.println("Introduzca 3 números: ");
        int n1=tec.nextInt();
        int n2=tec.nextInt();
        int n3=tec.nextInt();
        tec.close();

        if(n1>n2 && n1>n3){
            System.out.println("\n"+n1+" es el número mayor.");
        } else if(n2>n1 && n2>n3){
            System.out.println("\n"+n2+" es el número mayor.");
        } else{
            System.out.println("\n"+n3+" es el número mayor.");
        }

        if(n1<n2 && n1<n3){
            System.out.println("\n"+n1+" es el número menor.");
        } else if(n2<n1 && n2<n3){
            System.out.println("\n"+n2+" es el número menor.");
        } else{
            System.out.println("\n"+n3+" es el número menor.");
        }        
    }
}