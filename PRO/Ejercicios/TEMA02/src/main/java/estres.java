import java.util.Scanner;

public class estres{
    public static void main(String args[]){
        Scanner tec=new Scanner(System.in);

        System.out.println("Introduzca en una escala del 1 al 10 su nivel de estres: ");
            int nivel=tec.nextInt();
            tec.close();
        
        if(nivel>10 || nivel<0){
            System.out.println("\nHala fantasma!");
        } else{
            switch (nivel) {
                case 0:
                    System.out.println("\nPa' esto ni me molestes."); break;
                
                case 1: case 2: case 3: case 4:
                    System.out.println("\nDe momento vas bien."); break;
                
                case 5: case 6: case 7:
                    System.out.println("\nDeberías mirartelo."); break;
                
                case 8: case 9:
                    System.out.println("\nEstás jodido."); break;

                case 10:
                    System.out.println("\nNo me seas exagerado."); break;
            }
        }
    }
}