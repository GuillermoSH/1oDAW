package ExamenPRO;

public class Ejercicio2Prof {
    public double[][] prodNum(double n, double[][] a){
        double[][] res = new double[a.length][a[0].length];

        for ( int i = 0;i<a.length;i++){
            for (int j=0;j<a[0].length;j++){
                res[i][j]=n*a[i][j];
            }
        }
        return res;
    }
    public double[][] prodNum(double[][] a, double n){
        Ejercicio2Prof e=new Ejercicio2Prof();
        return e.prodNum(n, a);
    }
    public static void main(String args[]){
        Ejercicio2Prof e=new Ejercicio2Prof();
        
        double[][] r=e.prodNum(5,new double[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
