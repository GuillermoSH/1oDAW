package es.iespuerto.ets;
/**
 * Crear una clase llamada Cuenta que tendrá los siguientes atributos: titular y cantidad.
 * El titular será obligatorio y la cantidad es opcional. Crea dos constructores que cumpla
 * lo anterior.
 * Crea sus métodos get, set y toString.
 * 
 * Tendrá dos métodos especiales:
 *   · ingresar (double cantidad): se ingresa una cantidad a la cuenta, si la cantidad 
 *   introducida es negativa, no se hará nada.
 *   · retirar (double cantidad): se retira una cantidad a la cuenta, si restando la 
 *   cantidad actual a la que nos pasan es negativa, la cantidad de la cuenta para a ser 0.
 * 
 * @author Guillermo Sicilia Hernández
 * @version 0.1
 */
public class Cuenta {
    private String titular;
    private double cantidad;

    /**
     * Constructor de la clase en el caso en el que no se da uso de la variable cantidad 
     * al ser opcional.
     * @param titular
     */
    public Cuenta(String titular) {
        this.titular = titular;
    }

    /**
     * Constructor de la clase en el caso en el que se incluyen ambas variables.
     * @param titular
     * @param cantidad
     */
    public Cuenta(String titular, double cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }

    /**
     * Método setter para asignar un valor inicial a titular, permitiendo acceso al usuario
     * para que pueda modificar dicho atributo.
     * @param titular
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * Método setter para asignar un valor inicial a cantidad, permitiendo acceso al usuario
     * para que pueda modificar dicho atributo.
     * @param cantidad
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Método getter que permite obtener el valor ya asignado a titular y poder usarlo en
     * otros métodos.
     * @return La variable titular.
     */
    public String getTitular() {
        return this.titular;
    }

    /**
     * Método getter que permite obtener el valor ya asignado a cantidad y poder usarlo en
     * otros métodos.
     * @return La variable cantidad.
     */
    public double getCantidad() {
        return this.cantidad;
    }

    /**
     * Método creado para dar la opción al usuario de ingresar dinero en su cuenta y en caso
     * de que el ingreso sea menor a 0, es decir, que el ingreso sea negativo, el método no
     * realiza ninguna acción.
     * @param ingreso
     */
    public void ingresar(double ingreso) {
        if (ingreso > 0) {
            this.cantidad += ingreso;
        }
    }

    /**
     * Método creado para dar la opción al usuario de retirar dinero de su cuenta y en caso 
     * de que la cantidad de su cuenta se quede en números rojos, poner el valor de la
     * cantidad a 0.
     * @param reintegro
     */
    public void retirar(double reintegro) {
        this.cantidad -= reintegro;
        if (this.cantidad < 0) {
            this.cantidad = 0;
        }
    }

    /**
     * Método toString sobreescrito para que nos devuelva la información detallada de cada
     * cuenta de cada titular.
     */
    @Override
    public String toString() {
        return "[Cliente:\n· Titular:"+this.titular+"\n· Cantidad: "+this.cantidad+"]";
    }
}