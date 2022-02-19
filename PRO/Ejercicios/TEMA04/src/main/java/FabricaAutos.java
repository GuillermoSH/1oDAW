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
 * @version 0.1
 */
public class FabricaAutos{
    private final int numModelos=4;
    private final int numPuntos=4;
    int ventas[][]=new int[numModelos][numPuntos];

    /**
     * Método para leer los datos de ambas columnas desde un fichero de texto. Para ello leeremos el fichero y
     * dividiremos sus columnas de datos en datos por separado (modelo y pVentas) para poder usarlos luego en
     * otros métodos.
     * @throws FileNotFoundException Error de lectura de fichero, no se encuentra o no existe.
     */
    public void leerDatos() throws FileNotFoundException {
        File entrada=new File("/rutaAbsolutaFichero.txt"); // poner la ruta absoluta del fichero a leer
        Scanner lector=new Scanner(entrada);
        String linea="";
        String[] datosLinea;
        int modelo,pVenta;

        while(!linea.equals("-1")){
            linea=lector.nextLine();
            datosLinea=linea.split(" ");
            modelo=Integer.parseInt(datosLinea[0]);
            pVenta=Integer.parseInt(datosLinea[1]);
            ventas[modelo][pVenta]++;
        }
        lector.close();
    }

    public static void main(String arg[]) throws FileNotFoundException{
        FabricaAutos f=new FabricaAutos();
        f.leerDatos();
    }
}