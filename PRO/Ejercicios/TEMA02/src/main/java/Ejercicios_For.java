public class Ejercicios_For{
	public static void main(String args[]){
		/*Se puede declarar la i como 'int i;' antes del bucle para que no solo 
		este dentro del mismo*/ 
		
		int i1,n=15;
		for(i1=2;i1<=100;i1+=2){ /*Se puede declarar la variable dentro del for 
		para solo tenerlo cuando se ejecute el bucle poniendo int antes de las 
		condiciones del for*/
			System.out.println(i1);
		}

		int i2;
		for(i2=5;i2<=n;i2+=5){
			System.out.println(i2);
		}

	}
}

