/**
 * 4.- Método que reciba dos arrays de números enteros ordenados y devuelve un único array con todos los
 * elementos de los dos arrays ordenados.
 * 
 * @author Guillermo Sicilia Hernández
 * @version 0.1
 */
public class Mezcla {
    public static int[] mezcla(int []a,int b[]){
        int c[]=new int[a.length+b.length];
        int i,j,k;

        for(i=j=k=0;i<a.length && j<b.length;k++){
            if(a[i]<b[i]){
                c[k]=a[i];
                i++;
            } else{
                c[k]=b[j];
                j++;
            }
        }
        while(i<a.length){
            c[k++]=a[i++];
        }
        while(j<b.length){
            c[k++]=b[j++];
        }
        return c;
    }
}
