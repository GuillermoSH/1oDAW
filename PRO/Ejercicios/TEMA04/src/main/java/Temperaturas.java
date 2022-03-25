import java.io.*;
import java.util.Scanner;

/**
 * 5.- Ver el vídeo https://youtu.be/0_PO-77gu_E. Diseñar una matriz bidimensional de 12 filas
 * (meses del año 2019) y un número de columnas de 31,28,31,30,31,30,31,31,30,31,30,31 columnas
 * respectivamente, donde las filas representen los meses del año y las columnas la temperatura
 * media de cada día. Para hacer una prueba podemos guardar los siguientes datos en un fichero de
 * texto y leerlo como ya se hizo en ejercicios anteriores:
 * 
 * Puedes descargar el fichero de texto con los datos de la plataforma
 * 
 * Calcular:
 *   a) La temperatura media de cada mes.
 *   b) El día más caluroso y el más frío de cada mes.
 *   c) El día más caluroso del año.
 *   d) El día más frío del año.
 * 
 * @author Guillermo Sicilia Hernández
 * @version 0.2
 */
public class Temperaturas {
    static int temperaturas[][]=new int[12][31];

    /**
     * Método para leer los datos de ambas columnas desde un fichero de texto. Para ello leeremos el fichero y
     * dividiremos sus columnas de datos en datos por separado (meses y temperaturas) para poder usarlos luego en
     * otros métodos.
     * @throws FileNotFoundException Error de lectura de fichero, no se encuentra o no existe.
     */
    public static void leerDatos() throws FileNotFoundException {
        File archivo=null;
        try {
            archivo=new File("D:\\Tema04-ExtraArrays.E05.DatosTemperaturas.txt"); // apertura del fichero
            String linea="";
            while(linea!=null){
                for(int i=0;i<temperaturas[0].length;i++){
                    for(int j=0;j<temperaturas[0].length;j++){
                        //temperaturas[i][j]="la tabla del archivo";
                    }
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void medias(){
        int suma;

        for(int i=0;i<temperaturas.length;i++){
            suma=0;
            for(int j=0;j<temperaturas[i].length;j++){
                suma+=temperaturas[i][j];
            }
            System.out.println("Mes "+i+" temperatura media: "+((double)suma/temperaturas[i].length));
        }
    }

    public static int[] mediasV2(){
        int res[]=new int[temperaturas.length];

        for(int i=0;i<temperaturas.length;i++){ //recorro meses
            for(int j=0;j<temperaturas.length;j++){
                res[i]+=temperaturas[i][j];
            }
        }
        return res;
    }

    public static void main(String args[]){
        try {
            leerDatos();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
