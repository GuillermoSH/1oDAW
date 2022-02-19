/**
 * Programa que reciba un valor, n, en minutos, diga la hora actual y a partir de ese momento cuando la hora termine en n o múltiplo de n vuelva a decir la hora,
 * y así hasta el infinito
 */
package EjerciciosNuevos;

import java.util.*;
//import java.time.*;

public class Ejercicio18 {
    public static void main(String args[]){
        Scanner tec=new Scanner(System.in);
        System.out.print("Introduce un número que quiere mostrar: ");
        int n=tec.nextInt();

        Calendar calendario=new GregorianCalendar();
        int horas=calendario.get(Calendar.HOUR_OF_DAY);
        int minutos=calendario.get(Calendar.MINUTE);
        int segundos=calendario.get(Calendar.SECOND);

        /*
        LocalTime horaLocal=LocalTime.now();
        int horas=horaLocal.getHour();
        int minutos=horaLocal.getMinute();
        int segundos=horaLocal.getSecond();
        */
        System.out.println("Hora actual: "+horas+":"+minutos+":"+segundos+"\n");

        for(;;){
            int unidadMinutos=minutos-(minutos%10/10);
            
            if(minutos%n==0 || unidadMinutos==n){
                System.out.println(""+horas+":"+minutos+"");
            }
            minutos++;
            
            if(minutos==60){
                minutos=0;
                horas++;
            } 
            if(horas==24){
                horas=0;
            }
        }
    }
}
