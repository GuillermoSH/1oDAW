package es.iespuerto.ets;

import java.util.*;
import java.io.*;
import org.junit.jupiter.api.*;

public class MatriculaTest {
    Temario temario = null;
    ArrayList<Tema> temas = null;
    Tema tema1 = null;
    Tema tema2 = null;
    Tema tema3 = null;
    Asignatura asignatura1 = null;
    Asignatura asignatura2 = null;
    Asignatura asignatura3 = null;
    ArrayList<Asignatura> asignaturas = null;
    Map<Asignatura, Double> notas = new HashMap<>();
    Matricula alumno1 = null;

    @BeforeEach
    public void beforeEach() throws IOException{
        // Creacion de temas
        tema1 = new Tema("Tema1", 120);
        tema2 = new Tema("Tema2", 40);
        tema3 = new Tema("Tema3", 80);
        // Creacion de temario y de la lista de temas
        temas = new ArrayList<>();
        temas.add(tema1);
        temas.add(tema2);
        temario = new Temario("Temario Introduccion", temas);
        // Creacion de las asignaturas y la lista de asignaturas
        asignatura1 = new Asignatura("Programacion", temario);
        asignatura2 = new Asignatura("Entornos", temario);
        asignatura3 = new Asignatura("BB.DD.", temario);
        asignaturas = new ArrayList<>();
        asignaturas.add(asignatura1);
        // Creacion de las notas del alumno
        notas.put(asignatura1, 5.0);
        notas.put(asignatura2, 6.1);
        notas.put(asignatura3, 8.5);
        // Creacion de la matricula del alumno1
        alumno1 = new Matricula(43383780, "IES PUERTO", asignaturas, notas, "22-02-2022",true);
    }

    @Test
    public void getDniTest() {
        Assertions.assertEquals("43383780F", alumno1.getDni());
    }

    @Test
    public void getNombreTest() {
        Assertions.assertEquals("IES PUERTO", alumno1.getNombre());
    }

    @Test
    public void getAsignaturasTest() {
        Assertions.assertEquals(asignaturas, alumno1.getAsignaturas());
    }

    @Test
    public void getNotasTest() {
        Assertions.assertEquals(notas, alumno1.getNotas());
    }

    @Test
    public void getPrecioTest() {
        asignaturas.clear();

        asignaturas.add(asignatura1);
        asignaturas.add(asignatura2);

        double precioTotal = asignatura1.getPrecio() + asignatura2.getPrecio();
        alumno1.pagarMatricula(precioTotal);

        Assertions.assertEquals(precioTotal, alumno1.getPrecio());
    }

    @Test
    public void isPagadaTest() {
        alumno1.pagarMatricula(alumno1.getPrecio());
        Assertions.assertTrue(alumno1.isPagada());
    }

    @Test
    public void agregarAsignaturaTest() throws Exception {
        Assertions.assertTrue(alumno1.agregarAsignatura(asignatura2));
    }

    @Test
    public void exceptionAgregarAsignaturaTest() {
        Exception thrown1 = Assertions.assertThrows(Exception.class, () -> alumno1.agregarAsignatura(asignatura1));

        Assertions.assertTrue(
                thrown1.getMessage().contains("Error Matricula.agregarAsignatura(): la asignatura ya existe."));

        // Exception cuando se ha pagado la matricula
        alumno1.pagarMatricula(alumno1.getPrecio());
        Exception thrown2 = Assertions.assertThrows(Exception.class, () -> alumno1.agregarAsignatura(asignatura1));

        Assertions.assertTrue(
                thrown2.getMessage().contains("Error Matricula.agregarAsignatura(): la matricula ya ha sido pagada."));
    }

    @Test
    public void eliminarAsignaturaTest() throws Exception {
        Assertions.assertTrue(alumno1.eliminarAsignatura(asignatura1));
    }

    @Test
    public void exceptionEliminarAsignaturaTest() {
        Exception thrown = Assertions.assertThrows(Exception.class, () -> alumno1.eliminarAsignatura(asignatura2));

        Assertions.assertTrue(
                thrown.getMessage().contains("Error Matricula.eliminarAsignatura(): no existe esa asignatura."));
        
        // Exception cuando se ha pagado la matricula
        alumno1.pagarMatricula(alumno1.getPrecio());
        Exception thrown2 = Assertions.assertThrows(Exception.class, () -> alumno1.eliminarAsignatura(asignatura1));

        Assertions.assertTrue(
                thrown2.getMessage().contains("Error Matricula.eliminarAsignatura(): la matricula ya ha sido pagada."));
    }

    @Test
    public void editarAsignaturaTest() throws Exception {
        Assertions.assertTrue(alumno1.editarAsignatura(asignatura1, asignatura2));
    }

    @Test
    public void exceptionEditarAsignaturaTest() {
        Exception thrown = Assertions.assertThrows(Exception.class,
                () -> alumno1.editarAsignatura(asignatura2, asignatura3));

        Assertions.assertTrue(
                thrown.getMessage().contains("Error Matricula.editarAsignatura(): no existe esa asignatura."));

        // Exception cuando se ha pagado la matricula
        alumno1.pagarMatricula(alumno1.getPrecio());
        Exception thrown2 = Assertions.assertThrows(Exception.class, () -> alumno1.editarAsignatura(asignatura1,asignatura2));

        Assertions.assertTrue(
                thrown2.getMessage().contains("Error Matricula.editarAsignatura(): la matricula ya ha sido pagada."));
    }

    @Test
    public void imprimeMatriculaTest() throws Exception {
        Assertions.assertEquals("Matricula del alumno con dni: " + alumno1.getDni() + ", en el centro "
                + alumno1.getNombre() + ", a " + alumno1.getFecha(), alumno1.imprimeMatricula());
    }
}
