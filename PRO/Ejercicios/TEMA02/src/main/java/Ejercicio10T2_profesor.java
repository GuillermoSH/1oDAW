public class Ejercicio10T2_profesor{
	public static int leeNumero(int distinto){ //función para darle intentos al usuario en caso de escribir 0 en el valor de a

		java.util.Scanner teclado=new java.util.Scanner(System.in);

		int n;

		do{
			
			System.out.println("Introduce un número distinto de "+distinto+" para el valor de a:");
			n=teclado.nextInt();

		} while(n==distinto);
		teclado.close();

		return n;
	}
	
	public static void main(String[] args) {
		
		java.util.Scanner teclado=new java.util.Scanner(System.in);
		
		int a,b,c;

			a=leeNumero(0);

			System.out.println("Introduce b: ");
			b=teclado.nextInt();

			System.out.println("Introduce c: ");
			c=teclado.nextInt();
			teclado.close();

			double d=b*b-4*a*c;

			if(d<0){

				System.out.println("La ecuación no tiene solución real.");
				System.exit(1);

			} else if(d==0){

				System.out.println("Sólo hay una solución y es: "+(-b/(2*a)));
			
			} else{

				double x1=(-b+Math.sqrt(d))/(2*a);
				double x2=(-b-Math.sqrt(d))/(2*a);

				System.out.println("Las raices serán x1: "+x1+" y x2: "+x2);
			}

		
	}
}