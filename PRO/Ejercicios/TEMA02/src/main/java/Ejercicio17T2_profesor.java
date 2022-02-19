public class Ejercicio17T2_profesor {
    public static String repite(char c,int n){
        String res="";
        
        for(int i=1;i<=n;i++){
            res=res+c;
        }
        return res;
    }

    public static void main(String[] args) {
        //int n=Integer.parseInt(args[0]);
        int n=5;

        if(n<=1 || n%2==0){
            System.out.println("Lo siento, necesito un número impar. Adiós!");
            System.exit(1);
        }
        /*System.out.println(repite(' ',2));
        System.out.println(repite('*',1));

        System.out.println(repite(' ',1));
        System.out.println(repite('*',3));*/
    }
}
