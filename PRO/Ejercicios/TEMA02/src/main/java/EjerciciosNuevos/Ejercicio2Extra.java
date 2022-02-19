/**
 * Método (función) que reciba un número entero positivo n y diga si es capicúa (que coincida el número del derecho y del revés). Por ejemplo 34543
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio2Extra {
    public static boolean capicua(int numero){
		int faltante=numero,restante,numInvertido=0;
        
		while(faltante!=0){
			restante=faltante%10;
			numInvertido=numInvertido*10+restante;
			faltante=faltante/10;
		}

		if(numInvertido==numero){
			return true;
		} else{
			return false;
		}
	}
	public static void main(String args[]){
		Scanner tec=new Scanner(System.in);
		System.out.print("\nIntroduce el número que quiere comprobar: ");
		int numero=tec.nextInt();
        tec.close();

		if(capicua(numero)==true){
			System.out.println("\nSu número "+numero+" es capicúa.");
		} else{
			System.out.println("\nSu número "+numero+" no es capicúa.");
		}
	}
}
