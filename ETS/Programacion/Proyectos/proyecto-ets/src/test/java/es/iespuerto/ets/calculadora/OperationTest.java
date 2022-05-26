package es.iespuerto.ets.calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OperationTest {

    Operation operation = null;

    @BeforeEach
    public void beforeEach() {
        operation = new Operation(1, 2, 3, '+');
    }

    @Test
    void defaultConstructorTest() {
        operation = new Operation();
        assertNotNull(operation, "Object operation cannot be null");
    }

    @Test
    void fourParametersConstructorTest() {
        assertNotNull(operation, "Object operation cannot be null");
    }

    @Test
    void toStringTest() {
        assertTrue(operation.toString().contains("= 3"),"Expected string was not obtained");
    }
}
