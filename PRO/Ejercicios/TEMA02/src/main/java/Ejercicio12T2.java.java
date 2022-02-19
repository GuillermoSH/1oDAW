/*public class Ejercicio12T2.java {
    public static boolean esPrimo(int n){
		
	for(int i=2;i<n;i++){
            if (n%i==0){
		return false;
            } else {
		return true;
            } 
	}
    }
    //programa que imprima tantos numeros primos como el usuario pase por linea de comandos
    public static void main(String args[]){
        //int n=5;
        int n=Integer.parseInt(args[0]);
	int cuenta=0;
		
        for(int i=2;cuenta<n;i++){
            if(esPrimo(i)){
                System.out.println(i);
                cuenta++;
            }
			
        }
    }
}*/