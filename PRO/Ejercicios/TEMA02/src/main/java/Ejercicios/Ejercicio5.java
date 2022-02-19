/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;
/**
 *
 * @author daw
 */
import java.util.Scanner;
public class Ejercicio5 {
    public static String repite(char c,int num){
        String res="";
        
        for(int i=1;i<=num;i++){
            res=res+c;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner tec=new Scanner(System.in);
        //int n=5;
        System.out.print("Introduce el tamaño del rombo: ");
            int num=tec.nextInt();
            tec.close();

        if(num<=1 || num%2==0){
            System.out.println("\nLo siento, necesito un número impar.");
            System.exit(1);
        }

        int numEsp=num/2, numAst=1;
        char caracter=(char)numAst;

        for(;numAst<num;numEsp--,numAst+=2){
            System.out.println(repite(' ',numEsp)+repite(caracter,numAst)); //triángulo de arriba
        }

        System.out.println(repite(caracter,num)); //línea central

        for(numAst=num-2,numEsp=1;numAst>0;numEsp++,numAst-=2){
            System.out.println(repite(' ',numEsp)+repite(caracter,numAst));
        }
    }
}
