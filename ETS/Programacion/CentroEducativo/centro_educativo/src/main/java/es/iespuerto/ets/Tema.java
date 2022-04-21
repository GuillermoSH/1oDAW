package es.iespuerto.ets;

/**
 * Clase de almacenamiento de datos relacionados con el tema de cada temario de
 * las asignaturas impartidas
 */
public class Tema {
    private String nombre;
    private int horas;

    /**
     * Contructor parametrizado de la clase Tema.
     * 
     * @param nombre nombre del tema
     * @param horas  numero de horas dedicadas al tema
     */
    public Tema(String nombre, int horas) {
        this.nombre = nombre.toLowerCase();
        this.horas = horas;
    }

    /**
     * Getter de la variable tema.
     * 
     * @return nombre del tema
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Getter de la variable hora.
     * 
     * @return numero de horas dedicadas al tema
     */
    public int getHoras() {
        return this.horas;
    }

    /**
     * Metodo sobrecargado del metodo toString() de java para imprimir los datos de
     * la clase
     */
    @Override
    public String toString() {
        return String.format("[Nombre: %s, Horas: %d]", this.nombre, this.horas);
    }
}
