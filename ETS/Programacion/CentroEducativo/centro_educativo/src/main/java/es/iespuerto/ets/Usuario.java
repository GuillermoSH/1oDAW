package es.iespuerto.ets;

import java.util.regex.*;

/**
 * Clase Usuario para el registro de usuarios que quieran usar la aplicacion
 * guardando asi su contraseña, que sera validada dentro de la clase, y su
 * email
 * 
 * @author GuillermoSH
 * @version 0.4
 */
public class Usuario {
    private String email;
    private String password;

    /**
     * Contructor parametrizado de la clase Usuario
     * 
     * @param email    del usuario
     * @param password del usuario a validar
     */
    public Usuario(String email, String password) throws IllegalArgumentException {
        validarEmail(email);
        this.email = email;
        comprobarPassword(password);
        this.password = password;
    }

    /**
     * Getter del email del usuario
     * 
     * @return email validado
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Setter del email del usuario, permitiendo modificarlo si se cumplen los
     * requisitos de validacion
     * 
     * @param email a validar y modificar por el anterior
     */
    public void setEmail(String email) throws IllegalArgumentException {
        validarEmail(email);
        this.email = email;
    }

    /**
     * Getter de la contrasenia del usuario
     * 
     * @return contrasenia validada
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Setter de la contrasenia del usuario, permitiendo modificarla si se cumplen
     * los requisitos de validacion
     * 
     * @param password a validar y modificar por la anterior
     * @throws Exception
     */
    public void setPassword(String password) throws IllegalArgumentException {
        comprobarPassword(password);
        this.password = password;
    }

    /**
     * Comprobacion de que la contrasenia cumple los requisitos de formato de la
     * misma devolviendo true o false dependiendo si se ha pasado el
     * {@link #validarPassword(String)}. Si da falso lanzara una
     * exception con los requisitos a cumplir.
     * 
     * @param password para su validacion
     * @see #requisitosPassword(String,int,int,int)
     * @return true o false si se ha validado o no la contrasenia
     */
    private void comprobarPassword(String password) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,50}$");
        Matcher matcher = pattern.matcher(password);
        boolean valido = matcher.find();

        if (!valido) {
            throw new IllegalArgumentException("Su contraseña no cumple los siguientes requisitos:\n - Al menos 6 caracteres.\n - Minimo 1 digito, 1 caracter en mayusculas y otro en minusculas.");
        }
    }

    /**
     * Comprobacion de que el email contiene una de las siguientes terminaciones:
     * "@gmail.com", "@hotmail.com" o "@gobiernodecanarias.org"
     * 
     * @param email a validar
     * @return true si el email es correcto
     * @throws Exception si el email no contiene alguna de las terminaciones
     *                   nombradas
     */

    private void validarEmail(String email) throws IllegalArgumentException {
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        boolean valido = matcher.find();
        if (!valido) {
            throw new IllegalArgumentException(
                    "Su email debe ser '@gmail.com', '@hotmail.com' o '@gobiernodecanarias.org'.");
        }

    }
}
