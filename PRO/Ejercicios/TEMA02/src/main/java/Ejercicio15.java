/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author daw
 */
import java.util.Scanner;

public class Ejercicio15{
	public static void main(String args[]){
        
		Scanner teclado=new Scanner(System.in);

        int na1, na2, n1, n2, intentos=7;

        	na1=(int)(100*Math.random()+1);

        do{
            na2=(int)(100*Math.random()+1);
        }while(na2!=na1);

        do{
            
            System.out.println("Introduce n1: ");
            	n1=teclado.nextInt();
            
            System.out.println("Introduce n2: ");
            	n2=teclado.nextInt();
                teclado.close();
        
            if(n1==na1 && n2==na2 || n1==na2 && n2==na1) {
                System.out.println("\nEnhorabuena, acertaste!");
                break;
            
            } else {
                intentos--;
                System.out.println("\nLo siento :'(. Prueba de nuevo!\n");
                System.out.println("Te quedan "+intentos+" intentos.\n");
            }
        } while(intentos>0);
        	
        if (intentos==0) {
            	System.out.println("\nLo siento has agotado todos los intentos.");
        }
    }
}