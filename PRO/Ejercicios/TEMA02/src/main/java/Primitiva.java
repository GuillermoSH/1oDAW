/*public class Primitiva{
    public static void main(String args[]){
        int na1, na2, nu1, nu2, intentos=5;
        java.util.Scanner teclado=new java.util.Scanner(System.in);

        [0,1) ---> [1,49] --> [1,50)

        0 --> 1  --> a*0+b=1  --> b=1
        1 --> 50 --> a*1+b=50 --> a+1=50 --> a=49

        (int)(a*Math.random()+b)
        (int)(49*Math.random()+1)
        

        na1=(int)(49*Math.random()+1);
        do{
            na2=(int)(49*Math.random()+1);
        }while(na2==na1);

        do{
            System.out.println("Introduce n1: ");
            nu1=teclado.nextInt();
            System.out.println("Introduce n2: ");
            nu2=teclado.nextInt();
            teclado.close();
        
            if(nu1==na1 && nu2==na2 || nu1==na2 && nu2==na1){
                System.out.println("Enhorabuena, acertaste!");
                break;
            
            } else {
                intentos--;
                System.out.println("Lo siento :'(. Prueba de nuevo");
                System.out.println("Te quedan "+intentos+" intentos.");
            }
        } while(intentos>0);
        if (intentos==0) {
            System.out.println("Lo siento has agotado todos los intentos.");
        }
    }
}*/