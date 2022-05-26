package es.iespuerto.ets.calculadora;

public class Multiply extends Operation {
    /**
     * Class constructor
     * 
     * @param number1 Number1 of Operation class
     * @param number2 Number2 of Operation class
     */
    public Multiply(double number1, double number2) {
        super(number1, number2, '*');
    }

    /**
     * Method to divide both parameters
     * 
     * @return Result of the multiply
     */
    public double multiply() {
        return this.result = this.number1 * this.number2;
    }
}