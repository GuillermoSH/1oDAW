/**
 * Programa que reciba un número en base 10 y lo muestre en base 2
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio7Extra {
    public static int conversor(int num){
        int residuo;
        String binario="";

        while(num!=0){
            residuo=num%2; //digito en binario siendo el resto de la division
            binario=residuo+binario; //concatenado de los digitos
            num/=2; //division entera para pasar al siguiente digito
        }
        return Integer.parseInt(binario);
    }

    public static void main(String args[]){
        Scanner tec=new Scanner(System.in);
        System.out.print("Introduce el número que quiere convertir a binario: ");
        int num=tec.nextInt();
        tec.close();
        int aux=num;

        System.out.println("El número "+aux+" en decimal es igual a "+conversor(num)+" en binario.");
    }
}
