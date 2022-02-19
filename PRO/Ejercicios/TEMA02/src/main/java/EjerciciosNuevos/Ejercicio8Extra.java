/**
 * Programa que reciba un número de 3 dígios en decimal y diga los permisos de Linux correspondientes. Ejemplo 755 devolverá rwxr-xr-x
 */
package EjerciciosNuevos;

import java.util.*;

public class Ejercicio8Extra {
    public static String permisos(int num){
        String permisos="";
        int unidades,decenas,centenas;

		unidades=num%10;
		decenas=(num/10)%10;
		centenas=(num/100)%10;

        switch(centenas){
            case 0:
                permisos=permisos+"----"; break;
            case 1:
                permisos=permisos+"--x-"; break;
            case 2:
                permisos=permisos+"-w--"; break;
            case 3:
                permisos=permisos+"-wx-"; break;
            case 4:
                permisos=permisos+"r---"; break;
            case 5: 
                permisos=permisos+"r-x-"; break;
            case 6:
                permisos=permisos+"rw--"; break;
            case 7:
                permisos=permisos+"rwx-"; break;
        }
        switch(decenas){
            case 0:
                permisos=permisos+"---"; break;
            case 1:
                permisos=permisos+"--x"; break;
            case 2:
                permisos=permisos+"-w-"; break;
            case 3:
                permisos=permisos+"-wx"; break;
            case 4:
                permisos=permisos+"r--"; break;
            case 5:
                permisos=permisos+"r-x"; break;
            case 6:
                permisos=permisos+"rw-"; break;
            case 7:
                permisos=permisos+"rwx"; break;
        }
        switch(unidades){
            case 0:
                permisos=permisos+"---"; break;
            case 1:
                permisos=permisos+"--x"; break;
            case 2:
                permisos=permisos+"-w-"; break;
            case 3: 
                permisos=permisos+"-wx"; break;
            case 4:
                permisos=permisos+"r--"; break;
            case 5:
                permisos=permisos+"r-x"; break;
            case 6:
                permisos=permisos+"rw-"; break;
            case 7:
                permisos=permisos+"rwx"; break;
        }
        return permisos;
    }
    public static void main(String args[]){
        Scanner tec=new Scanner(System.in);
        System.out.print("Introduce el número de 3 dígitos de permisos Linux: ");
        int num=tec.nextInt();
        int aux=num;
        tec.close();

        System.out.println("Los permisos del número "+aux+" son: "+permisos(num));
    }
}
