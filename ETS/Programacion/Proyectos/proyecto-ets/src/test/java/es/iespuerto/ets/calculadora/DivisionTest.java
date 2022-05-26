package es.iespuerto.ets.calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class DivisionTest {
    Division division = null;

    @BeforeEach
    public void beforeEach() {
        division = new Division(6,2);
    }

    @Test
    public void operacionDivisionTest() {
        double solution;
        try {
            solution = division.dividir();
        } catch (Exception e) {
            fail("Not controlled error was found.");
        }
    }

    @Test
    public void divisionPorCeroTest() {
        double solution = 0;
        division = new Division(1, 0);
        try {
            solution = division.dividir();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Division 0"), "No se obtiene el mensaje esperado.");
        }
    }
}
