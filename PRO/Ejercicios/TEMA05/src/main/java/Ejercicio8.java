import java.util.*;
import java.io.*;

/**
 * 8) Un supermercado de productos ecológicos nos ha pedido hacer un programa
 * para vender su mercancía. Los productos que se indican en la tabla junto con
 * su precio. Los productos se venden en bote, brick, etc. Cuando se realiza la
 * compra, hay que indicar el producto y el número de unidades que se compran,
 * por ejemplo “guisantes” si se quiere comprar un bote de guisantes y la
 * cantidad, por ejemplo “3” si se quieren comprar 3 botes. La compra se termina
 * con la palabra “fin”. Suponemos que el usuario no va a intentar comprar un
 * producto que no existe. Si algún producto se repite en diferentes líneas, se
 * deben agrupar en una sola. Por ejemplo, si se pide primero 1 bote de tomate y
 * luego 3 botes de tomate, en el extracto se debe mostrar que se han pedido 4
 * botes de tomate. Después de teclear “fin”, el programa pide un código de
 * descuento. Si el usuario introduce el código “ECODTO”, se aplica un 10% de
 * descuento en la compra.
 * 
 * @author @GuillermoSH
 * @version 0.1
 */
public class Ejercicio8 {
    private Map<String, Double> productos = new HashMap<>();
    private Map<String, Integer> compra = new HashMap<>();

    public void leerDatosProductos() throws FileNotFoundException {
        Scanner ficheroProductos = new Scanner(new File(
                "D:\\Programacion\\PRO\\Ejercicios\\TEMA05\\DatosEjercicios\\T05-E08-DatosProductosSupermercado.txt"));
        String linea;
        String datosLinea[];
        String producto;
        double precio;

        while (ficheroProductos.hasNextLine()) {
            linea = ficheroProductos.nextLine();
            datosLinea = linea.split("[ ]+");
            producto = datosLinea[0];
            String precioStr = datosLinea[1].replace(",", ".");
            precio = Double.parseDouble(precioStr);
            this.productos.put(producto, precio);
        }

        ficheroProductos.close();
    }

    public void leerDatosCompra() throws FileNotFoundException {
        Scanner ficheroCompra = new Scanner(
                new File("D:\\Programacion\\PRO\\Ejercicios\\TEMA05\\DatosEjercicios\\T05-E08-DatosCompraCliente.txt"));
        String linea;
        String datosLinea[];
        String producto;
        int cantidad;

        while (ficheroCompra.hasNextLine()) {
            linea = ficheroCompra.nextLine();
            datosLinea = linea.split("[ ]+");
            producto = datosLinea[0];
            cantidad = Integer.parseInt(datosLinea[1]);

            if (compra.containsKey(producto)) {
                this.compra.put(producto, this.compra.get(producto) + cantidad);
            } else {
                this.compra.put(producto, cantidad);
            }
        }

        ficheroCompra.close();
    }

    public void carrito() {
        double precio[] = new double[compra.size()];
        int cantidad[] = new int[compra.size()];
        double subtotal[] = new double[compra.size()];
        String prod[] = new String[compra.size()];
        double total = 0;
        int i = 0;

        Scanner tec = new Scanner(System.in);
        System.out.print("Introduzca código de descuento (INTRO si no tiene ninguno): ");
		String codigoDesc=tec.nextLine();
        tec.close();

        for (String producto : this.compra.keySet()) {
            precio[i] = this.productos.get(producto);
            cantidad[i] = this.compra.get(producto);
            prod[i] = producto;

            subtotal[i] = precio[i] * (double)(cantidad[i]);
            total += subtotal[i];
            i++;
        }

        System.out.println("\n----------- ------ -------- --------");
        System.out.println("Producto    Precio Cantidad Subtotal");
        System.out.println("----------- ------ -------- --------");

        for (i=0 ; i < compra.size() ; i++) {
            System.out.printf("%-11s %6.2f %8d %8.2f\n",prod[i],precio[i],cantidad[i],subtotal[i]);
        }

        System.out.println("----------- ------ -------- --------");

        if(codigoDesc.equals("ECODTO")) {
            double descuento = total * 0.1;
            total -= descuento;
            System.out.printf("                 Descuento: %8.2f\n",descuento);
        } else {
            System.out.println("                 Descuento:");
        }

        System.out.println("----------- ------ -------- --------");
        System.out.printf ("                     TOTAL: %8.2f\n",total);
        System.out.println("----------- ------ -------- --------");
    }

    public static void main(String args[]) throws FileNotFoundException {
        Ejercicio8 e = new Ejercicio8();
        e.leerDatosProductos();
        e.leerDatosCompra();
        e.carrito();
    }
}
