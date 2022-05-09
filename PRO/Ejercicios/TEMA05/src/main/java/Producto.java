import java.util.*;
import java.io.*;

public class Producto {
    private String codigo;
    private String descripcion;
    private double pcompra;
    private double pventa;
    private int stock;

    public Producto(String codigo, String descripcion, double pcompra, double pventa, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.pcompra = pcompra;
        this.pventa = pventa;
        this.stock = stock;
    }

    public void leerDatosProductos() throws FileNotFoundException {
        Scanner ficheroProductos = new Scanner(new File("D:\\Programacion\\PRO\\Ejercicios\\TEMA05\\DatosEjercicios\\T05-E10-Productos.txt"));
        String linea;
        String datosLinea[];

        while (ficheroProductos.hasNextLine()) {
            linea = ficheroProductos.nextLine();
            datosLinea = linea.split(";");
            this.codigo = datosLinea[0];
            this.descripcion = datosLinea[1];
            this.pcompra = Double.parseDouble(datosLinea[2]);
            this.pventa = Double.parseDouble(datosLinea[3]);
            this.stock = Integer.parseInt(datosLinea[4]);
            
        }
    }
}
