/**
 * Programa que genere un número aleatorio entre [1,100] y le dé al suario la oportunidad de adivinarlo en 7 intentos
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio15 {
    public static void main(String args[]){
        /*
        a=0
        b=1
        
        [0,1) --> [1,100] = [1,101)
        
        a*0+b=1 --> b=1
        a*1+b=101 --> a+b=101 --> a=101-1 = 100
        */
        int aleatorio=(int)(100*Math.random()+1),intentos=7,n;
        
        Scanner tec=new Scanner(System.in);
        
        do{
            System.out.print("Introduzca un número: ");
            n=tec.nextInt();

            if(n==aleatorio){
                System.out.println("Felicidades, has acertado el número.");
                System.exit(1);
            } else{
                if(aleatorio<n){
                    intentos--;
                    System.out.println("El número es menor, te quedan "+intentos+" intentos.");
                } else if(aleatorio>n){
                    intentos--;
                    System.out.println("El número es mayor, te quedan "+intentos+" intentos.");
                }
            }
        } while(intentos!=0);
        System.out.println("Se te han acabado los intentos :(.");    
        System.exit(1);
    }
}
