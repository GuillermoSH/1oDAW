/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

/**
 *
 * @author daw
 */
public class Ejercicio2 {
    public static void main(String []args){
        System.out.println("Introduzca el número de la operación que quiere realizar:");
        System.out.println("1) Pasar de Fahrenheit a Celsius.");
        System.out.println("2) 2) Pasar de Celsius a Fahrenheit.");
        System.out.println("3) Salir.");
        java.util.Scanner tec=new java.util.Scanner(System.in);
        int operacion=tec.nextInt();
        
        /*do{
            if(operacion==1){
                System.out.print("Introduzca la temperatura en Celsius: ");
                java.util.Scanner tec1=new java.util.Scanner(System.in);
                double celsius=tec1.nextDouble();
                tec1.close();
                double fahrenheit=(celsius-32)/1.8;
                
                System.out.println("Su temperatura de "+celsius+" celsius serán "+fahrenheit+" fahrenheit");
            } else if(operacion==2){
                System.out.print("Introduzca la temperatura en Fahrenheit: ");
                java.util.Scanner tec1=new java.util.Scanner(System.in);
                double fahrenheit=tec1.nextDouble();
                tec1.close();
                double celsius=(fahrenheit*1.8)+32;
                
                System.out.println("Su temperatura de "+fahrenheit+" fahrenheit serán "+celsius+" celsius");
            }
        } while(operacion!=3);
            System.exit(1);
        */
        if(operacion==1){
            System.out.print("Introduzca la temperatura en Celsius: ");
            tec.nextLine();
            double celsius=tec.nextDouble();
            double fahrenheit=(celsius-32)/1.8;
                
            System.out.println("Su temperatura de "+celsius+" celsius serán "+fahrenheit+" fahrenheit");
        } else if(operacion==2){
            System.out.print("Introduzca la temperatura en Fahrenheit: ");
            tec.nextLine();
            double fahrenheit=tec.nextDouble();
            double celsius=(fahrenheit*1.8)+32;
                
            System.out.println("Su temperatura de "+fahrenheit+" fahrenheit serán "+celsius+" celsius");
        } else{
            System.exit(1);
        } tec.close();
    }
}
