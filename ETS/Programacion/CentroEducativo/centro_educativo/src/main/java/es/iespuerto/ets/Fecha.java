package es.iespuerto.ets;

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
     * @param fecha introducida a comprobar
     */
    public Fecha(String fecha) {
        String[] fechaSeparada = new String[3];

        for (int i = 0; i < fechaSeparada.length; i++) {
            fechaSeparada = fecha.split("[/-]");
        }

        this.dia = Integer.parseInt(fechaSeparada[0]);
        this.mesNumerico = Integer.parseInt(fechaSeparada[1]);
        this.anio = Integer.parseInt(fechaSeparada[2]);
    }

    /**
     * Getter del parametro dia con la comprobacion de que el anio
     * 
     * @return el dia si es correcto
     * @throws Exception si el dia no es correcto para el mes introducido
     */
    public int getDia() throws Exception {
        if (esBisiesto(getAnio())) {
            dias[1] = 29;
        }

        if (this.dia < 1 || this.dia > dias[this.mesNumerico - 1]) {
            throw new Exception("Error Fecha.getDia(): el dia es incorrecto.");
        }

        return this.dia;
    }

    /**
     * Getter del parametro mesNumerico
     * 
     * @return el mes numerico si es correcto
     * @throws Exception si el mes no es correcto
     */
    public int getMesNumerico() throws Exception {
        if (mesNumerico > 12 || mesNumerico < 1) {
            throw new Exception("Error Fecha.getMesNumerico(): el mes es incorrecto.");
        }
        return this.mesNumerico;
    }

    /**
     * Getter del parametro mesNombre
     * 
     * @return el mes como string no numerico si es correcto
     * @throws Exception si el mesNumerico no es correcto
     * @see #getMesNumerico()
     */
    public String getMesNombre() throws Exception {
        if (mesNumerico > 12 || mesNumerico <= 0) {
            throw new Exception("Error Fecha.getMesNombre(): el mes es incorrecto.");
        }
        return meses[this.mesNumerico - 1];
    }

    /**
     * Getter del parametro anio
     * 
     * @return el anio si es correcto
     * @throws Exception si el anio no es correcto
     */
    public int getAnio() throws Exception {
        if (anio < 1999 || anio > 9999) {
            throw new Exception("Error Fecha.getAnio(): el anio es incorrecto.");
        }
        return this.anio;
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
    public String imprimeFecha(boolean numerico) throws Exception {
        String fecha = "", mes = this.mesNumerico + "/", dia = this.dia + "/";

        if (!numerico) {
            mes = "" + getMesNombre();
            dia = "" + getDia();
            fecha += dia + " de " + mes + " de " + getAnio();
        } else {
            if (getMesNumerico() < 10) {
                mes = "0" + mes;
            }
            if (getDia() < 10) {
                dia = "0" + dia;
            }
            fecha = dia + mes + "" + getAnio();
        }
        return fecha;
    }
}
