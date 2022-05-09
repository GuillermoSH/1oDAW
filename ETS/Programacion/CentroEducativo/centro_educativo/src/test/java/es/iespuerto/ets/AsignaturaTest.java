package es.iespuerto.ets;

import java.util.*;
import org.junit.jupiter.api.*;

public class AsignaturaTest {
    Asignatura asignatura = null;
    Temario temario = null;
    ArrayList<Tema> temas = null;
    Tema tema1 = null;
    Tema tema2 = null;
    Tema tema3 = null;

    @BeforeEach
    public void beforeEach() {
        tema1 = new Tema("Tema1", 120);
        tema2 = new Tema("Tema2", 40);
        tema3 = new Tema("Tema3", 80);
        temas = new ArrayList<>();
        temario = new Temario("Temario Introduccion", temas);
        asignatura = new Asignatura("Programacion", temario);
    }

    @Test
    public void getNombreTest() {
        Assertions.assertEquals("Programacion", asignatura.getNombre());
    }

    @Test
    public void getTemario() {
        Assertions.assertEquals(temario, asignatura.getTemario());
    }

    @Test
    public void getPrecio() {
        Assertions.assertEquals(temario.getHorasTotales() * 3.755, asignatura.getPrecio());
    }

    @Test
    public void imprimeAsignaturaTest() {
        Assertions.assertEquals(String.format("Asignatura %s con un precio de %.2f euros: %s", asignatura.getNombre(),
                asignatura.getPrecio(), asignatura.getTemario()), asignatura.imprimeAsignatura());
    }
}
