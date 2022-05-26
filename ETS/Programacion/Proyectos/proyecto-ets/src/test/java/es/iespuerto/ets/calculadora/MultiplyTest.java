package es.iespuerto.ets.calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class MultiplyTest {
    Multiply multiply = null;

    @BeforeEach
    public void BeforeEach() {
        if (multiply == null) {
            multiply = new Multiply(3, 2);
        }
    }

    @Test
    public void operationSumTest() {
        double solution = 0;
        solution = multiply.multiply();
        assertEquals(6.0, solution, "Could not do this operation");
    }
}