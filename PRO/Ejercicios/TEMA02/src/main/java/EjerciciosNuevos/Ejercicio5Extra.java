/**
 * Método que reciba dos números enteros y devuelva el máximo común divisor
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio5Extra {
    public static int maxComDiv(int num1, int num2){
		int aux; //auxiliar para no perder el num2

		while(num2!=0){
			aux=num2;
			num2=num1%num2;
			num1=aux;
		}
		return num1;
	}

    public static void main(String args[]){
        Scanner tec=new Scanner(System.in);
        System.out.print("Introduce el primer número: ");
        int num1=tec.nextInt();

        System.out.print("Introduce el segundo número: ");
        int num2=tec.nextInt();
        tec.close();
        
        System.out.println("El mínimo común múltiplo será: "+maxComDiv(num1,num2));
    }
}
