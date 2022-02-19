/**
 * Programa que reciba una cadena de 9 caracteres representando los permisos de Linuc y devuelve el numero en decimal de 3 dígitos represantando a dichos permisos. Ejemplo: rwr-xr-x debe devolver 755.
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio9Extra {
    public static int permisos(String permisos){
        int num=0;

        String centenas=permisos.substring(0,4);
        String decenas=permisos.substring(4, 7);
        String unidades=permisos.substring(7, 10);
        
        switch(centenas){
            case "----":
                num+=0; break;
            case "--x-":
                num+=1; break;
            case "-w--":
                num+=2; break;
            case "-wx-":
                num+=3; break;
            case "r---":
                num+=4; break;
            case "r-x-": 
                num+=5; break;
            case "rw--":
                num+=6; break;
            case "rwx-":
                num+=7; break;
        }
        switch(decenas){
            case "---":
                num+=0; break;
            case "--x":
                num+=10; break;
            case "-w-":
                num+=20; break;
            case "-wx":
                num+=30; break;
            case "r--":
                num+=40; break;
            case "r-x": 
                num+=50; break;
            case "rw-":
                num+=60; break;
            case "rwx":
                num+=70; break;
        }
        switch(unidades){
            case "---":
                num+=0; break;
            case "--x":
                num+=100; break;
            case "-w-":
                num+=200; break;
            case "-wx":
                num+=300; break;
            case "r--":
                num+=400; break;
            case "r-x": 
                num+=500; break;
            case "rw-":
                num+=600; break;
            case "rwx":
                num+=700; break;
        }
        return num;
    }
    public static void main(String args[]){
        Scanner tec=new Scanner(System.in);
        System.out.println("Introduce la cadena de caracteres de permisos Linux (formato: rwx-rwxrwx): ");
        String permisos=tec.nextLine();
        String aux=permisos;
        tec.close();

        System.out.println("Los permisos "+aux+" serán igual a: "+permisos(permisos));
    }
}
