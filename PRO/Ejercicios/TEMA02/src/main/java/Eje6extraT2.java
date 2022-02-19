import java.util.Scanner;

public class Eje6extraT2 {
     public static int factor(int numero) {
          int num = 2;

          while(numero!=1) {
               while(numero%num==0) {
                    System.out.println(num);
                    numero /= num;
                    num++;
               }
          }
          return numero;
     }

     public static void main (String []args) {
          Scanner objEntrada = new Scanner(System.in);
          //int numero=132;
          System.out.println("Escribe un numero para sacar sus factores primos");
               int numero = objEntrada.nextInt();
          
          System.out.println(factor(numero));
          objEntrada.close();
     }
}