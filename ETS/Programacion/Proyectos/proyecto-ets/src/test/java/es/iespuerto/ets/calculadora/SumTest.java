package es.iespuerto.ets.calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class SumTest {
    Sum sum;

    @BeforeEach
    public void BeforeEach() {
        if (sum == null) {
            sum = new Sum(3, 2);
        }
    }

    @Test
    public void operationSumTest() {
        double solution = 0;
        solution = sum.sum();
        assertEquals(5.0, solution, "Could not do this operation");
    }
}