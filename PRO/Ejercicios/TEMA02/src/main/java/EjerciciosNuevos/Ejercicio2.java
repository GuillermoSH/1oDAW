/**
* Programa que genere un número aleatorio entre [100,200] e imprima el número y diga si es par o impar
*/
package EjerciciosNuevos;

public class Ejercicio2 {
    /*
    a=0
    b=1
    
    [0,1) --> [100,200] = [100,201)
    
    a*0+b=100 --> b=100
    a*1+b=201 --> a+b=201 --> a=201-100 = 101
    */
    public static void main(String []args){
        int numAleatorio=(int)(101*Math.random()+100);
        String parImpar;

        if(numAleatorio%2==0){
            parImpar="par";
        } else{
            parImpar="impar";
        }
        System.out.println("Su número generado es "+numAleatorio+" y éste es "+parImpar+".");
    }
}
