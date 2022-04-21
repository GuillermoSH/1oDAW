package es.iespuerto.ets;

import java.util.*;

/**
 * Clase Fecha capaz de verificar de que la fecha introducida es la correcta o
 * no dependiendo del mes que se le introduzca o del anyo si es bisiesto o no.
 * 
 * @author @GuillermoSH
 * @version 1.0
 */
public class Fecha {
    private int dia;
    private int mesNumerico;
    private String mesNombre;
    private int anyo;

    /**
     * Constructor de la clase con la asignacion de las variables
     * 
     * @param fecha Fecha introducida por el usuario
     */
    public Fecha(String fecha) {
        String[] fechaSeparada = new String[3];

        for (int i = 0; i < fechaSeparada.length; i++) {
            fechaSeparada = fecha.split("/");
        }

        this.dia = Integer.parseInt(fechaSeparada[0]);
        this.mesNumerico = Integer.parseInt(fechaSeparada[1]);
        this.anyo = Integer.parseInt(fechaSeparada[2]);
        this.mesNombre = getMesNombre();
    }

    /**
     * Getter de dia
     * 
     * @return dia introducido por el usuario
     */
    public int getDia() {
        return dia;
    }

    /**
     * Getter de nes numerico
     * 
     * @return mes numerico introducido por el usuario
     */
    public int getMesNumerico() {
        return mesNumerico;
    }

    /**
     * Getter del nombre del mes
     * 
     * @return nombre del mes dependiendo del mes numerico
     */
    public String getMesNombre() {
        switch (mesNumerico) {
            case 1:
                return this.mesNombre = "enero";
            case 2:
                return this.mesNombre = "febrero";
            case 3:
                return this.mesNombre = "marzo";
            case 4:
                return this.mesNombre = "abril";
            case 5:
                return this.mesNombre = "mayo";
            case 6:
                return this.mesNombre = "junio";
            case 7:
                return this.mesNombre = "julio";
            case 8:
                return this.mesNombre = "agosto";
            case 9:
                return this.mesNombre = "septiembre";
            case 10:
                return this.mesNombre = "octubre";
            case 11:
                return this.mesNombre = "noviembre";
            case 12:
                return this.mesNombre = "diciembre";
        }

        return mesNombre;
    }

    /**
     * Getter de anyo
     * 
     * @return anyo introducido por el usuario
     */
    public int getAnyo() {
        return anyo;
    }

    /**
     * Metodo para la verificacion de que el anyo es bisiesto
     * 
     * @param anyo Anyo introducido por el usuario
     * @return True o false dependiendo de si es bisiesto
     */
    private boolean esBisiesto(int anyo) {
        return (anyo % 4 == 0 && anyo % 100 != 0 || anyo % 400 == 0);
    }

    /**
     * Metodo para la verificacion de si la fecha introducida al completo es valida
     * tanto por el numero de dias como el valor del mes y del anyo dependiendo si
     * es bisiesto el anyo o no
     * 
     * @param dia         Dia introducido por el usuario
     * @param mesNumerico Mes introducido por el usuario
     * @param anyo        Anyo introducido por el usuario
     * @return True o false por cada parametro si son fechas validas
     */
    private boolean fechaCorrecta() {
        boolean diaCorrecto, mesCorrecto, anyoCorrecto;

        anyoCorrecto = anyo >= 1999 && anyo <= 9999;
        mesCorrecto = mesNumerico >= 1 && mesNumerico <= 12;

        switch (mesNumerico) {
            case 2:
                if (esBisiesto(anyo)) {
                    diaCorrecto = dia >= 1 && dia <= 29;
                } else {
                    diaCorrecto = dia >= 1 && dia <= 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diaCorrecto = dia >= 1 && dia <= 30;
                break;
            default:
                diaCorrecto = dia >= 1 && dia <= 31;
        }
        return diaCorrecto && mesCorrecto && anyoCorrecto;
    }

    /**
     * Metodo sobrecargado de la clase toString de java para imprimir en formato
     * correcto la fecha
     */
    @Override
    public String toString() {
        if (!fechaCorrecta()) {
            return "\n\nError Fecha.toString(): la fecha es incorrecta.\n\n";
        }

        System.out.print("\n¿Quiere que se muestre la fecha con el nombre del mes? (y/n): ");
        Scanner tec = new Scanner(System.in);
        String respuesta = tec.nextLine();
        tec.close();

        if (respuesta.equals("y")) {
            return String.format("\n%d de %s de %d", this.dia, this.mesNombre, this.anyo);
        } else {
            if (this.mesNumerico < 10) {
                return String.format("\n%d/0%d/%d", this.dia, this.mesNumerico, this.anyo);
            } else {
                return String.format("\n%d/%d/%d", this.dia, this.mesNumerico, this.anyo);
            }
        }
    }
}
