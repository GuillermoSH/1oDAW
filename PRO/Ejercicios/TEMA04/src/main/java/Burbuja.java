/**
 * 3.- Ver el vídeo https://www.youtube.com/watch?v=t9OW-ouW2RE sobre la implementación del método de 
 * ordenación de la burbuja en donde se implementa el mismo en lenguaje C, adapta el método implementado
 * en JAVA más arriba en estos apuntes a la implementación que se ve en el vídeo en el cual se introduce una
 * optimización: la introducción de una variable centinela ordenado, en nuestro caso será una variable boolean
 * en lugar de una variable tipo int ya que en lenguaje C no existe el tipo de datos boolean. Con el uso de este
 * variable se detecta si no se han intercambiado elementos, en cuyo caso quiere decir que el array (vector) ya
 * está ordenado y no hace falta seguir dando más pasadas. Otra diferencia entre lenguaje C y JAVA es que en
 * lenguaje C los arrays no guardan su tamaño, por eso verás que las funciones tienen que recibir además del
 *  array un segundo parámetro de tipo int con el tamaño del array, en JAVA disponemos de la propiedad
 * a.length que guarda el tamaño del array, ya que los arrays son objetos a diferencia de lo que ocurre en
 * lenguaje C que no es un lenguaje orientado a objetos. Resuelve también en JAVA el problema planteado en el
 * vídeo de leer las notas de 20 alumnos y obtener la media de los tres alumnos que mejor nota han obtenido.
 * Utilizar un fichero de texto para la entrada igual que se hizo en ejercicios anteriores
 * 
 * @author Guillermo Sicilia Hernández
 * @version 0.2
 */ 
public class Burbuja {
    public static void swap(int v[], int i, int j){
        int aux=v[i];
        v[i]=v[j];
        v[j]=aux;
    }

    public static void burbuja(int vector[]){
        int i,j;
        boolean ordenado=false;

        for(i=0;i<vector.length-1 && !ordenado;i++){
            ordenado=true;
            for(j=0;j<vector.length-i-1;j++){
                if(vector[j]>vector[j+1]){
                    swap(vector,j,j+1);
                    ordenado=false;
                }
            }
        }
        System.out.print("Este es su vector ordenado: ");
        for(i=0;i<vector.length;i++){
            System.out.print("  "+vector[i]);
        }
    }

    public static void main(String args[]){
        int vector[]={12,1,5,3,14,13,24,21};
        
        System.out.print("\nEste es su vector desordenado: ");
        for(int i=0;i<vector.length;i++){
            System.out.print("  "+vector[i]);
        }
        System.out.println("\n");
        burbuja(vector);
    }
}
