/**
 * Crea una clase llamda Cuenta que tendrá los siguentes atributos: titular (que es una persona) y cantidad (puede tener decimales). El titular será obligatorio y la cantidad es opcional. Construye los siguientes métodos para la clase:
 *    · Un constructor
 *    · Los setters y getters para cada uno de los atributos. El atributo cantidad no se puede modificar directamente, sólo ingresando o retirando dinero.
 *    · mostrar(): Muestra los datos de la cuenta.
 *    · ingresar(centidad): se ingresa una cantidad a la cuenta, si la cantidad introducida es negativa, no se hará nada.
 *    · retirada(cantidad): se retira una cantidad a la cuenta. La cuenta puede estar en números rojos.
 *    · estaEnNumerosRojos(): indicará si la cuenta está en números rojos o no
 */

public class Cuenta {
    private Persona titular;
    private double cantidad;

    public Cuenta(Persona titular){
        this.titular=titular;
    }
    public Cuenta(Persona titular, double cantidad){
        this.titular=titular;
        this.cantidad=cantidad;
    }
    public void setTitular(Persona titular){
        this.titular=titular;
    }
    public Persona getTitular(){
        return this.titular;
    }
    public double getCantidad(){
        return this.cantidad;
    }
    public void mostrar(){
        System.out.println("Titular "+this.titular.toString());
        System.out.println("Saldo: "+this.cantidad);
    }
    public void ingresas(double ingreso){
        this.cantidad+=ingreso;
    }
    public void retirar(double reintegro){
        this.cantidad-=reintegro;
    }
    public boolean estaEnNumerosRojos(){
        return this.cantidad<0;
    }
}
