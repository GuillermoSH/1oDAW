package es.iespuerto.ets;

import java.util.*;
import org.junit.jupiter.api.*;

public class ProfesorTest {
    Temario temario = null;
    ArrayList<Tema> temas = null;
    Tema tema1 = null;
    Tema tema2 = null;
    Tema tema3 = null;
    Asignatura asignatura1 = null;
    Asignatura asignatura2 = null;
    Asignatura asignatura3 = null;
    ArrayList<Asignatura> asignaturas = null;
    Profesor profesor = null;

    @BeforeEach
    public void beforeEach() throws Exception {
        // Creacion de temas
        tema1 = new Tema("Tema1", 120);
        tema2 = new Tema("Tema2", 40);
        tema3 = new Tema("Tema3", 80);
        // Creacion de temario y de la lista de temas
        temas = new ArrayList<>();
        temario = new Temario("Temario Introduccion", temas);
        // Creacion de las asignaturas y la lista de asignaturas
        asignatura1 = new Asignatura("Programacion", temario);
        asignatura2 = new Asignatura("Entornos", temario);
        asignatura3 = new Asignatura("BB.DD.", temario);
        asignaturas = new ArrayList<>();
        // Creacion del profesor
        profesor = new Profesor("maRIa CaNDELarIa", "hernAnDeZ pEREz", "Licenciada en Ingenieria Informatica",
                asignaturas);

        profesor.agregarAsignatura(asignatura1);
    }

    @Test
    public void getNombreTest() {
        Assertions.assertEquals("Maria Candelaria", profesor.getNombre());

        profesor = new Profesor("antoNIO", "hernAndEZ PErEz", "Titulitis", asignaturas);
        Assertions.assertEquals("Antonio", profesor.getNombre());
    }

    @Test
    public void getApellidosTest() {
        Assertions.assertEquals("Hernandez Perez", profesor.getApellidos());

        profesor = new Profesor("antoNIO", "hernAndEZ", "Titulitis", asignaturas);
        Assertions.assertEquals("Hernandez", profesor.getApellidos());
    }

    @Test
    public void getTitulacionTest() {
        Assertions.assertEquals("Licenciada en Ingenieria Informatica", profesor.getTitulacion());
    }

    @Test
    public void getAsignaturaseTest() {
        Assertions.assertEquals(asignaturas, profesor.getAsignaturas());
    }

    @Test
    public void agregarAsignaturaTest() throws Exception {
        Assertions.assertTrue(profesor.agregarAsignatura(asignatura2));
    }

    @Test
    public void exceptionAgregarAsignaturaTest() {
        Exception thrown1 = Assertions.assertThrows(Exception.class,
                () -> profesor.agregarAsignatura(asignatura1));

        Assertions.assertTrue(
                thrown1.getMessage().contains("Error Profesor.agregarAsignatura(): la asignatura ya existe."));

        // Comprobacion de la Exception por superar el limite de horas totales
        Tema tema4 = new Tema("tema4", 3000);
        temas.add(tema4);
        Temario temario = new Temario("TemarioFOL", temas);
        Asignatura asignatura4 = new Asignatura("FOL", temario);
        asignaturas.add(asignatura4);

        Exception thrown2 = Assertions.assertThrows(Exception.class,
                () -> profesor.agregarAsignatura(asignatura4));

        Assertions.assertTrue(
                thrown2.getMessage().contains(
                        "Error Profesor.agregarAsignatura(): el límite de horas totales a impartir se ha superado."));
    }

    @Test
    public void eliminarAsignaturaTest() throws Exception {
        Assertions.assertTrue(profesor.eliminarAsignatura(asignatura1));
    }

    @Test
    public void exceptionEliminarAsignaturaTest() {
        Exception thrown = Assertions.assertThrows(Exception.class,
                () -> profesor.eliminarAsignatura(asignatura2));

        Assertions.assertTrue(
                thrown.getMessage().contains("Error Profesor.eliminarAsignatura(): no existe esa asignatura."));
    }

    @Test
    public void editarAsignaturaTest() throws Exception {
        Assertions.assertTrue(profesor.editarAsignatura(asignatura1, asignatura3));
    }

    @Test
    public void exceptionEditarAsignaturaTest() {
        Exception thrown1 = Assertions.assertThrows(Exception.class,
                () -> profesor.editarAsignatura(asignatura2, asignatura3));

        Assertions.assertTrue(
                thrown1.getMessage().contains("Error Profesor.editarAsignatura: no existe esa asignatura."));

        // Comprobacion de la Exception por superar el limite de horas totales
        Tema tema4 = new Tema("tema4", 3100);
        temas.add(tema4);
        Temario temario = new Temario("TemarioFOL", temas);
        Asignatura asignatura4 = new Asignatura("FOL", temario);
        asignaturas.add(asignatura4);

        Exception thrown2 = Assertions.assertThrows(Exception.class,
                () -> profesor.editarAsignatura(asignatura1, asignatura4));

        Assertions.assertTrue(
                thrown2.getMessage().contains(
                        "Error Profesor.editarAsignatura(): el límite de horas totales a impartir se ha superado."));
    }

    @Test
    public void imprimeProfesorTest() {
        Assertions.assertEquals(
                String.format("Profesor: %s %s, con titulación: %s y asignaturas impartidas:  %s", profesor.getNombre(),
                        profesor.getApellidos(), profesor.getTitulacion(), profesor.getAsignaturas()),
                profesor.imprimeProfesor());
    }
}
