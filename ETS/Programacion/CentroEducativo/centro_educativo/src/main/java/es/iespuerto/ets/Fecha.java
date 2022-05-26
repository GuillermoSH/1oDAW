package es.iespuerto.ets;

import java.io.*;

/**
 * Clase Fecha capaz de verificar de que la fecha introducida es la correcta o
 * no dependiendo del mes que se le introduzca o del anyo si es bisiesto o no.
 * 
 * @author GuillermoSH
 * @version 1.0
 */
public class Fecha {
    private int dia;
    private int mesNumerico;
    private int anio;
    private final String[] meses = { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto",
            "septiembre", "octubre", "noviembre", "diciembre" };
    private final int[] dias = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    /**
     * Constructor parametrizado de la clase Fecha
     * 
     * @param fecha a evaluar
     * @throws IOException si alguno de los parametros de la fecha es incorrecto
     */
    public Fecha(String fecha) throws IOException {
        String[] fechaSeparada = new String[3];

        for (int i = 0; i < fechaSeparada.length; i++) {
            fechaSeparada = fecha.split("[/-]");
        }

        this.anio = obtenerAnio(fechaSeparada[2]);
        this.mesNumerico = obtenerMes(fechaSeparada[1]);
        this.dia = obtenerDia(fechaSeparada[0]);
    }

    /**
     * Getter del parametro anio
     * 
     * @return anio
     */
    public int getAnio() {
        return this.anio;
    }

    /**
     * Getter del parametro mesNumerico
     * 
     * @return mesNumerico
     */
    public int getMesNumerico() {
        return this.mesNumerico;
    }

    /**
     * Getter del parametro mesNombre
     * 
     * @return mes, pero su nombre
     */
    public String getMesNombre() {
        return meses[this.mesNumerico - 1];
    }

    /**
     * Getter del parametro dia
     * 
     * @return dia
     */
    public int getDia() {
        return this.dia;
    }

    /**
     * Metodo que genera las excepciones dependiendo de la condicion de entrada y la
     * cadena a añadir en el mensaje de la excepcion
     * 
     * @param condicion a evaluar
     * @param cadena    a añadir en el mensaje de excepcion
     * @throws IOException si la condicion se cumple
     */
    public void exception(boolean condicion, String cadena) throws IOException {
        if (condicion) {
            throw new IOException("Error Fecha." + cadena);
        }
    }

    /**
     * Metodo para la obtencion del parametro anio con su previa validacion a partir
     * del String de fecha
     * 
     * @param strAnio la parte del String fecha despues de hacer el split
     * @return anio como int
     * @throws IOException si el anio es incorrecto
     */
    public int obtenerAnio(String strAnio) throws IOException {
        int numAnio = Integer.parseInt(strAnio);

        exception(numAnio < 1999 || numAnio > 9999, "obtenerAnio(): el anio es incorrecto.");

        return numAnio;
    }

    /**
     * Metodo para la obtencion del parametro mes con su previa validacion a partir
     * del String de fecha
     * 
     * @param strMes la parte del String fecha despues de hacer el split
     * @return mes como int
     * @throws IOException si el mes es incorrecto
     */
    public int obtenerMes(String strMes) throws IOException {
        int numMes = Integer.parseInt(strMes);

        exception(numMes > 12 || numMes < 1, "obtenerMes(): el mes es incorrecto.");

        return numMes;
    }

    /**
     * Metodo para la obtencion del parametro dia con su previa validacion a partir
     * del String de fecha
     * 
     * @param strDia la parte del String fecha despues de hacer el split
     * @return dia como int
     * @throws IOException si el dia es incorrecto
     */
    public int obtenerDia(String strDia) throws IOException {
        int numDia = Integer.parseInt(strDia);

        if (esBisiesto(this.anio)) {
            dias[1] = 29;
        }
        exception((numDia < 1 || numDia > dias[this.mesNumerico - 1]), "obtenerDia(): el dia es incorrecto.");

        return numDia;
    }

    /**
     * Metodo para la verificacion de que el anyo es bisiesto
     * 
     * @param anio a verificar si es bisiesto o no
     * @return True o false dependiendo de si es bisiesto
     */
    private boolean esBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0);
    }

    /**
     * Metodo que devuelve como String la fecha con el mes en formato numerico o
     * como nombre dependiendo de la entrada que de el usuario en el constructor de
     * la clase
     * 
     * @param numerico si se quiere la fecha con mes numerico o no
     * @return como String la fecha con el mes en formato numerico o como nombre
     * @throws Exception si algun parametro de la fecha es incorrecto
     */
    public String imprimeFecha(boolean numerico) {
        if (!numerico) {
            return String.format("%d de %s de %d", this.dia, getMesNombre(), this.anio);
        }
        return String.format("%02d/%02d/%d", this.dia, this.mesNumerico, this.anio);
    }
}
