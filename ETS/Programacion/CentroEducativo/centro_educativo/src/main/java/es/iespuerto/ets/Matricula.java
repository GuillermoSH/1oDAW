package es.iespuerto.ets;

import java.util.*;

/**
 * Clase Matricula para guardar los datos de cada una de las matriculas
 * asociadas a los alumnos que lo soliciten
 * 
 * @author GuillermoSH
 * @version 0.9
 */
public class Matricula {
    private int numeroDni;
    private String dni;
    private String nombre;
    private ArrayList<Asignatura> asignaturas = new ArrayList<>();
    private Map<Asignatura, Double> notas = new HashMap<>();
    private String fecha;
    private double precio;
    private boolean pagada = false;

    /**
     * Constructor parametrizado de la clase Matricula
     * 
     * @param numeroDni   dni sin letra del alumno
     * @param nombre      nombre del centro educativo
     * @param asignaturas asignaturas matriculadas por el alumno
     * @param notas       notas asociadas a cada asignatura
     * @param fecha       fecha de realizacion de la matricula
     */
    public Matricula(int numeroDni, String nombre, ArrayList<Asignatura> asignaturas, Map<Asignatura, Double> notas,
            String fecha) {
        this.numeroDni = numeroDni;
        this.nombre = nombre;
        this.asignaturas = asignaturas;
        this.notas = notas;
        this.fecha = fecha;
    }

    /**
     * Getter del parametro numeroDni
     * 
     * @return el dni sin letra
     */
    public int getNumeroDni() {
        return this.numeroDni;
    }

    /**
     * Getter del parametro dni
     * 
     * @return el dni con la letra calculada
     */
    public String getDni() {
        char letraDni = calculaLetraDNI(this.numeroDni);
        this.dni = this.numeroDni + "" + letraDni;

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
    public ArrayList<Asignatura> getAsignaturas() {
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

    /**
     * Getter del parametro fecha
     * 
     * @param numerico si se desea la fecha con mes numerico o no
     * @return la fecha comprobada mediante la clase {@link Fecha}
     * @throws Exception si la fecha es incorrecta
     */
    public String getFecha(boolean numerico) throws Exception {
        Fecha fechaObj = new Fecha(this.fecha);
        this.fecha = fechaObj.imprimeFecha(numerico);

        return this.fecha;
    }

    /**
     * Getter del parametro precio
     * 
     * @return el precio total a pagar por la matricula
     */
    public double getPrecio() {
        this.precio = 0;
        for (Asignatura asignatura : asignaturas) {
            this.precio += asignatura.getPrecio();
        }

        return this.precio;
    }

    /**
     * Getter del parametro pagada
     * 
     * @param importe que da el usuario para pagar la matricula
     * @return si se ha pagado o no la tasa de la matricula
     */
    public boolean isPagada(double importe) {
        if (importe >= getPrecio()) {
            this.pagada = true;
        }
        return this.pagada;
    }

    /**
     * Metodo para el calculo de la letra del DNI a partir del numero del mismo
     * 
     * @param numeroDni dni sin letra del alumno
     * @return letra resultante del calculo
     */
    private char calculaLetraDNI(int numeroDni) {
        char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
                'L', 'C', 'K', 'E' };
        int resto = numeroDni % 23;

        return (char) (letras[resto]);
    }

    /**
     * Metodo que permite agregar asignaturas a la lista, si la matricula esta
     * pagada se anula la modificacion
     * 
     * @param newAsignatura nueva asignatura a añadir
     * @return true si se ha podido agregar a la lista la nueva asignatura
     * @throws Exception si ya existe la asignatura a añadir
     */
    public boolean agregarAsignatura(Asignatura newAsignatura) throws Exception {
        if (pagada) {
            throw new Exception("Error Matricula.agregarAsignatura(): la matricula ya ha sido pagada.");
        }

        if (this.asignaturas.contains(newAsignatura)) {
            throw new Exception("Error Matricula.agregarAsignatura(): la asignatura ya existe.");
        }
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
    public boolean eliminarAsignatura(Asignatura oldAsignatura) throws Exception {
        if (pagada) {
            throw new Exception("Error Matricula.eliminarAsignatura(): la matricula ya ha sido pagada.");
        }

        if (this.asignaturas.contains(oldAsignatura)) {
            this.asignaturas.remove(oldAsignatura);
            return true;
        } else {
            throw new Exception("Error Matricula.eliminarAsignatura(): no existe esa asignatura.");
        }
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
    public boolean editarAsignatura(Asignatura oldAsignatura, Asignatura newAsignatura) throws Exception {
        if (pagada) {
            throw new Exception("Error Matricula.editarAsignatura(): la matricula ya ha sido pagada.");
        }

        if (this.asignaturas.contains(oldAsignatura)) {
            this.asignaturas.set(this.asignaturas.indexOf(oldAsignatura), newAsignatura);
            return true;
        } else {
            throw new Exception("Error Matricula.editarAsignatura: no existe esa asignatura.");
        }
    }

    /**
     * Metodo para devolver un string con el formato deseado de los datos de la
     * matricula
     * 
     * @param numerico si se desea la fecha con mes numerico o no
     * @return los datos de la matricula del alumno
     * @throws Exception si la fecha es incorrecta
     */
    public String imprimeMatricula(boolean numerico) throws Exception {
        return String.format("Matricula del alumno con dni: %s, en el centro %s, a %s", getDni(), this.nombre,
                getFecha(numerico));
    }
}
