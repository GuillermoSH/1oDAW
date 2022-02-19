/**
 * Programa que reciba un día, mes y año y diga si la fechaes correcta (hay que tener en cuenta si el año es bisiesto)
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio21 {
    public static boolean esBisiesto(int anio){
        return (anio%4==0 && anio%100!=0 || anio%100==0 && anio%400==0);
    }
    public static int dias(int mes,int anio){
        int maxDia;

        switch(mes){
            case 4: case 6: case 9: case 11:
                maxDia=30;
                break;
            case 2:
                if(esBisiesto(anio)){
                    maxDia=29;
                } else{
                    maxDia=28;
                } break;
            default : maxDia=31;
        }
        return maxDia;
    }
    public static void main(String args[]){
        Scanner tec=new Scanner(System.in);
        System.out.println("Introduce la fecha completa que quiere verificar");
        System.out.print("    Día: ");
        int dia=tec.nextInt();
        System.out.print("    Mes: ");
        int mes=tec.nextInt();
        System.out.print("    Año: ");
        int anio=tec.nextInt();
        tec.close();

        if(mes<1 || mes>12){
            System.out.println("\nEl mes no es correcto, lo siento.");
            System.exit(1);
        }
        int maxDia=dias(mes,anio);
        if(dia<1 || dia>maxDia){
            System.out.println("\nError en día, el mes "+mes+" no puede tener como día: "+dia);
            System.exit(2);
        }
        System.out.println("\nLa fecha es correcta!!");
    }
}
