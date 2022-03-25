import java.io.*;
import java.util.*;

public class FabricaCochesProf {
    private static final int numModelos=4;
    private static final int numCentros=4;
    private static int[][] ventas=new int[numModelos][numCentros];
    private static final double precioModelo[]={1.5,1.75,2.42,2.6};

    public static void leerDatos() throws FileNotFoundException{
        String fichero="/rutaabsoluta";
        Scanner fDatos=new Scanner(new File(fichero));
        String linea="";
        int modelo,centro;
        String datos[];

        linea=fDatos.nextLine();

        while(true){
            datos=linea.split(" ");
            modelo=Integer.parseInt(datos[0]);
            centro=Integer.parseInt(datos[1]);
            ventas[modelo][centro]++;
            linea=fDatos.nextLine();
        }
    }
    public static String toString(int ventas[][]){
        String res="{";

        for(int i=0;i<ventas.length;i++){
            res+="{";
            for(int j=0;j<ventas[i].length;j++){
                if(j<ventas[i].length-1){
                    res+=ventas[i][j]+",";
                } else{
                    res+=ventas[i][j];
                }
            }
            if(i<ventas.length-1){
                res+="},";
            } else{
                res+="}";
            }
            res+="}";
        }
        return res;
    }

    public static int sumaModelo(int modelo){
        int suma=0;

        for(int pVenta=0;pVenta<ventas[modelo].length;pVenta++){
            suma+=ventas[modelo][pVenta];
        }
        return suma;
    }

    public static void volumenVentasTotal(){
        int unidades=0;
        double precioTotal=0;

        for(int modelo=0;modelo<ventas.length;modelo++){
            unidades+=sumaModelo(modelo);
            precioTotal+=sumaModelo(modelo)*precioModelo[modelo];
        }
        System.out.printf("Total vehículos vendidos: %d.\n",unidades);
        System.out.printf("Total pesetas: %.2f",precioTotal);
    }

    public static double[] volumenVentasPorCentro(boolean calculaPrecio){
        double volumenPVenta[]=new double[numCentros];
        for(int pVenta=0;pVenta<ventas[0].length;pVenta++){
            for(int modelo=0;modelo<ventas.length;modelo++){
                if(calculaPrecio){
                    volumenPVenta[pVenta]+=precioModelo[modelo]*ventas[modelo][pVenta];
                } else{
                    volumenPVenta[pVenta]+=ventas[modelo][pVenta];
                }
            }
        }
        return volumenPVenta;
    }
    public static void main(String args[]){
        try {
            leerDatos();
            volumenVentasTotal();
            //volumenVentasPorCentro();
            //porcentajeUnidadesCentro();
            //porcentajeUnidadesModeloCentro();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
