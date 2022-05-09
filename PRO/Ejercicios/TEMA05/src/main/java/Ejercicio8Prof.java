import java.io.*;
import java.util.*;

public class Ejercicio8Prof {
    private Map<String, Double> productos = new HashMap<>();
    private Map<String, Integer> cesta = new HashMap<>();

    public void leerProductos(String fichero) throws FileNotFoundException {
        Scanner fDatos = new Scanner(new File(fichero));
        String linea, producto, lineaDatos[];
        double precio;

        while (fDatos.hasNextLine()) {
            linea = fDatos.nextLine();
            linea.replace(",", ".");
            lineaDatos = linea.split(" ");
            producto = lineaDatos[0];
            precio = Double.parseDouble(lineaDatos[1]);
            productos.put(producto, precio);
        }
    }

    public void leerCesta(String fichero) throws FileNotFoundException {
        Scanner fDatos = new Scanner(new File(fichero));
        String linea, producto, lineaDatos[];
        int cantidad;

        while (fDatos.hasNextLine()) {
            linea = fDatos.nextLine();
            lineaDatos = linea.split(" ");
            producto = lineaDatos[0];
            cantidad = Integer.parseInt(lineaDatos[1]);

            if (cesta.containsKey(producto)) {
                cesta.put(producto, cesta.get(producto) + cantidad);
            } else {
                cesta.put(producto, cantidad);
            }
        }
    }

    public void imprimirTicket(double descuento) {
        double precio, total=0;
        int cantidad;

        System.out.println("----------- ------ -------- --------\n" +
                "Producto    Precio Cantidad Subtotal\n" +
                "----------- ------ -------- --------");

        for (String producto : this.cesta.keySet()) {
            precio = this.productos.get(producto);
            cantidad = this.cesta.get(producto);
            total+=precio*cantidad;

            if (cantidad > 1) {
                System.out.printf("%-11s %6.2f %8d %8f", producto, precio, cantidad, cantidad * precio);
            } else {
                System.out.printf("%-27s %8.2f",producto,precio);
            }
        }

        System.out.println("----------- ------ -------- --------");
        if (descuento>0) {
            System.out.printf("%27s: %8.2f","Descuento",descuento * total/100);
            System.out.println("----------- ------ -------- --------");
        }
        System.out.printf("%27s: %8.2f","TOTAL",total);
        System.out.println("----------- ------ -------- --------");
    }

    public static void main(String args[]) throws FileNotFoundException {
        Ejercicio8Prof e = new Ejercicio8Prof();

        e.leerProductos("ruta");
        e.leerCesta("ruta");
    }
}
