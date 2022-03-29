package ExamenPRO;

import java.io.*;
import java.util.*;

public class Ejercicio3Prof {
    private Map<String,int[]> paises = new TreeMap<>();
    private String fichero;

    public Ejercicio3Prof(String fichero){
        this.fichero=fichero;
    }

    public void leerDatos() throws FileNotFoundException{
        Scanner fDatos=new Scanner(new File(this.fichero));
        String linea,pais;
        String[] lineaDatos;
        
        while(fDatos.hasNextLine()){
            linea=fDatos.nextLine();
            lineaDatos=linea.split("[:]? ");
            pais=lineaDatos[0];
            int[] alturas=new int[lineaDatos.length-1];
            
            for(int i=0;i<lineaDatos.length;i++){
                alturas[i]=Integer.parseInt(lineaDatos[i]);
            }
            paises.put(pais,alturas);
        }
        fDatos.close();
    }

    public void cabecera(int n){
        System.out.printf("%-15s","País");

        for(int i=1;i<=12;i++){
            System.out.printf("%4s",i);
        }
        System.out.printf("   MED MIN MAX\n");
    }

    public void lineaTitulo(int n){
        System.out.printf("%-15s","-------");
        for(int i=1;i<=n;i++){
            System.out.printf("%4s","---");
        }
        System.out.printf("   --- --- ---\n");
    }

    public int media(int[] alturas){
        int suma=0;

        for(int i=0;i<alturas.length;i++){
            suma += alturas[i];
        }
        return suma/alturas.length;
    }

    public int minimo(int[] alturas){
        int min=alturas[0];

        for(int i=0;i<alturas.length;i++){
            if(alturas[i]<min){
                min=alturas[i];
            }
        }
        return min;
    }

    public int maximo(int[] alturas){
        int max=alturas[0];

        for(int i=0;i<alturas.length;i++){
            if(alturas[i]>max){
                max=alturas[i];
            }
        }
        return max;
    }

    public void imprimirDatos(){
        this.cabecera(12);
        this.lineaTitulo(12);
        int[] alturas;

        for(String pais:this.paises.keySet()){
            System.out.printf("%-15s",pais);
            alturas=this.paises.get(pais);

            for(int i=0;i<alturas.length;i++){
                System.out.printf("%4d",alturas[i]);
            }
            System.out.printf(" |");
            System.out.printf("%4d",this.media(alturas));
            System.out.printf("%4d",this.minimo(alturas));
            System.out.printf("%4d\n",this.maximo(alturas));
        }
        this.lineaTitulo(12);
    }

    public static void main(String args[]) throws FileNotFoundException{
        Ejercicio3Prof e=new Ejercicio3Prof("/media/daw/Toshiba DDe/Programacion/PRO/Ejercicios/TEMA04/src/main/java/ExamenPRO/DatosEjercicio3Examen2Eval.txt");
        e.leerDatos();
        e.imprimirDatos();
    }
}
