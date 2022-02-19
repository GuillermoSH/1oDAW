public class Ejercicio07T2CorrecciónProfesor{
	public static void main(String args[]){
	
	double base=Double.parseDouble(args[0]);
	int exponente=Integer.parseInt(args[1]);
	double resultado;
        resultado=base;

		System.out.println("Base: "+base+"Exponente: "+exponente);

	for(int i=2;i<=exponente;i++){
		resultado*=base;
	}

		System.out.println("La potencia sera igual a: "+resultado);

	}
	
}