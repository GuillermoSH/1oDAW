public class Ejercicio5T2{
	public static void main(String args[]){
		
		int n=Integer.parseInt(args[0]);
		int i;

		for(i=2;i<=n;i++){
			System.out.println("Tabla del "+i);
			for(int j=1;j<=10;j++){
				System.out.println(i+" * "+j+" = "+(i*j));
			} System.out.println("-------------------------------");
		}

		// for(i=2;i<=n;i+=2){

	}
		
}
