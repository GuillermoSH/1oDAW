import java.util.Scanner;

public class EjercicioPropio {
    public static void main(String []args){
        
        double gradosC, gradosF, gradosK;
        String s;

        Scanner tec=new Scanner(System.in);
        System.out.print("Introduce grados Centígrados: ");
            gradosC=tec.nextDouble();
        
        System.out.print("\nTeclea 'kelvin' , 'fahrenheit' o 'both' para saber a que quieres convertir: ");
            tec.nextLine();
            s=tec.nextLine();
            tec.close();
        /*
        switch(s){
            case "k":
                gradosK=gradosC+273.15;
                System.out.println("\n"+gradosC+" ºC son: "+gradosK+" K.");
            case "f":
                gradosF=32+(9*gradosC/5);
                System.out.println("\n"+gradosC+" ºC son: "+gradosF+" ºF.");
            case "b":
                gradosK=gradosC+273.15;
                gradosF=32+(9*gradosC/5);
                System.out.println("\n"+gradosC+" ºC son: "+gradosK+" K y "+gradosF+" ºF.");
        }*/
        
        if(s.equals("kelvin")){
            gradosK=gradosC+273.15;
            System.out.println("\n"+gradosC+" ºC son: "+gradosK+" K.");
        } else if(s.equals("fahrenheit")){
            gradosF=32+(9*gradosC/5);
            System.out.println("\n"+gradosC+" ºC son: "+gradosF+" ºF.");
        } else if(s.equals("both")){
            gradosK=+gradosC+273.15;
            gradosF=32+(9*gradosC/5);
            System.out.println("\n"+gradosC+" ºC son: "+gradosK+" K y "+gradosF+" ºF.");
        } else{
            System.out.println("\nLa letra introducida no es válida.");
        }
    }
}
