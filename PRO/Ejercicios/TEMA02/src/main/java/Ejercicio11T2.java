import java.util.Scanner;

public class Ejercicio11T2 {
	
	public static int leeNumero(int dis){ //función para darle intentos al usuario en caso de escribir 0 en el valor de a

		Scanner tec=new Scanner(System.in);

		int n;

		do{
			
			System.out.print("\nIntroduce un numero entre 1 y 3999 inclusive: ");
			n=tec.nextInt();

		} while(n==dis);
		tec.close();
		return n;
	}

	public static void main(String args[]){
		
		int input=leeNumero(0);
		
		while(input < 1 || input > 3999){
			System.out.println("\n#Error: valor de número romano inválido.");
			break;
		}
		if(input>=1 && input<=3999){
		    String n="";
		
		    while (input >= 1000) {
        		n += "M";
       			input -= 1000;        
		    }
    		while (input >= 900) {
        		n += "CM";
      		  	input -= 900;
    		}
    		while (input >= 500) {
        		n += "D";
        		input -= 500;
    		}
    		while (input >= 400) {
        		n += "CD";
        		input -= 400;
    		}
    		while (input >= 100) {
        		n += "C";
        		input -= 100;
    		}
    		while (input >= 90) {
        		n += "XC";
        		input -= 90;
    		}
    		while (input >= 50) {
        		n += "L";
        		input -= 50;
    		}
    		while (input >= 40) {
        		n += "XL";
        		input -= 40;
    		}
    		while (input >= 10) {
        		n += "X";
        		input -= 10;
    		}
    		while (input >= 9) {
        		n += "IX";
        		input -= 9;
    		}
    		while (input >= 5) {
       		 	n += "V";
        		input -= 5;
    		}
    		while (input >= 4) {
       			n += "IV";
        		input -= 4;
    		}
    		while (input >= 1) {
        		n += "I";
        		input -= 1;
    		}
		
		System.out.println("\nSu número romano será: "+n);
		    
		}
		
	}
}