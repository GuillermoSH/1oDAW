import java.util.Scanner;

public class Ejercicio17T2_propio {
    public static String repite(char c,int num){
        String res="";
        
        for(int i=1;i<=num;i++){
            res=res+c;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner tec=new Scanner(System.in);
        //int n=5;
        System.out.println("Introduce el tamaño del rombo: ");
            int num=tec.nextInt();
            tec.close();

        if(num<=1 || num%2==0){
            System.out.println("\nLo siento, necesito un número impar. Adiós!");
            System.exit(1);
        }

        int numEsp=num/2, numAst=1;

        for(;numAst<num;numEsp--,numAst+=2){
            System.out.println(repite(' ',numEsp)+repite('*',numAst)); //triángulo de arriba
        }

        System.out.println(repite('*',num)); //línea central

        for(numAst=num-2,numEsp=1;numAst>0;numEsp++,numAst-=2){
            System.out.println(repite(' ',numEsp)+repite('*',numAst));
        }
    }
}