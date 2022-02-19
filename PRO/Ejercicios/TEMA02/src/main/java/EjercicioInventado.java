/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author daw
 */

/* realiza un programa que llene la pantalla de caracteres aleatorios (a lo matrix) con el codigo "algo" (32 y 126). 
Puedes hacer un casting con char para convertir un entero en un caracter

[0,1) --> [32,127)

a*0+b=32 --> b=32
a*1+b=127 --> a=127-32= 95

95*Math.random()+32
*/

public class EjercicioInventado {
    public static void main(String []args){  
        int numero;
        for(;;){
            //numero=(int)(32*Math.random()+127);
            numero=(int)(95*Math.random()+32);
            char caracter=(char)numero;
            System.out.print(caracter);
            
        }
    }
}
