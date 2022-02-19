public class Ejercicio07T2{
	public static void main(String args[]){
	
	int base=0;
	int exponente=0;
	long resultado=0;
        resultado=base;

		System.out.println("Base: "+base+"Exponente: "+exponente);

	while(exponente-->1){
		resultado*=base;
	}
	//while(exponente>1){
	//	resultado*=base;
	//	exponente--;
	//}
		System.out.println("La potencia sera igual a: "+resultado);
	}
	public static void main2(String args[]){ //en cuanto pongas un caracter al lado de main anulas esta clase
		double base=Double.parseDouble(args[0]);
		double resultado=0;
                int exponente=Integer.parseInt(args[1]);
		//Math.pow(x,y) es la función de calculo de potencias
		for(int i=1;i<=exponente;i++){
			resultado=resultado*base;
		}
	}
}