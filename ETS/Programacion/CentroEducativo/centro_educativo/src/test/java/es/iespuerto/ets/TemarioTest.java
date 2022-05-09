package es.iespuerto.ets;

import java.util.*;
import org.junit.jupiter.api.*;

public class TemarioTest {
    Temario temario = null;
    Tema tema1 = null;
    Tema tema2 = null;
    Tema tema3 = null;
    ArrayList<Tema> temas = null;

    @BeforeEach
    public void Before() {
        tema1 = new Tema("Tema1", 120);
        tema2 = new Tema("Tema2", 40);
        tema3 = new Tema("Tema3", 80);
        temas = new ArrayList<>();

        temas.add(tema1);
        temas.add(tema2);

        temario = new Temario("Temario Introduccion", temas);
    }

    @Test
    public void getNombreTest() {
        Assertions.assertEquals("TEMARIO INTRODUCCION", temario.getNombre());
    }

    @Test
    public void getTemas() {
        Assertions.assertEquals(temas, temario.getTemas());
    }

    @Test
    public void getHorasTotalesTest() {
        Assertions.assertEquals(tema1.getHoras() + tema2.getHoras(), temario.getHorasTotales());
    }

    @Test
    public void agregarTemaTest() throws Exception {
        Assertions.assertTrue(temario.agregarTema(tema3));
    }

    @Test
    public void exceptionAgregarTemaTest() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> temario.agregarTema(tema1));

        Assertions.assertTrue(thrown.getMessage().contains("Error Temario.agregarTema(): el tema ya existe."));
    }

    @Test
    public void eliminarTemaTest() throws Exception {
        Assertions.assertTrue(temario.eliminarTema(tema1));
    }

    @Test
    public void exceptionEliminarTemaTest() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> temario.eliminarTema(tema3));

        Assertions.assertTrue(thrown.getMessage().contains("Error Temario.eliminarTema(): no existe ese tema."));
    }

    @Test
    public void editarTemaTest() throws Exception {
        Tema tema4 = new Tema("Tema4", 50);

        Assertions.assertTrue(temario.editarTema(tema2, tema4));
    }

    @Test
    public void exceptionEditarTemaTest() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> temario.editarTema(tema3,tema1));

        Assertions.assertTrue(thrown.getMessage().contains("Error Temario.editarTema(): no existe ese tema"));
    }

    @Test
    public void imprimeTemarioTest() {
        Assertions.assertEquals(String.format("Temario %s con %d horas totales: %s", temario.getNombre(), temario.getHorasTotales(), temas.toString()), temario.imprimeTemario());
    }
}
