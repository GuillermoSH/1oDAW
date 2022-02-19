package Ejercicio3;

public class Main {
    public static void main(String []args){
        java.util.Scanner tec=new java.util.Scanner(System.in);
        int numero;

        System.out.print("Introduzca el número que quiere operar: ");
        numero=tec.nextInt();
        MiNumero n=new MiNumero(numero);
        tec.close();

        System.out.println("El doble de "+numero+" es "+n.doble()+" el triple es "+n.triple()+" y el cuádruple es "+n.cuadruple());
    }
}
