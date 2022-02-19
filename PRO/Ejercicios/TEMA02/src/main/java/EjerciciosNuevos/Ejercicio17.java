/**
 * Programa que reciba un número impar, n, e imprima un rombo de caracteres '*' de diagonal n
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio17 {
    /**
     * Función encargada de dar el número de caracteres que va a llevar la línea, sean espacios o caracteres
     * @param c tipo de carácter que se va a representar en la línea de comandos
     * @param num número dado por el usuario para la altura del rombo
     * @return número de espacios o asteriscos
     */
    public static String repite(char c,int num){
        String res="";
        
        for(int i=1;i<=num;i++){
            res=res+c;
        }
        return res;
    }
    public static void main(String args[]){
        System.out.print("Introduce el número de la altura del rombo: ");
        Scanner tec=new Scanner(System.in);
        int n=tec.nextInt();
        tec.close();

        if(n<=1 || n%2==0){
            System.out.println("\nLo siento, necesito un número impar. Adiós!");
            System.exit(1);
        }

        int numEsp=n/2, numAst=1;

        for(;numAst<n;numEsp--,numAst+=2){
            System.out.println(repite(' ',numEsp)+repite('*',numAst)); //triángulo de arriba
        }

        System.out.println(repite('*',n)); //línea central

        for(numAst=n-2,numEsp=1;numAst>0;numEsp++,numAst-=2){
            System.out.println(repite(' ',numEsp)+repite('*',numAst)); //triángulo de abajo 
        }
    }
}
