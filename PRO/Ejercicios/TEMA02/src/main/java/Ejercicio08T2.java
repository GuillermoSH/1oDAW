public class Ejercicio08T2{
	public static void main(String[] args) {
		int n=Integer.parseInt(args[0]);

		while(n>=1 || n<=-1){
			n=n/10;
			//Integer.toString(variable).lenght()
		}
	}
} 

/* 

caso de un entero hecho por if

if(n<10){                             2**31-1=numero max en un int = 2147483647
	digitos=1;                        2**64-1=numero max en un long = 1.8446744e+19
} else if(n<100){
	digitos=2;
} else if(n<1000){
	digitos=3;
} else if(n<10000){
	digitos=4;
} else if(n<100000){
	digitos=5;
} else if(n<1000000){
	digitos=6;
} else if(n<10000000){
	digitos=7;
} else if(n<100000000){
	digitos=8;
} else if(n<1000000000){
	digitos=9;
} else if(n<10000000000){
	digitos=10;
}

*/