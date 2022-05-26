package es.iespuerto.ets.calculadora;

public class Division extends Operation {
    /**
     * Class constructor
     * 
     * @param number1 Number1 of Operation class
     * @param number2 Number2 of Operation class
     */
    public Division(double number1, double number2) {
        super(number1, number2, '/');
    }

    /**
     * Method to divide both parameters
     * 
     * @return Result of the division
     * @throws Exception
     */
    public double dividir() throws Exception {
        if (this.number2 == 0) {
            throw new Exception("Division 0 is not permitted.");
        }
        this.result = this.number1 / this.number2;
        return result;
    }
}
