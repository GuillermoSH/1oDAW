import java.util.Scanner;

public class Ejercicio14T2{
	public static void main(String[] args) {

		Scanner tec=new Scanner(System.in);

		System.out.println("Introduce la cantidad de dígitos que quiere ver de la sucesión de Fibonacci: ");
		int n=tec.nextInt();
		tec.close();
		System.out.println("\n\n");

		int res=0,n1=1;

		for(int i=0;i<n;i++){
		
			System.out.println(res+"");
			int n2=res+n1;
			res=n1;
			n1=n2;
		}
	}
}