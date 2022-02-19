/*
Identificar nº primos (sin terminar)
*/
import java.util.Scanner;

public class EsPrimo{
    public static void main(String args[]){
        Scanner tec=new Scanner(System.in);
        
        System.out.print("Introduce el valor a verificar: ");
        int numero=tec.nextInt();
        tec.close();

        Boolean primo=false;
        primo=esPrimo(numero);

        System.out.print("El valor es primo: "+primo);
    }
    /**
     * Función encargada de verificar si un numero es primo
     * @param numero valor a verificar
     * @return true/false
     */
    public static boolean esPrimo(int numero){
        boolean resultado=false;

        for(int i=2;i<numero;i++){
            if((numero%i)==0){
                return false;
            } else{

            }
        }

        return resultado;
    }
}