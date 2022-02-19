public class Eje4extraT2{
	public static int maxComDiv(int num1, int num2){
		int aux; //auxiliar para no perder el num2

		while(num2!=0){
			aux=num2;
			num2=num1%num2;
			num1=aux;
		}
		return num1;
	}

	public static int minComMul(int num1, int num2){
		return (num1*num2)/maxComDiv(num1,num2);
	}
}