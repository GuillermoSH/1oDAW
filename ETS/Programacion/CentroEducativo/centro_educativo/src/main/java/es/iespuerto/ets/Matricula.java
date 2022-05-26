package es.iespuerto.ets;

import java.util.*;
import java.io.*;

/**
 * Clase Matricula para guardar los datos de cada una de las matriculas
 * asociadas a los alumnos que lo soliciten
 * 
 * @author GuillermoSH
 * @version 0.9
 */
public class Matricula {
    private String dni;
    private String nombre;
    private List<Asignatura> asignaturas = new ArrayList<>();
    private Map<Asignatura, Double> notas = new HashMap<>();
    private String fecha;
    private double precio;
    private boolean pagada = false;
    private char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
            'H', 'L', 'C', 'K', 'E' };

    /**
     * Constructor parametrizado de la clase Matricula
     * 
     */
    public Matricula(int numDni, String nombre, List<Asignatura> asignaturas, Map<Asignatura, Double> notas,
            String fecha, boolean numerico) throws IOException {
        this.dni = obtenerDni(numDni, letras[numDni % 23]);
        this.nombre = nombre;
        this.asignaturas = asignaturas;
        this.notas = notas;
        this.fecha = obtenerFecha(fecha,numerico);
        this.precio = obtenerPrecio();
    }

    /**
     * Getter del parametro dni
     * 
     * @return el dni con la letra calculada
     */
    public String getDni() {
        return this.dni;
    }

    /**
     * Getter del parametro nombre
     * 
     * @return nombre del centro educativo
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Getter del parametro asignaturas
     * 
     * @return las asignaturas matriculadas por el alumno
     */
    public List<Asignatura> getAsignaturas() {
        return this.asignaturas;
    }

    /**
     * Getter del parametro notas
     * 
     * @return las notas asociadas a cada asignatura
     */
    public Map<Asignatura, Double> getNotas() {
        return this.notas;
    }

    public String getFecha() {
        return this.fecha;
    }

    /**
     * Getter del parametro precio
     * 
     * @return el precio total a pagar por la matricula
     */
    public double getPrecio() {
        return this.precio;
    }

    public boolean isPagada() {
        return this.pagada;
    }

    public String obtenerFecha(String fecha,boolean numerico) throws IOException {
        Fecha fechaObj = new Fecha(fecha);

        return fechaObj.imprimeFecha(numerico);
    }

    public double obtenerPrecio() {
        double precioTotal = 0;
        for (Asignatura asignatura : asignaturas) {
            precio += asignatura.getPrecio();
        }
        return precioTotal;
    }

    public String obtenerDni(int numDni, char letraDni) {
        return numDni + "" + letraDni;
    }

    public void pagarMatricula(double importe) {
        if (importe >= obtenerPrecio()) {
            this.pagada = true;
        }
    }

    public void exception(boolean condicion, String cadena) throws NoSuchFieldException {
        if (condicion) {
            throw new NoSuchFieldException("Error Matricula." + cadena);
        }
    }

    /**
     * Metodo que permite agregar asignaturas a la lista, si la matricula esta
     * pagada se anula la modificacion
     * 
     * @param newAsignatura nueva asignatura a añadir
     * @return true si se ha podido agregar a la lista la nueva asignatura
     * @throws Exception si ya existe la asignatura a añadir
     */
    public boolean agregarAsignatura(Asignatura newAsignatura) throws NoSuchFieldException {
        exception(pagada, "agregarAsignatura(): la matricula ya ha sido pagada.");
        exception(this.asignaturas.contains(newAsignatura), "agregarAsignatura(): la asignatura ya existe.");

        asignaturas.add(newAsignatura);

        return true;
    }

    /**
     * Metodo que permite eliminar asignaturas a no ser que no exista la asignatura,
     * y si la matricula esta pagada se anula la modificacion
     * 
     * @param oldAsignatura asignatura a eliminar
     * @return true si se ha podido eliminar la asignatura de la lista
     * @throws Exception si no existe en la lista la asignatura
     */
    public boolean eliminarAsignatura(Asignatura oldAsignatura) throws NoSuchFieldException {
        exception(pagada, "eliminarAsignatura(): la matricula ya ha sido pagada.");
        exception(!this.asignaturas.contains(oldAsignatura), "eliminarAsignatura(): no existe esa asignatura.");

        this.asignaturas.remove(oldAsignatura);

        return true;
    }

    /**
     * Metodo que permite editar asignaturas si existen dentro de la lista, y si la
     * matricula esta pagada se anula la modificacion
     * 
     * @param oldAsignatura antigua asignatura a modificar
     * @param newAsignatura nueva asignatura a añadir
     * @return true si se ha podido editar la asignatura
     * @throws Exception si no existe en la lista la asignatura
     */
    public boolean editarAsignatura(Asignatura oldAsignatura, Asignatura newAsignatura) throws NoSuchFieldException {
        exception(pagada, "editarAsignatura(): la matricula ya ha sido pagada.");
        exception(!this.asignaturas.contains(oldAsignatura), "editarAsignatura(): no existe esa asignatura.");

        this.asignaturas.set(asignaturas.indexOf(oldAsignatura), newAsignatura);

        return true;
    }

    /**
     * Metodo para devolver un string con el formato deseado de los datos de la
     * matricula
     * 
     * @param numerico si se desea la fecha con mes numerico o no
     * @return los datos de la matricula del alumno
     * @throws Exception si la fecha es incorrecta
     */
    public String imprimeMatricula() {
        return String.format("Matricula del alumno con dni: %s, en el centro %s, a %s", this.dni, this.nombre,
                this.fecha);
    }
}
