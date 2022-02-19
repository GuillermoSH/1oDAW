import java.util.Scanner;
public class Ejercicio1Extra {
    public static void main(String []args){
        int suma=0, contador=0, n;
        Scanner tec=new Scanner(System.in);
        tec.close();

        do{
            System.out.print("Introduce número (nº negativo cierra programa): ");
            n=tec.nextInt();
            if(n>=0){
                suma+=n;
                contador++;
            }
        } while(n>=0);
        System.out.println("\nLa media es: "+(suma/(double)contador));
    }
}
