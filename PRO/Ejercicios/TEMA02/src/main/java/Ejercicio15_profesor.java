/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author daw
 */
public class Ejercicio15_profesor {
    public static void main(String[] args) {
        java.util.Scanner teclado=new java.util.Scanner(System.in);
        
        int n=(int)(100*Math.random()+1);
        int numero, intentos=7;
        
        do{
            System.out.println("Introduce el número: ");
            numero=teclado.nextInt();
            teclado.close();
            if(numero==n){
                System.out.println("\nFelicidades!!!");
                System.exit(0);
            } else if(n>numero){
                System.out.println("\nEl número es mayor, intenta otra vez.");
            } else{
                System.out.println("\nEl número es menor, intenta otra vez");
            }
            intentos--;
            System.out.println("Te quedan "+intentos+" intentos");
            
        }while(intentos>0);
        	
        if (intentos==0) {
            	System.out.println("\nLo siento has agotado todos los intentos.");
        }
    }
    
}
