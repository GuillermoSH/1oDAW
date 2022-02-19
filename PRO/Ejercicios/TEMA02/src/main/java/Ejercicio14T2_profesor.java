public class Ejercicio14T2_profesor{
	public static void main(String[] args) {
		
		int n=5;
		int i;
		int serie1=0, serie2=1;

		for(i=2;i<=n;i++){
			serie2=serie1+serie2;
			serie1=serie2-serie1;
			System.out.println(serie2);
		}

		int t2=0;
		for(i=1;i<=n;i++){
			System.out.println(t2);
		}
	}
}