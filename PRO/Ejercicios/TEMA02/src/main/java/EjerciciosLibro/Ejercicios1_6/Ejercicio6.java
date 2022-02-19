/*
Escribe un programa que pinte por pantalla una pirámide rellena a base de 
asteriscos. La base de la pirámide debe estar formada por 9 asteriscos
*/

package EjerciciosLibro.Ejercicios1_6;

public class Ejercicio6 {
    public static void main(String args[]){
        System.out.printf("\n%-4s %-1s %-4s", "", "*", "");
        System.out.printf("\n%-3s %-3s %-3s", "", "***", "");
        System.out.printf("\n%-2s %-5s %-2s", "", "*****", "");
        System.out.printf("\n%-1s %-7s %-1s", "", "*******", "");
        System.out.printf("\n *********\n");
    }
}
