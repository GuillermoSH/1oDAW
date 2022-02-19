public class Ejercicio17T2_pablo{
    public static String asterisco(int n){
        int cont=1;
        String ast="*";

        while(cont<n){
            ast=ast+"*";
            cont=cont+1;
        }
        return ast;
    }
    //para los espacios se hará una división entera entre 2 del numero introducido
    
    public static String espacio(int n){
        int cont=0;
        String esp=" ",esp1=" ";

        while(cont<n){
            esp=esp+esp1;
            cont=cont+2;
        }
        return esp;
    }

    public static void main(String[] args) {
        //int n=Integer.parseInt(args[0]);
        int n=7;
        int numEsp,numAst=1;
        
        if (n%2==0){
            System.out.println("Lo siento necesito un número impar.");
            System.exit(1);
        }
    
        for(numEsp=n,numAst=1;numEsp/2>0;numEsp-=2,numAst+=2){
            System.out.print(espacio(numEsp));
            System.out.println(asterisco(numAst));
        }

        for(numAst=n,numEsp=1;numAst/2>0;numAst-=2,numEsp+=2){
            System.out.print(espacio(numEsp));
            System.out.println(asterisco(numAst));
        }

        System.out.print(espacio(numEsp));
        System.out.println(asterisco(1));
    }
}
