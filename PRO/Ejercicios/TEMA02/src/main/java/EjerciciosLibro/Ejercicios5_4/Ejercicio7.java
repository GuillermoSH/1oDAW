/**
 * Realiza el control de acceso a una caja fuerte. La combinación será un
 * número de 4 cifras. El programa nos pedirá la cmbinación para abrirla. Si no
 * acertamos, se nos mostrará un mensaje "Lo siento, esa no es la combinación"
 * y si acertamos se nos dirá "La caja fuerte se ha abierto satisfactoriamente".
 * Tendremos cuatro oportunidades para abrir la caja fuerte.
 */
package EjerciciosLibro.Ejercicios5_4;

import java.util.*;

public class Ejercicio7 {
    public static void main(String args[]){
        int intentos=4;
        int primerNum=(int)(99*Math.random()+1);
        int segundoNum=(int)(99*Math.random()+1);
        int tercerNum=(int)(99*Math.random()+1);
        int cuartoNum=(int)(99*Math.random()+1);
        
        Scanner tec=new Scanner(System.in);

        do{
            --intentos;

            System.out.print("Primer dígito: ");
            int num1=tec.nextInt();
            System.out.print("Segundo dígito: ");
            int num2=tec.nextInt();
            System.out.print("Tercer dígito: ");
            int num3=tec.nextInt();
            System.out.print("Cuarto dígito: ");
            int num4=tec.nextInt();
            
            if(primerNum==num1 && segundoNum==num2 && tercerNum==num3 && cuartoNum==num4){
                System.out.println("\nLa caja fuerte se ha abierto satisfactoriamente.");
                System.exit(2);
            } else{
                System.out.println("\nLo siento, esa no es la combinación.");
                System.out.println("\nTe quedan "+intentos+" intentos.");
                System.out.println("\n");
            }
            
        } while(intentos!=0);
            System.out.println("\nSe te han acabado los intentos :'(.");
            System.exit(1);
    }
}
