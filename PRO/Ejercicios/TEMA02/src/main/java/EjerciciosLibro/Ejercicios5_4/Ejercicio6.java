/**
 * Muestra los números del 320 al 160, contando de 20 en 20 hacia atrás utilizando un bucle do-while.
 */
package EjerciciosLibro.Ejercicios5_4;

public class Ejercicio6 {
    public static void main(String args[]){
        int i=320;
        do{
            System.out.println(i);
            i-=20;
        } while(i>=160);
            System.exit(1);
    }
}