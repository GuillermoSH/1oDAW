package es.iespuerto.ets.calculadora;

public class Sum extends Operation {
    /**
     * Class constructor
     * 
     * @param number1 Number1 of Operation class
     * @param number2 Number2 of Operation class
     */
    public Sum(double number1, double number2) {
        super(number1, number2, '+');
    }

    /**
     * Method to divide both parameters
     * 
     * @return Result of the sum
     */
    public double sum() {
        this.result = this.number1 + this.number2;
        return result; 
    }
}
