package Ejercicio2;
import java.util.Scanner;
public class Main {
    public static void main(String []args){
        Scanner tec=new Scanner(System.in);
        double numero;

        System.out.print("Introduzca la cantidad de dolares que quiere convertir: ");
        numero=tec.nextDouble();
        Finanzas f1=new Finanzas();
        Finanzas f2=new Finanzas(0.92);
        tec.close();

        //System.out.println("Su cantidad de dinero ("+numero+") será igual a "+f1.eurosToDolares()+" euros y "+f1.eurosToDolares()+" dolares.");
    }
    
    
}
