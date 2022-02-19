/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;

/**
 *
 * @author daw
 */
public class Ejercicio4 {
    public static void main(String []args){
        
        System.out.print("Introduzca el numero de filas que quiere representar en la tabla: ");
        java.util.Scanner tec=new java.util.Scanner(System.in);
        int filas=tec.nextInt();
        tec.close();
        
        /*se deberia declarar un numero compuesto de tipo string con dos numeros aleatorios
        comprendidos entre 0 y 10 el ultimo abierto para generar una nota para cada alumno
        
        Supuesto: nota=(10*Math.random()+0).(10*Math.random()+0); 
        
        otra opcion seria en el print poner el numero aleatorio generado:
        
        System.out.println(numAle1+"."+numAle2);
        */
        
        System.out.println("\nListado de Notas Alumnos 1DAW:");
        System.out.println("|---------------------|");
        System.out.println("| Alumno   Nº  | Nota |");
        for(int i=1;i<=filas;i++){
            int numAle1=(int)(10*Math.random()+0);
            int numAle2=(int)(10*Math.random()+0);
            System.out.println("|---------------------|");
            if(i<10){
                System.out.println("| Alumno    "+i+"  |  "+numAle1+"."+numAle2+" |");
            } else if(i<100){
                System.out.println("| Alumno   "+i+"  |  "+numAle1+"."+numAle2+" |");
            } else if(i<1000){
                System.out.println("| Alumno  "+i+"  |  "+numAle1+"."+numAle2+" |");
            }
        }
        System.out.println("|---------------------|");
    }
}
