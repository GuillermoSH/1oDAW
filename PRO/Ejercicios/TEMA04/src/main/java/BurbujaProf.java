import java.io.*;
import java.util.*;

public class BurbujaProf {
    private static double datos[]=new double[20];
    public static void burbuja(double[] v){
        boolean ordenado=false;
        int i=1;
        double aux;

        while(!ordenado){
            ordenado=true;

            for(int j=0;j<v.length-i;j++){
                if(v[j]>v[j+1]){
                    aux=v[j];
                    v[j]=v[j+1];
                    v[j+1]=aux;
                    ordenado=false;
                }
            }
            i++;
        }
    }

    public static void leerDatos() throws FileNotFoundException {
        Scanner fDatos=new Scanner(new File("rutaAbsoluta"));

        for(int i=0;i<datos.length;i++){
            datos[i]=fDatos.nextDouble();
        }

        fDatos.close();
    }

    public static void main(String args[]){
        try {
            leerDatos();
            System.out.println("Datos: "+Arrays.toString(datos));
            burbuja(datos);
            System.out.println("Datos: "+Arrays.toString(datos));
            System.out.printf("La mejor nota es: %.2f.\n",datos[datos.length-1]);
            System.out.printf("La 2a mejor nota es: %.2f.\n",datos[datos.length-2]);
            System.out.printf("La 3a mejor nota es: %.2f.\n",datos[datos.length-3]);
            System.out.printf("La media es: %.2f.\n",(datos[datos.length-1]+datos[datos.length-2]+datos[datos.length-3])/3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
