package es.iespuerto.ets;

import java.util.*;

/**
 * Clase Profesor para el almacenaje de asignaturas impartidas por el mismo y
 * comprobacion de que no supera el limite de 3000h de docencia.
 * 
 * @author GuillermoSH
 * @version 0.2
 */
public class Profesor {
    private String nombre;
    private String apellidos;
    private String titulacion;
    private ArrayList<Asignatura> asignaturas = new ArrayList<>();

    /**
     * Constructor parametrizado de la clase Profesor
     * 
     * @param nombre      nombre del profesor compuesto o simple
     * @param apellidos   apellidos del profesor
     * @param titulacion  titulacion del profesor
     * @param asignaturas asignaturas impartidas por el profesor
     */
    public Profesor(String nombre, String apellidos, String titulacion, ArrayList<Asignatura> asignaturas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.titulacion = titulacion;
        this.asignaturas = asignaturas;
    }

    /**
     * Getter del parametro nombre de la clase Profesor
     * 
     * @return el nombre del profesor en cuestion capitalizado
     * @see #capitalizarCadenaCompuesta(String)
     * @see #capitalizarCadenaSimple(String)
     */
    public String getNombre() {
        if (this.nombre.contains(" ")) {
            this.nombre = capitalizarCadenaCompuesta(this.nombre);
        } else {
            this.nombre = capitalizarCadenaSimple(this.nombre);
        }

        return this.nombre;
    }

    /**
     * Getter del parametro apellidos
     * 
     * @return apellidos del profesor sea 1 o 2 capitalizados
     * @see #capitalizarCadenaCompuesta(String)
     * @see #capitalizarCadenaSimple(String)
     */
    public String getApellidos() {
        if (this.apellidos.contains(" ")) {
            this.apellidos = capitalizarCadenaCompuesta(this.apellidos);
        } else {
            this.apellidos = capitalizarCadenaSimple(this.apellidos);
        }

        return this.apellidos;
    }

    /**
     * Getter del parametro titulacion
     * 
     * @return titulacion del profesor
     */
    public String getTitulacion() {
        return this.titulacion;
    }

    /**
     * Getter de la lista de objetos Asignaturas
     * 
     * @return lista de objetos de la clase Asignatura
     */
    public ArrayList<Asignatura> getAsignaturas() {
        return this.asignaturas;
    }

    /**
     * Metodo que permite agregar asignaturas a impartir por el profesor siempre y
     * cuando no {@link #superaLimiteHorasTotales(Temario)}, ni existe ya dentro de
     * la lista
     * 
     * @param newAsignatura nueva asignatura a añadir
     * @return true si se ha podido agregar a la lista la nueva asignatura
     * @throws Exception si se supera el limite de horas a impartir o si ya existe
     *                   la asignatura a añadir
     */
    public boolean agregarAsignatura(Asignatura newAsignatura) throws Exception {
        for (int i = 0; i < asignaturas.size(); i++) {
            Asignatura asignatura = asignaturas.get(i);

            if (superaLimiteHorasTotales(asignatura.getTemario())) {
                throw new Exception(
                        "Error Profesor.agregarAsignatura(): el límite de horas totales a impartir se ha superado.");
            }
        }

        if (this.asignaturas.contains(newAsignatura)) {
            throw new Exception("Error Profesor.agregarAsignatura(): la asignatura ya existe.");
        }
        asignaturas.add(newAsignatura);

        return true;
    }

    /**
     * Metodo que permite eliminar asignaturas que imparte por el profesor a no ser
     * que no exista la asignatura
     * 
     * @param oldAsignatura asignatura a eliminar
     * @return true si se ha podido eliminar la asignatura de la lista
     * @throws Exception si no existe la asignatura
     */
    public boolean eliminarAsignatura(Asignatura oldAsignatura) throws Exception {
        if (this.asignaturas.contains(oldAsignatura)) {
            this.asignaturas.remove(oldAsignatura);
            return true;
        } else {
            throw new Exception("Error Profesor.eliminarAsignatura(): no existe esa asignatura.");
        }
    }

    /**
     * Metodo que permite editar asignaturas a impartir por el profesor siempre y
     * cuando no {@link #superaLimiteHorasTotales(Temario)}, si existe dentro de
     * la lista
     * 
     * @param oldAsignatura antigua asignatura a modificar
     * @param newAsignatura nueva asignatura a añadir
     * @return true si se ha podido agregar a la lista la nueva asignatura
     * @throws Exception si se supera el limite de horas a impartir o si no existe
     *                   en la lista
     */
    public boolean editarAsignatura(Asignatura oldAsignatura, Asignatura newAsignatura) throws Exception {
        for (int i = 0; i < asignaturas.size(); i++) {
            Asignatura asignatura = asignaturas.get(i);

            if (superaLimiteHorasTotales(asignatura.getTemario())) {
                throw new Exception(
                        "Error Profesor.editarAsignatura(): el límite de horas totales a impartir se ha superado.");
            }
        }

        if (this.asignaturas.contains(oldAsignatura)) {
            this.asignaturas.set(this.asignaturas.indexOf(oldAsignatura), newAsignatura);
            return true;
        } else {
            throw new Exception("Error Profesor.editarAsignatura: no existe esa asignatura.");
        }
    }

    /**
     * Metodo para capitalizar una cadena compuesta de caracteres. Ej: "juan
     * antonio" -> "Juan Antonio"
     * 
     * @param cadena de caracteres compuesta a capitalizar
     * @return cadena de caracteres capitalizando el primer caracter
     */
    private String capitalizarCadenaCompuesta(String cadena) {
        String cadenas[] = cadena.split(" ");
        cadenas[0] = cadenas[0].substring(0, 1).toUpperCase() + cadenas[0].substring(1).toLowerCase();
        cadenas[1] = cadenas[1].substring(0, 1).toUpperCase() + cadenas[1].substring(1).toLowerCase();

        return "" + cadenas[0] + " " + cadenas[1];
    }

    /**
     * Metodo para capitalizar una cadena simple de caracteres. Ej: "guillermo" ->
     * "Guillermo"
     * 
     * @param cadena de caracteres simple a capitalizar
     * @return cadena de caracteres capitalizando el primer caracter
     */
    private String capitalizarCadenaSimple(String cadena) {
        return cadena.substring(0, 1).toUpperCase() + cadena.substring(1).toLowerCase();
    }

    /**
     * Metodo para comprobar que el limite estipulado de 3000h maximo por profesor
     * de docencia escolar no se supera
     * 
     * @param temario de la asignatura a impartir por cada asignatura
     * @return true o false si se supera o no ese limite
     */
    private boolean superaLimiteHorasTotales(Temario temario) {
        int horasTotales = 0;

        for (int i = 0; i < asignaturas.size(); i++) {
            horasTotales += temario.getHorasTotales();
        }

        if (horasTotales <= 3000) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Metodo para devolver un string con formato dado con los datos de cada
     * profesor
     * 
     * @return los datos de cada profesor
     */
    public String imprimeProfesor() {
        return String.format("Profesor: %s %s, con titulación: %s y asignaturas impartidas:  %s", getNombre(),
                getApellidos(), this.titulacion, this.asignaturas);
    }
}
