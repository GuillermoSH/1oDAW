public class Main {
    public static void main(String []args){
        java.util.Scanner teclado=new java.util.Scanner(System.in);
        
        Persona titular=new Persona("Luis",23,"123456789Z"); //se envia la referencia al constructor de Cuenta
        Cuenta c1=new Cuenta(titular); 
        Cuenta c2=new Cuenta(titular);
        //CuentaJoven cj1=new CuentaJoven(); incompleto

    }
}
