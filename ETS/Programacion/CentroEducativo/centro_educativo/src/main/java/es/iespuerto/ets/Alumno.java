package es.iespuerto.ets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de almacenamiento de datos relacionados con cada uno de los alumnos
 * 
 * @author GuillermoSH
 * @version 0.4
 */
public class Alumno {
    private String nombre;
    private String apellidos;
    private String dni;
    private String fechaNacimiento;
    private List<Matricula> matriculas = new ArrayList<>();
    private char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
            'H', 'L', 'C', 'K', 'E' };

    /**
     * Constructor parametrizado de la clase Alumno
     * 
     * @param nombre          del alumno
     * @param apellidos       del alumno
     * @param numeroDni       del alumno (sin letra)
     * @param fechaNacimiento del alumno
     * @param matriculas      puestas a cursar por el alumno
     */
    public Alumno(String nombre, String apellidos, int numDni, List<Matricula> matriculas, String fecha,
            boolean numerico) throws IOException {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = obtenerDni(numDni, letras[numDni % 23]);
        this.fechaNacimiento = obtenerFecha(fecha, numerico);
        this.matriculas = matriculas;
    }

    /**
     * Getter del parametro nombre de la clase Alumno
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
     * Getter del parametro apellidos de la clase Alumno
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
     * Getter del parametro dni con la letra del mismo calculada
     * 
     * @return el dni con la letra calculada
     */
    public String getDni() {
        return this.dni;
    }

    /**
     * Getter del parametro fecha en el formato que quiera el usuario
     * 
     * @param numerico si se desea la fecha con mes numerico o no
     * @return la fecha comprobada mediante la clase {@link Fecha}
     * @throws Exception si la fecha introducida es incorrecta
     */
    public String getFechaNacimiento(boolean numerico) throws IOException {
        Fecha fechaObj = new Fecha(this.fechaNacimiento);
        this.fechaNacimiento = fechaObj.imprimeFecha(numerico);

        return this.fechaNacimiento;
    }

    /**
     * Getter del parametro matriculas
     * 
     * @return la lista de matriculas asociadas al alumno
     */
    public List<Matricula> getMatriculas() {
        return this.matriculas;
    }

    public String obtenerDni(int numDni, char letraDni) {
        return numDni + "" + letraDni;
    }

    public String obtenerFecha(String fecha, boolean numerico) throws IOException {
        Fecha fechaObj = new Fecha(fecha);

        return fechaObj.imprimeFecha(numerico);
    }

    /**
     * Metodo para capitalizar una cadena compuesta de caracteres. Ej: "juan
     * antonio" -> "Juan Antonio"
     * 
     * @param cadena de caracteres compuesta a capitalizar
     * @return cadena de caracteres capitalizando el primer caracter
     */
    private String capitalizarCadenaCompuesta(String cadena) {
        String[] cadenas = cadena.split(" ");
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
     * Metodo que permite al usuario agregar nuevas matriculas a su lista de
     * matriculas
     * 
     * @param newMatricula nueva matricula a añadir
     * @return true si se ha añadido correctamente la matricula a la lista
     * @throws Exception si la matricula ya existia en la lista
     */
    public boolean agregarMatricula(Matricula newMatricula) throws IOException {
        if (this.matriculas.contains(newMatricula)) {
            throw new IOException("Error Alumno.agregarMatricula(): esa matricula ya existe.");
        }

        matriculas.add(newMatricula);

        return true;
    }

    /**
     * Metodo que permite al usuario eliminar una matricula ya existente dentro de
     * su lista de matriculas
     * 
     * @param oldMatricula matricula existente dentro de su lista de matriculas
     * @return true si se ha podido eliminar la matricula correctamente
     * @throws Exception si la matricula no existe dentro de la lista
     */
    public boolean eliminarMatricula(Matricula oldMatricula) throws IOException {
        if (this.matriculas.contains(oldMatricula)) {
            matriculas.remove(oldMatricula);

            return true;
        } else {
            throw new IOException("Error Alumno.eliminarMatricula(): esa matricula no existe.");
        }
    }

    /**
     * Metodo que permite al usuario editar una matricula ya existente dentro de su
     * lista de matriculas
     * 
     * @param newMatricula nueva matricula a añadir en la lista en sustitucion de la
     *                     antigua
     * @param oldMatricula matricula ya existente en la lista a modificar
     * @return true si se ha podido editar la matricula anterior correctamente
     * @throws Exception si no se ha encontrado la matricula anterior
     */
    public boolean editarMatricula(Matricula oldMatricula, Matricula newMatricula) throws IOException {
        if (this.matriculas.contains(oldMatricula)) {
            matriculas.set(matriculas.indexOf(oldMatricula), newMatricula);
            return true;
        } else {
            throw new IOException("Error Alumno.editarMatricula(): esa matricula no existe.");
        }
    }
}
