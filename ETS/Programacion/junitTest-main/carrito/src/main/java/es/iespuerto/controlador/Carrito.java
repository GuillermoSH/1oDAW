package es.iespuerto.controlador;

import es.iespuerto.model.Producto;

import java.util.*;

/**
 * @author jpexposito
 * Clase que implementa un carrito de la compra
 */
public class Carrito {

    private Map<Producto, Integer> productosComprados = new TreeMap<>();

    

    public Map<Producto, Integer> getProductosComprados() {
        return productosComprados;
    }

    /**
     * Funcion que permite incluir un elemento en el carrito de
     * @param producto Producto que se desea incluir
     * @param cantidad Cantidad de elementos que se desean incluir
     */
    public void add(Producto producto, int cantidad) {
        if (productosComprados.containsKey(producto)) {
            productosComprados.put(producto,
                    productosComprados.get(producto) + cantidad);
        } else {
            productosComprados.put(producto, cantidad);
        }
    }

    /**
     * Funcion que realiza el calculo del precio del carrito
     * @return Double con el precio del carrito
     */
    public double totalCarrito() {
        double total = 0;
        for (Producto p : productosComprados.keySet()) {
            total += productosComprados.get(p) * p.getPrecioVenta();
        }
        return total;
    }

    /**
     * Funcion que permite imprimir el carrito de la compra
     */
    /** 
    public void imprimirTicket() {
        System.out.println("-------- ----------------------------------- -------- --------------- --------");
        System.out.printf("%-8s %-35s %-8s %-14s %-8s%n", "Producto", "Descripción", "Cantidad", "Precio Unitario",
                "Subtotal");
        System.out.println("-------- ----------------------------------- -------- --------------- --------");
        for (Producto p : productosComprados.keySet()) {
            System.out.printf("%-8s %-35s %8d %15.2f %8.2f%n",
                    p.getCodigo(), p.getDescripcion(), productosComprados.get(p), p.getPrecioVenta(),
                    productosComprados.get(p) * p.getPrecioVenta());
        }
        System.out.println("-------- ----------------------------------- -------- --------------- --------");
        System.out.printf("%69s %8.2f%n", "Total Carro:", totalCarrito());
        System.out.println("-------- ----------------------------------- -------- --------------- --------");
    }
*/
    
    public String imprimirTicket() {
        String resultado = "";
        resultado = "\n-------- ----------------------------------- -------- --------------- --------";
        resultado += "\n Producto  Descripción Cantidad Precio Unitario Subtotal";
        resultado += "\n -------- ----------------------------------- -------- --------------- --------";
        for (Producto p : productosComprados.keySet()) {
            resultado += "\n " + p.getCodigo()+ " "+ p.getDescripcion()+ " "+ productosComprados.get(p)+ " "+ p.getPrecioVenta()
                    + " "+ productosComprados.get(p) * p.getPrecioVenta() + "\n";
        }
        resultado += "\n -------- ----------------------------------- -------- --------------- --------";
        resultado += "\n Total Carro:" + totalCarrito();
        resultado += "\n -------- ----------------------------------- -------- --------------- --------";
        return resultado;
    }
     
}
