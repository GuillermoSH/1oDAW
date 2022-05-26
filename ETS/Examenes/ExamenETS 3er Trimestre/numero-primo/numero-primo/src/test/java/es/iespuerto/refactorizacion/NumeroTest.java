package es.iespuerto.refactorizacion;

import org.junit.jupiter.api.*;

public class NumeroTest {
    int[] arrayNumero;
    Numero primos = null;

    @Test
    public void arrayNuloTest() {
        primos = new Numero(0);
        arrayNumero = primos.getPrimos();
        Assertions.assertTrue(arrayNumero.length == 0);
    }

    @Test
    public void array2Test() {
        primos = new Numero(2);
        arrayNumero = primos.getPrimos();
        Assertions.assertEquals(arrayNumero.length, 1);
        Assertions.assertEquals(arrayNumero[0], 2);
    }

    @Test
    public void array3Test() {
        primos = new Numero(3);
        arrayNumero = primos.getPrimos();
        Assertions.assertEquals(arrayNumero[0], 2);
        Assertions.assertEquals(arrayNumero[1], 3);

    }

    @Test
    public void array100Test() {
        primos = new Numero(100);
        arrayNumero = primos.getPrimos();
        Assertions.assertEquals(arrayNumero[24], 97);

    }
}
