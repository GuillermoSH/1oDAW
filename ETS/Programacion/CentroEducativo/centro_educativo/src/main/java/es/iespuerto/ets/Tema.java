package es.iespuerto.ets;

/**
 * Clase de almacenamiento de datos relacionados con el tema de cada temario de
 * las asignaturas impartidas
 * 
 * @author GuillermoSH
 * @version 1.1
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
     * Metodo para devolver un string con los datos de cada tema con el formato dado
     * 
     * @return los datos de cada tema
     */
    public String imprimeTema() {
        return String.format("%s con %d horas", this.nombre, this.horas);
    }
}
