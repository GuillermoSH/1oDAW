public class Ejercicio2T2{
	public static void main(String args[]){
		int aleatorio=(int)(101*Math.random()+100);
			System.out.println("El número generado es:");
		/* 
           [0,1) ---> [100,201)

		   0 ----> 100   a*0+b=100 --> b=100
		   1 ----> 201   a*1+b=201 --> a+b=201 --> a+100=201 --> a=101
		   
		   a*Math.random()+b
		   101*Math.random()+100
		*/

		if(aleatorio%2==0){
			System.out.println("Es par");
		} else {
			System.out.println("Es impar");
		}

	}
}