package main.java;

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
 * @version 0.1
 */
public class Temperaturas {
    static int temperaturas[][]=new int[12][];

    public static void leerDatos(){
        String fichero="/rutaAbsoluta";
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
        int suma;

        for(int i=0;i<temperaturas.length;i++){ //recorro meses
            suma=0;
            for(int j=0;j<temperaturas.length;j++){
                suma+=temperaturas[i][j];
            }
        }
        return res;
    }

    public static void main(String args[]){
        leerDatos();
        medias();
    }
}
