package es.iespuerto.vista;

import es.iespuerto.controlador.Carrito;
import es.iespuerto.model.Producto;
import es.iespuerto.utils.Utilidades;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

public class Tienda {
    /**
     * Funcion main de la clase principal
     * 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        List<Producto> productos = new ArrayList<>();
        Utilidades utilidades = new Utilidades();
        Carrito carro = new Carrito();

        productos = utilidades.leerProductos("productos.txt");
        utilidades.leerCarrito("compra.txt",productos);
        
        System.out.println(carro.imprimirTicket());
    }
}