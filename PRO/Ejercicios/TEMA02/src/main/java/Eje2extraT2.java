import java.util.*;

public class Eje2extraT2{
	public static boolean capicua(int numero){
		int faltante=numero,restante,numInvertido=0;

		while(faltante!=0){
			restante=faltante%10;
			numInvertido=numInvertido*10+restante;
			faltante=faltante/10;
		}

		if(numInvertido==numero){
			return true;
		} else{
			return false;
		}
	}
	public static void main(String args[]){
		Scanner tec=new Scanner(System.in);
		System.out.print("\nIntroduce el número que quiere comprobar: ");
		int numero=tec.nextInt();

		if(capicua(numero)==true){
			System.out.println("\nSu número "+numero+" es capicúa.");
		} else{
			System.out.println("\nSu número "+numero+" no es capicúa.");
		}
	}
}