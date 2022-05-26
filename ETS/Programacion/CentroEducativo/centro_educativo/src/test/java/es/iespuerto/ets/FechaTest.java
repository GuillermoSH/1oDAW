package es.iespuerto.ets;

import org.junit.jupiter.api.*;

public class FechaTest {
    Fecha fecha = null;

    @BeforeEach
    public void Before() throws Exception {
        fecha = new Fecha("29/02/2012");
    }

    @Test
    public void getAnioTest() {
        Assertions.assertEquals(2012, fecha.getAnio());
    }

    @Test
    public void getMesNumericoTest() {
        Assertions.assertEquals(2, fecha.getMesNumerico());
    }

    @Test
    public void getMesNombreTest() throws Exception {
        Assertions.assertEquals("febrero", fecha.getMesNombre());
        // Comprobacion de los demas meses del año
        fecha = new Fecha("30/01/2012");
        Assertions.assertEquals("enero", fecha.getMesNombre());
        fecha = new Fecha("30/03/2012");
        Assertions.assertEquals("marzo", fecha.getMesNombre());
        fecha = new Fecha("30/04/2012");
        Assertions.assertEquals("abril", fecha.getMesNombre());
        fecha = new Fecha("30/05/2012");
        Assertions.assertEquals("mayo", fecha.getMesNombre());
        fecha = new Fecha("30/06/2012");
        Assertions.assertEquals("junio", fecha.getMesNombre());
        fecha = new Fecha("31/07/2012");
        Assertions.assertEquals("julio", fecha.getMesNombre());
        fecha = new Fecha("30/08/2012");
        Assertions.assertEquals("agosto", fecha.getMesNombre());
        fecha = new Fecha("30/09/2012");
        Assertions.assertEquals("septiembre", fecha.getMesNombre());
        fecha = new Fecha("30/10/2012");
        Assertions.assertEquals("octubre", fecha.getMesNombre());
        fecha = new Fecha("30/11/2012");
        Assertions.assertEquals("noviembre", fecha.getMesNombre());
        fecha = new Fecha("31/12/2012");
        Assertions.assertEquals("diciembre", fecha.getMesNombre());
    }

    @Test
    public void getDiaTest() {
        Assertions.assertEquals(29, fecha.getDia());
    }

    @Test
    public void obtenerAnioTest() throws Exception {
        Assertions.assertEquals(fecha.getAnio(),fecha.obtenerAnio("2012"));
    }

    @Test 
    public void obtenerMesTest() throws Exception {
        Assertions.assertEquals(fecha.getMesNumerico(),fecha.obtenerMes("02"));
    }

    @Test
    public void obtenerDiaTest() throws Exception {
        Assertions.assertEquals(fecha.getDia(),fecha.obtenerDia("29"));
    }

    @Test
    public void imprimeFechaTest() throws Exception {
        Assertions.assertEquals("29 de febrero de 2012", fecha.imprimeFecha(false));
        Assertions.assertEquals("29/02/2012", fecha.imprimeFecha(true));
    }
}