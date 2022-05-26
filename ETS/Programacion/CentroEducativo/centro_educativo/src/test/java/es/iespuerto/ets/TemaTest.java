package es.iespuerto.ets;

import org.junit.jupiter.api.*;

public class TemaTest {
    Tema tema = null;

    @BeforeEach
    public void Before() {
        tema = new Tema("Tema1", 120);
    }

    @Test
    public void getNombretest() {
        Assertions.assertEquals("tema1", tema.getNombre());
    }

    @Test
    public void getHorasTest() {
        Assertions.assertEquals(120, tema.getHoras());
    }

    @Test
    public void imprimeTemaTest() {
        Assertions.assertEquals("tema1 con 120 horas", tema.imprimeTema());
    }
}
