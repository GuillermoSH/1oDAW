/**
 * Método (función) que calcule la hipotenusa de un triángulo rectángulo
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio1Extra {
    public static double calculoHipotenusa(double cateto1, double cateto2, double hipotenusa){
        return hipotenusa=Math.sqrt(Math.pow(cateto1,2)+Math.pow(cateto2,2));
    }

    public static void main(String args[]){
        Scanner tec=new Scanner(System.in);
        System.out.print("\nIntroduce el cateto contiguo: ");
        double cateto1=tec.nextDouble();

        System.out.print("\nIntroduce el cateto opuesto: ");
        double cateto2=tec.nextDouble();
        tec.close();
        
        double hipotenusa=0;

        System.out.println("\nLa hipotenusa es igual a: "+calculoHipotenusa(cateto1, cateto2, hipotenusa));
    }
}
