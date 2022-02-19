/**
 * Ídem con el producto
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio4 {
    public static void main(String []args){
        int producto=1;

        System.out.println("Introduce el número n del intervalo [1,n]: ");
        Scanner tec=new Scanner(System.in);
        int n=tec.nextInt();
        tec.close();

        for(int i=1;i<=n;i++){
            producto*=i;
        }

        System.out.println("El producto de los números comprendidos en el intervalo es de: "+producto);
    }
}
