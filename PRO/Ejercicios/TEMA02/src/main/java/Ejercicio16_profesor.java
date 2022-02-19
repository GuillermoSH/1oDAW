/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author daw
 */
public class Ejercicio16_profesor {
    public static int sumaCifras(int n){
        int suma=0;
        while(n>0){
            suma+=n%10; //sumar el dígito de la derecha
            n/=10; //desplazar el número un lugar a la derecha
        } return suma;
    }
    public static void main(String []args){
        int dia=Integer.parseInt(args[0]);
        //int mes=Integer.parseInt(args[1]);
        int anio=Integer.parseInt(args[2]);
        int suma=dia+anio;
        
        while(suma>9){
            suma=sumaCifras(suma);
        }
        System.out.println("El lucky number es: "+suma);
    }
}
