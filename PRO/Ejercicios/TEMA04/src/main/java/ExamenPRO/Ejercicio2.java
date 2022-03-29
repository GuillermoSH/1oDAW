package ExamenPRO;

import java.util.*;
/**
 * 2) Realiza un método que reciba un número double y un array bidimensional de números double y
 * devuelva un nuevo array en el que todos los elementos del array original quedan multiplicados por
 * el número. (2puntos)
 */
public class Ejercicio2 {
    private double[][] original={{1.0,2.0,3.0},{4.0,5.0,6.0},{7.0,8.0,9.0}};
    private int longitud=original[0].length;

    public double[][] multiplicacion(double[][] original,double numero){
        double[][] multiplicado=new double[longitud][longitud];

        for(int i=0;i<longitud;i++){
            for(int j=0;j<longitud;j++){
                multiplicado[i][j]=original[i][j]*numero;
            }
        }

        return multiplicado;
    }

    public static void main(String args[]){
        Scanner tec=new Scanner(System.in);
        System.out.print("Introduce el número que quiere multiplicar por la matriz: "); // usar la ',' para el decimal
        double numero=tec.nextDouble();
        Ejercicio2 e=new Ejercicio2();
        double res[][]=e.multiplicacion(e.original,numero);

        for(int i=0;i<e.longitud;i++){
            for(int j=0;j<e.longitud;j++){
                System.out.println(res[i][j]);
            }
        }
    }
}
