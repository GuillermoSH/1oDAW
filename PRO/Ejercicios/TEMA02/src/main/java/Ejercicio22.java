/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author daw
 */
public class Ejercicio22 {
    public static long voltear(long n){
        long resultado=0;
        
        while(n>0){
            resultado=resultado+n%10;
            n=n/10;
            if(n>0){
                resultado=resultado*10;
            }
            
        }
        return resultado;
    }
}
