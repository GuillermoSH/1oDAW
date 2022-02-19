/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicios;
/**
 *
 * @author daw
 */
//import java.util.Scanner;
public class Ejercicio1 {
    public static int sumaNum(int n1,int n2){
        int suma=0;
        do{
            suma+=n1;
            n1++;
        } while(n1<=n2);
            return suma;
    }
    public static int productoNum(int n1, int n2){
        int producto=n1;
        do{
            producto*=n1;
            n1++;
        } while(n1<=n2);
            return producto;
    }
    public static double mediaNum(int n1, int n2){
        int cantidadNum=(n2-n1)+1;
        double media=(double)sumaNum(n1,n2)/cantidadNum;
        
        return media;
    }
    public static void main(String []args){
        //int n1,n2;
        int n1=1,n2=4;
        
        /*Scanner tec=new Scanner(System.in);
        System.out.print("Introduzca su primer número: ");
        n1=tec.nextInt();
        
        System.out.print("\nIntroduzca su segundo número: ");
        tec.nextInt();
        n2=tec.nextInt();
        tec.close();
        */
        System.out.println("La suma es igual a: "+sumaNum(n1,n2));
        System.out.println("El producto es igual a: "+productoNum(n1,n2));
        System.out.println("La media es igual a: "+mediaNum(n1,n2));
    }
}
