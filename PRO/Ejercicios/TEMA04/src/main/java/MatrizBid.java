/**
 * 
 */
import java.util.*;

public class MatrizBid {
    private int a[][];
    private int b[][];
    private int [][]c=new int[3][3];
    
    Scanner tec=new Scanner(System.in);

    public MatrizBid(int filas, int columnas){
        this.a=new int [filas][columnas];

        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                System.out.println("Introduce el valor del elemento ["+i+"]["+j+"]: ");
                this.a[i][j]=tec.nextInt();
            }
        }
    }

    public MatrizBid(int[][] a){
        this.a=a;
    }
    
    /**
     * Método para sumar los valores entre la matriz A y la matriz B.
     * @param b = matriz b
     * @return Suma resultante.
     */
    public MatrizBid suma(MatrizBid b){
        int suma[][]=new int[a.length][a[0].length];
        
        for(int i=0;i<a.length;i++){
            for(int j=0;i<a[0].length;j++){
                suma[i][j]=a[i][j]+b.a[i][j];
            }
        }
        return new MatrizBid(suma);
    }
    
    /**
     * Método para restar los valores entre la matriz A y la matriz B.
     * @param b = matriz b
     * @return Resta resultante.
     */
    public MatrizBid resta(MatrizBid b){
        int resta[][]=new int[a.length][a[0].length];
        
        for(int i=0;i<a.length;i++){
            for(int j=0;i<a[0].length;j++){
                resta[i][j]=a[i][j]-b.a[i][j];
            }
        }
        return new MatrizBid(resta);
    }
    
    /**
     * Método para hacer el producto entre la matriz A y la matriz B.
     * @param b = matriz b
     * @return Producto resultante.
     */
    public MatrizBid producto(MatrizBid b){
        int producto[][]=new int[a.length][a[0].length];
        
        for(int i=0;i<a.length;i++){
            for(int j=0;i<a[0].length;j++){
                producto[i][j]=a[i][j]*b.a[i][j];
            }
        }
        return new MatrizBid(producto);
    }

    public static void main(String args[]){
        System.out.println("¿Qué operación quiere hacer con las matrices?");
        Scanner tec=new Scanner(System.in);
        String operacion=tec.nextLine();
        tec.close();

        switch(operacion){
            case "suma":
                System.out.println();
            case "resta":
                System.out.println();
            case "producto":
                System.out.println();
        }
    }
}
/*
int [][]a=new int [2][2]

for(int i=0;i<a.length;i++){
    for(int j=0;i<a[0].length;j++){
        System.out.println(a[i][j]);
    }
}
*/