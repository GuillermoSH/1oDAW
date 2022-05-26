package es.iespuerto.ets.calculadora;

/**
 * Class with comun operations of a calculator functions
 * 
 * @author @GuillermoSH
 */
public class Operation {
    double number1;
    double number2;
    double result;
    char operation;

    /**
     * Default constructor
     */
    public Operation() {
        this.number1 = 0;
        this.number2 = 0;
        this.operation = '+';
        this.result = 0;
    }

    /**
     * Operation constructor with 4 parameters
     * 
     * @param number1   Number 1 of the operation
     * @param number2   Number 2 of the operation
     * @param result    Result of the operation
     * @param operation Operation executed
     */
    public Operation(double number1, double number2, double result, char operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.result = result;
        this.operation = operation;
    }

    /**
     * Operation constructor with 2 parameters and the operation type
     * 
     * @param number1   Number 1 of the operation
     * @param number2   Number 2 of the operation
     * @param operation Operation executed
     */
    public Operation(double number1, double number2, char operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }
    

    /**
     * Function that shows the results of an operation
     */
    @Override
    public String toString() {
        String resultStr = null;

        resultStr = this.number1 + " " + this.operation + " " + this.number2 + " = " + this.result;

        return resultStr;
    }
}
