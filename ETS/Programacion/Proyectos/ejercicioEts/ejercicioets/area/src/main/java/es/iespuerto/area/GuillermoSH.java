package es.iespuerto.area;

/**
 * La clase creada debe de contener las siguientes propiedades:
 *  · String tipo. Qué será el tipo de area que va a almacenar (ej: triángulo, cuadrado, etc).
 *  · Integer valor1. Valor del primer parámetro para el cálculo del área.
 *  · Integer valor2. Valor del segundo parámetro para el cálculo del área.
 *  . Constructores:
 *      - Constructor por defecto, sin parámetros.
 *      - Constructor con un parámetro.
 *      - Constructor con dos parámetros.
 *  · Métodos:
 *      - CalculoArea. Método que recibe como parámetros valor1, y valor2.
 * @author Guillermo Sicilia Hernández
 * @version 1.0
 */
public class GuillermoSH {
    private String tipo;    // tipo de area que se va a almacenar
    private Integer valor1; // valor del primer parámetro para el cálculo del área
    private Integer valor2; // valor del segundo parámetro para el cálculo del área

    /**
     * Constructor por defecto, sin parámetros.
     */
    public GuillermoSH(){
    }
    /**
     * Contructor con un parámetro.
     * @param tipo tipo de área que se va a almacenar
     */
    public GuillermoSH(String tipo){
        this.tipo = tipo;
    }
    /**
     * Constructor con dos parámetros.
     * @param tipo tipo de área que se va a almacenar
     * @param valor1 valor del primer parámetro para el cálculo del área
     */
    public GuillermoSH(int valor2,int valor1){
        this.valor1 = valor1;
        this.valor2 = valor2;
    }
    /**
     * Getter de tipo
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * Setter de tipo
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /**
     * Getter de valor1
     * @return valor1
     */
    public Integer getValor1() {
        return valor1;
    }
    /**
     * Setter de valor1
     * @param valor1
     */
    public void setValor1(Integer valor1) {
        this.valor1 = valor1;
    }
    /**
     * Getter valor2
     * @return valor2
     */
    public Integer getValor2() {
        return valor2;
    }
    /**
     * Setter valor2
     * @param valor2
     */
    public void setValor2(Integer valor2) {
        this.valor2 = valor2;
    }
    /**
     * Método que recibe como parámetros valor1, y valor2
     * @param valor1 valor del primer parámetro para el cálculo del área
     * @param valor2 valor del segundo parámetro para el cálculo del área
     */
    public void CalculoArea(int valor1,int valor2){

    }
}