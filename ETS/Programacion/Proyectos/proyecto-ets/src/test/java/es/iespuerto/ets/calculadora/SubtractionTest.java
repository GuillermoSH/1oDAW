package es.iespuerto.ets.calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class SubtractionTest {
    Subtraction subtraction;

    @BeforeEach
    public void BeforeEach() {
        if (subtraction == null) {
            subtraction = new Subtraction(6, 2);
        }
    }

    @Test
    public void operationSumTest() {
        double solution = 0;
        solution = subtraction.subtraction();
        assertEquals(4, solution, "Could not do this operation");
    }
}