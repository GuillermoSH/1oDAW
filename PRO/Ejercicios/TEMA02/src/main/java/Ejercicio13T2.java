import java.util.Scanner;

public class Ejercicio13T2{
	public static void main(String[] args) {
		
		Scanner tec=new Scanner(System.in);

		System.out.println("Introduzca el número de 3 DÍGITOS que quiere comprobar: ");

		int n=tec.nextInt(), res=0, a, ntemp;
		tec.close();

		ntemp=n;

		while(n!=0){
			a=n%10;
			res=res+(a*a*a);
			n=n/10;
		}

		if(res==ntemp){
			System.out.println(ntemp+ " es un número de Armstrong.");
		} else{
			System.out.println(ntemp+ " no es un número de Armstrong.");
		}
	}
}
