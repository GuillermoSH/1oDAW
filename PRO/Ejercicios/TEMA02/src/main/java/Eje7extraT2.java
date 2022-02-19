import java.util.Scanner;

public class Eje7extraT2{
    public static void main(String args[]) {
        int decimal,aux,i=1,j;
        int binario[]=new int[100];
        
        Scanner tec=new Scanner(System.in);
		tec.close();

        System.out.print("Introduzca el número decimal: ");
            decimal=tec.nextInt();
		
        aux=decimal;
		
        while(aux!=0) {
            binario[i++]=aux%2;
            aux=aux/2;
        }
		
        System.out.print("\nEl numero binario de "+decimal+" es: ");
        
        for(j=i-1;j>0;j--) {
            System.out.print(binario[j]);
        }
        
        System.out.print("\n");
    }
}