package es.iespuerto.utils;

import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.file.Paths;

import es.iespuerto.model.Producto;
import es.iespuerto.controlador.Carrito;

public class Utilidades {
    /**
     * Funcion que permite leer los elementos del fichero de productos
     * 
     * @param ficheroProductos Nombre del fichero de productos
     * @throws FileNotFoundException Excepcion indicando que el fichero no existe
     * @throws URISyntaxException
     */
    public List<Producto> leerProductos(String ficheroProductos) throws FileNotFoundException, URISyntaxException {
        Scanner fichero = new Scanner(new File(obtenerPathFichero(ficheroProductos)));
        String linea;
        String[] lineaDatos;
        ArrayList<Producto> lista = new ArrayList<>();

        fichero.nextLine();

        while (fichero.hasNextLine()) {
            linea = fichero.nextLine();
            lineaDatos = linea.split(";");
            lista.add(new Producto(lineaDatos[0], lineaDatos[1], Double.parseDouble(lineaDatos[2]),
                    Double.parseDouble(lineaDatos[3]), Integer.parseInt(lineaDatos[4])));
        }
        return lista;
    }

    /**
     * Funcion que lee los elementos del carrito
     * 
     * @param ficheroCantidades Fichero con los elementos del carro de la compra
     * @param productos         Lista de productos de la compra
     * @throws FileNotFoundException Exception indicando que el fichero no existe
     * @throws URISyntaxException
     */
    public Carrito leerCarrito(String ficheroCantidades, List<Producto> productos) throws FileNotFoundException, URISyntaxException {
        Scanner fichero = new Scanner(new File(obtenerPathFichero(ficheroCantidades)));
        String linea;
        String[] lineaDatos;
        Producto p;
        int cantidad;
        Carrito carro = new Carrito();

        fichero.nextLine();

        while (fichero.hasNextLine()) {
            linea = fichero.nextLine();
            lineaDatos = linea.split(";");
            cantidad = Integer.parseInt(lineaDatos[1]);
            p = buscarProducto(lineaDatos[0], productos);
            if (cantidad <= p.getStock()) {
                p.changeStock(-cantidad);
                carro.add(p, cantidad);
            } else {
                System.out.printf(
                        "Lo siento, no hay suficiente stock del producto %s. Cantidad pedida: %d; Cantidad disponible: %d%n",
                        p.getCodigo(), cantidad, p.getStock());
            }
        }

        return carro;
    }

    /**
     * Funcion encargada de obtener el path del ficero
     * 
     * @param nombreFichero Nombre del fichero a buscar
     * @return Path completo del fichero
     * @throws URISyntaxException Exception por la URL mal formada
     */
    public String obtenerPathFichero(String nombreFichero) throws URISyntaxException {
        URL res = getClass().getClassLoader().getResource(nombreFichero);
        File file = Paths.get(res.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();
        return absolutePath;
    }

    /**
     * Funcion que permite buscar un producto.
     * 
     * @param codigo    Codigo del producto que se desea buscar
     * @param productos Lista de productos de la compra
     * @return Producto relacionado con el codigo
     */
    public Producto buscarProducto(String codigo, List<Producto> productos) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }
}
