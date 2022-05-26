package es.iespuerto.controlador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuerto.model.Producto;

public class CarritoTest {

    Carrito carrito = null;
    Producto producto = null;

    @BeforeEach
    public void beforeEach() {
        if (producto == null) {
            producto = new Producto("codigo",
             "descripcion",
              5, 10, 7);
        }
        if (carrito == null) {
            carrito = new Carrito();
            carrito.add(producto, 1);
        }
       
    }

    @Test
    public void addTest() {
        
        Assertions.assertEquals(1,
        carrito.getProductosComprados().size(),
        "La lista no contiene el numero de elementos correctos");
    }

    @Test
    public void addProductoExistenteTest() {
        carrito.add(producto, 1);

        Assertions.assertEquals(2,
        carrito.getProductosComprados().get(producto),
        "La lista no contiene el numero de elementos correctos");

    }

    @Test
    public void totalCarritoTest() {     
        Assertions.assertEquals(10,
        carrito.totalCarrito(),
        "La operacion de total Carrito no funciona correctamente");
    }


    @Test
    public void imprimitTiketTest() {     
        Assertions.assertTrue(
        carrito.imprimirTicket().contains(producto.getCodigo()),"El mensaje no contiene el texto esperado");
    }

}
