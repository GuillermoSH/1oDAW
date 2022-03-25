import java.io.*;
import java.util.Scanner;
/**
 * 1.- Una fábrica de automóviles produce cuatro modelos de coches cuyos precios de venta son respectivamente
 * 1.5, 1.75, 2.42, 2.6 millones de pesetas. Esta empresa cuenta con cuatro centros de distribución y venta. Se
 * dispone de una relación de datos correspondientes al tipo de vehículos vendido y punto de distribución en que
 * se produjo la venta del mismo. Realizar un porgrama que leyendo del teclado la relación de datos anterior
 * (100 como máximo), calcule e imprima:
 * 
 *      a) Volumen de ventas total.
 *      b) Volumen de ventas por centro.
 *      c) Porcentaje de unidades totales vendidas en cada centro.
 *      d) Porcentaje de unidades de cada modelo vendidos en cada centro, sobre el total de ventas de la empresa.
 * 
 *      Ejemplo de datos de entrada:
 *      0 1 // modelo de coche 0, punto de venta 1
 *      1 2 // modelo de coche 1, punto de venta 2
 * 
 * @author Guillermo Sicilia Hernández
 * @version 0.4
 */
public class FabricaAutos{
    private final int numModelos=4;
    private final int numPuntos=4;
    int ventas[][]=new int[numModelos][numPuntos];
    private final int longArray=ventas[0].length; // longitud del array ventas

    /**
     * Método para leer los datos de ambas columnas desde un fichero de texto. Para ello leeremos el fichero y
     * dividiremos sus columnas de datos en datos por separado (modelo y pVentas) para poder usarlos luego en
     * otros métodos.
     * @throws FileNotFoundException Error de lectura de fichero, no se encuentra o no existe.
     */
    public void leerDatos() throws FileNotFoundException {
        File entrada=new File("D:\\Tema04-ExtraArrays.E01.DatosVentasCoches.txt"); // poner la ruta absoluta del fichero a leer
        try (Scanner lector = new Scanner(entrada)) {
            String linea="";
            String[] datosLinea;
            int modelo,pVenta;
            while(!linea.equals("-1")){
                if(!linea.equals("-1")){
                    linea=lector.nextLine();
                    datosLinea=linea.split(" ");
                    modelo=Integer.parseInt(datosLinea[0]);
                    pVenta=Integer.parseInt(datosLinea[1]);
                    this.ventas[modelo][pVenta]++;
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método para hallar la suma total de ventas de la empresa.
     * @param ventas Array bidimensional con el número de ventas por punto de venta.
     * @return Suma total de ventas.
     */
    public int ventasTotal(int ventas[][]){
        int suma=0;

        for(int i=0;i<longArray;i++){
            for(int j=0;j<longArray;j++){
                suma+=ventas[i][j];
            }
        }
        System.out.println("a) Volumen de ventas totales: "+suma);
        return suma;
    }

    /**
     * Método para hallar la suma de ventas de cada centro de de distribución.
     * @param ventas Array bidimensional con el número de ventas por punto de venta.
     */
    public void ventasCentros(int ventas[][]){
        int suma[]=new int[longArray];

        for(int i=0;i<longArray;){
            for(int j=0;j<longArray;j++){
                suma[j]+=ventas[i][j];
                if(j==longArray-1){
                    i++;
                }
            }
        }
        for(int i=0;i<longArray;i++){
            System.out.println("   ~ El punto de venta "+(i+1)+" vendió "+suma[i]+" coches.");
        }
    }

    /**
     * Método para hallar el porcentaje de ventas por centro con respecto a las ventas totales.
     * @param ventas Array bidimensional con el número de ventas por punto de venta.
     */
    public void porcentajeVentasCentro(int ventas[][]){
        int porcenVentCentros[]=new int[longArray];
        int suma[]=new int[longArray];

        for(int i=0;i<longArray;){
            for(int j=0;j<longArray;j++){
                suma[j]+=ventas[i][j];
                if(j==longArray-1){
                    i++;
                }
            }
        }
        for(int i=0;i<longArray;i++){
            porcenVentCentros[i]=(suma[i]/ventasTotal(ventas))/100;
        }
        System.out.println("c) Porcentaje de unidades totales vendidas en cada centro:");
        for(int i=0;i<4;i++){
            System.out.println("   ~ El punto de venta "+(i+1)+" tuvo un porcentaje de ventas del "+porcenVentCentros[i]+"%.");
        }
    }

    /**
     * Método para hallar el porcentaje de ventas de cada modelo con respecto a las ventas totales.
     * @param ventas Array bidimensional con el número de ventas por punto de venta.
     */
    public void porcentajeVentasModelos(int ventas[][]){
        int porcenVentModelos[]=new int[longArray];
        int suma[]=new int[longArray];

        for(int i=0;i<longArray;){
            for(int j=0;j<longArray;j++){
                suma[j]+=ventas[j][i];
                if(j==longArray-1){
                    i++;
                }
            }
        }
        
        for(int i=0;i<longArray;i++){
            porcenVentModelos[i]=(suma[i]/ventasTotal(ventas))/100;
        }
        System.out.println("d) Porcentaje de unidades de cada modelo vendidos en cada centro, sobre el total de ventas de la empresa:");
        for(int i=0;i<4;i++){
            System.out.println("   ~ El modelo "+(i+1)+" tuvo un porcentaje de ventas del "+porcenVentModelos[i]+"%.");
        }
    }

    public static void main(String arg[]) throws FileNotFoundException{
        FabricaAutos f=new FabricaAutos();
        f.leerDatos();
    }
}