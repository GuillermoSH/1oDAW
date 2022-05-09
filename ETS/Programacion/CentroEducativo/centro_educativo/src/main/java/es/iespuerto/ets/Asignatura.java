package es.iespuerto.ets;

/**
 * Clase asignatura para el almacenaje de los datos de temarios asignados a cada
 * asignatura
 * 
 * @author GuillermoSH
 * @version 0.7
 */
public class Asignatura {
    private String nombre;
    private Temario temario;
    private double precio;

    /**
     * Constructor parametrizado de la clase Asignatura
     * 
     * @param nombre  nombre de la asignatura
     * @param temario objeto Temario de la asignatura
     */
    public Asignatura(String nombre, Temario temario) {
        this.nombre = nombre;
        this.temario = temario;
    }

    /**
     * Getter del parametro nombre de la clase
     * 
     * @return nombre de la asignatura
     */
    public String getNombre() {
        this.nombre = this.nombre.substring(0, 1).toUpperCase() + this.nombre.substring(1).toLowerCase();

        return this.nombre;
    }

    /**
     * Getter del objeto temario de la clase Temario
     * 
     * @return objeto con el temario de la asignatura
     */
    public Temario getTemario() {
        return this.temario;
    }

    /**
     * Getter del parametro precio de la clase Asignatura
     * 
     * @return precio total por horas impartidas del temario
     */
    public double getPrecio() {
        this.precio = this.temario.getHorasTotales() * 3.755;

        return this.precio;
    }

    /**
     * Metodo para devolver un string con los datos de cada asignatura con el
     * formato deseado
     * 
     * @return los datos de cada asignatura con el formato deseado
     */
    public String imprimeAsignatura() {
        return String.format("Asignatura %s con un precio de %.2f euros: %s", getNombre(), getPrecio(), this.temario);
    }
}
