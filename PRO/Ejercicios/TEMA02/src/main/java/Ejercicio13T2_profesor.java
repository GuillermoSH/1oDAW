import java.util.Scanner;

public class Ejercicio13T2_profesor{
	public static void main(String[] args) {
		
		Scanner tec=new Scanner(System.in);
		int n=tec.nextInt();
		tec.close();

		int unidades,decenas,centenas;

		unidades=n%10;

		decenas=(n/10)%10;

		centenas=(n/100)%10;

		int suma=(int)(Math.pow(unidades,3)+Math.pow(decenas,3)+Math.pow(centenas,3));

		if(n==suma){

			System.out.println(n+" es un número de Armstrong.");

		} else {

			System.out.println(n+" no es un número de Armstrong.");
		}
	}
}