/**
 * Programa que reciba tres números a,b y c, coeficientes de una ecuación de segundo grado y de sus soluciones (usar try catch)
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio10 {
    public static int leerNumero(int distinto){
        Scanner tec=new Scanner(System.in);
        int n;

        do{
            System.out.println("Introduce un número distinto de "+distinto+" para darte la solución.");
            System.out.print("a = ");
            n=tec.nextInt();
        } while(n==distinto);
            tec.close();
            return n;
    }
    public static void main(String args[]){
        Scanner tec=new Scanner(System.in);
        System.out.println("Introduce los valores de a, b y c: ");
        
        int a,b,c;
        
        a=leerNumero(0);

        System.out.print("b = ");
        b=tec.nextInt();
        
        System.out.print("c = ");
        tec.nextLine();
        c=tec.nextInt();
        tec.close();

        double d=b*b-4*a*c;

        if(d<0){
            System.out.println("La ecuación no tiene solución real.");
            System.exit(1);
        } else if(d==0){
            System.out.println("Solo tiene una solución y es: "+(-b/(2*a)));
        } else{
            double x1=(-b+Math.sqrt(d))/(2*a);
            double x2=(-b-Math.sqrt(d))/(2*a);

            System.out.println("Las raices son x1: "+x1+"\nx2: "+x2);
        }

        
    }
}
