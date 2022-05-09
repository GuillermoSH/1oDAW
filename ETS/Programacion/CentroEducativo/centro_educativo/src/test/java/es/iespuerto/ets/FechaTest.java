package es.iespuerto.ets;

import org.junit.jupiter.api.*;

public class FechaTest {
    Fecha fecha = null;

    @BeforeEach
    public void Before() throws Exception {
        fecha = new Fecha("29/02/2012");
    }

    @Test
    public void getDiaTest() throws Exception {
        Assertions.assertEquals(29, fecha.getDia());
    }

    @Test
    public void exceptionGetDiaTest() {
        // Comprobacion anio no bisiesto
        fecha = new Fecha("29/02/2013");
        Exception thrown1 = Assertions.assertThrows(Exception.class, () -> fecha.getDia());
        Assertions.assertTrue(thrown1.getMessage().contains("Error Fecha.getDia(): el dia es incorrecto."));
        // Comprobacion mes que no acaba en el 31
        fecha = new Fecha("31/04/2012");
        Exception thrown2 = Assertions.assertThrows(Exception.class, () -> fecha.getDia());
        Assertions.assertTrue(thrown2.getMessage().contains("Error Fecha.getDia(): el dia es incorrecto."));
    }

    @Test
    public void getMesNumericoTest() throws Exception {
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
    public void exceptionGetMesNumericoGetMesNombreTest() {
        // Comprobacion mes numerico
        fecha = new Fecha("29/13/2013");
        Exception thrown1 = Assertions.assertThrows(Exception.class, () -> fecha.getMesNumerico());
        Assertions.assertTrue(thrown1.getMessage().contains("Error Fecha.getMesNumerico(): el mes es incorrecto."));
        // Comprobacion mes en formato String
        fecha = new Fecha("31/00/2012");
        Exception thrown2 = Assertions.assertThrows(Exception.class, () -> fecha.getMesNombre());
        Assertions.assertTrue(thrown2.getMessage().contains("Error Fecha.getMesNombre(): el mes es incorrecto."));
    }

    @Test
    public void getAnioTest() throws Exception {
        Assertions.assertEquals(2012, fecha.getAnio());
    }

    @Test
    public void exceptionGetAnioTest() {
        // Comprobacion anio < 1999
        fecha = new Fecha("29/12/1989");
        Exception thrown1 = Assertions.assertThrows(Exception.class, () -> fecha.getAnio());
        Assertions.assertTrue(thrown1.getMessage().contains("Error Fecha.getAnio(): el anio es incorrecto."));
        // Comprobacion anio > 9999
        fecha = new Fecha("29/12/11239");
        Exception thrown2 = Assertions.assertThrows(Exception.class, () -> fecha.getAnio());
        Assertions.assertTrue(thrown2.getMessage().contains("Error Fecha.getAnio(): el anio es incorrecto."));
    }

    @Test
    public void imprimeFechaTest() throws Exception {
        Assertions.assertEquals("29 de febrero de 2012", fecha.imprimeFecha(false));
        Assertions.assertEquals("29/02/2012", fecha.imprimeFecha(true));
    }

    @Test
    public void exceptionImprimeFechaTest() throws Exception {
        // Comprobacion anio
        fecha = new Fecha("29/12/1989");
        Exception anio = Assertions.assertThrows(Exception.class, () -> fecha.imprimeFecha(true));
        Assertions.assertTrue(anio.getMessage().contains("Error Fecha.getAnio(): el anio es incorrecto."));
        // Comprobacion mes numerico
        fecha = new Fecha("29/13/2013");
        Exception mesNumerico = Assertions.assertThrows(Exception.class, () -> fecha.imprimeFecha(true));
        Assertions.assertTrue(mesNumerico.getMessage().contains("Error Fecha.getMesNumerico(): el mes es incorrecto."));
        // Comprobacion mes en formato String
        fecha = new Fecha("31/00/2012");
        Exception mesNombre = Assertions.assertThrows(Exception.class, () -> fecha.imprimeFecha(false));
        Assertions.assertTrue(mesNombre.getMessage().contains("Error Fecha.getMesNombre(): el mes es incorrecto."));
        // Comprobacion dia
        fecha = new Fecha("29/02/2013");
        Exception dia = Assertions.assertThrows(Exception.class, () -> fecha.imprimeFecha(false));
        Assertions.assertTrue(dia.getMessage().contains("Error Fecha.getDia(): el dia es incorrecto."));
    }
}