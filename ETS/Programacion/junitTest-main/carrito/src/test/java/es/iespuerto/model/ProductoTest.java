package es.iespuerto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ProductoTest {

    public static final String CODIGO = "codigo";
    public static final String DESCRIPCION = "descripcion";
    public static final double PRECIO_COMPRA = 1;
    public static final double PRECIO_VENTA = 1;
    public static final int STOCK = 1;
    Producto producto;

    @BeforeEach
    public void before() {
        if (producto == null) {
            producto = new Producto(CODIGO, DESCRIPCION,
                    PRECIO_COMPRA,PRECIO_VENTA,STOCK);
        }
    }

    @Test
    public void constructorTest() {
       Assertions.assertNotNull(producto, "El objeto producto no puede ser NULO");
    }

    @Test
    public void toStringTest() {
        Assertions.assertNotNull(producto.toString(),"La respuesta es nula");
        Assertions.assertTrue(producto.toString().contains(CODIGO),"No contiene el codigo");
        Assertions.assertTrue(producto.toString().contains(DESCRIPCION),"No contiene el descripcion");
    }

    @Test
    public void changeStockTest(){
        producto.changeStock(2);
        Assertions.assertEquals(3, producto.getStock(), "El stock no es el esperado");
    }

    @Test
    public void gettersTest() {
        Assertions.assertEquals(DESCRIPCION, producto.getDescripcion(),
         "La descripcion no es a esperada");
         Assertions.assertEquals(CODIGO, producto.getCodigo(),
         "El codigo no es el esperado");
         Assertions.assertEquals(PRECIO_VENTA, producto.getPrecioVenta(),
         "El precio de venta no es el esperado");
    }

    @Test
    public void compareToTest() {
        Producto comparar = new Producto(CODIGO, "",
         2, 1, 16);
        Assertions.assertTrue(producto.compareTo(comparar) == 0,
         "Los objectos no son iguales");
         
    }

    @Test
    public void compareToFalteTest() {
        Producto comparar = new Producto("CODIGO_2", "",
         2, 1, 16);
        Assertions.assertNotEquals( 0,producto.compareTo(comparar)
        ,"Los objectos no son iguales");
         
    }

    @Test
    public void equalsTest() {
        Assertions.assertTrue(producto.equals(producto)
        ,"El objeto tiene que ser igual");
         
    }

    @Test
    public void equalsFalseTest() {
        Producto comparar = new Producto("CODIGO_2", "",
         2, 1, 16);
        Assertions.assertFalse(producto.equals(comparar)
        ,"El objeto no puede ser igual");
         
    }

}
