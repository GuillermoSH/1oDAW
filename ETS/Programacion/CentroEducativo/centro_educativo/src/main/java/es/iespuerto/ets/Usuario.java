package es.iespuerto.ets;

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
    private int contMayusculas, contDigitos, contMinusculas;
    private final int minCaracteres = 6;
    private final int minMinusculas = 1;
    private final int minMayusculas = 1;
    private final int minDigitos = 1;

    /**
     * Contructor parametrizado de la clase Usuario
     * 
     * @param email       del usuario
     * @param password del usuario a validar
     */
    public Usuario(String email, String password) throws Exception {
        if (validarEmail(email)) {
            this.email = email;
        }
        if (comprobarPassword(password)) {
            this.password = password;
        }
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
    public void setEmail(String email) throws Exception {
        if (validarEmail(email)) {
            this.email = email;
        }
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
    public void setPassword(String password) throws Exception {
        if (comprobarPassword(password)) {
            this.password = password;
        }
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
    private boolean comprobarPassword(String password) throws Exception {
        boolean comprobacion = false;
        contMayusculas = 0;
        contDigitos = 0;
        contMinusculas = 0;

        contarCaracteres(password);

        if (validarPassword(password)) {
            comprobacion = true;
        } else {
            requisitosPassword(password);
        }
        return comprobacion;
    }

    /**
     * Metodo que cuenta la cantidad de caracteres especiales, digitos y mayusculas
     * que existen dentro de la contrasenia para su validacion
     * 
     * @param password a estudiar
     */
    private void contarCaracteres(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                this.contMayusculas++;
            } else if (Character.isDigit(c)) {
                this.contDigitos++;
            } else if (Character.isLowerCase(c)) {
                this.contMinusculas++;
            }
        }
    }

    /**
     * Comprobacion de que la contrasenia cumple los requisitos de formato de la
     * misma devolviendo true o false dependiendo si se ha pasado la validacion
     * 
     * @param password         para su validacion
     * @param contMayusculas      contador de mayusculas en la contrasenia
     * @param contDigitos         contador de digitos en la contrasenia
     * @param contMinusculas contador de caracteres especiales en la
     *                            contrasenia
     * @return true o false si se ha validado o no la contrasenia
     */
    private boolean validarPassword(String password) {
        if (password.length() >= minCaracteres && this.contMayusculas >= minMayusculas
                && this.contDigitos >= minDigitos && this.contMinusculas >= minMinusculas) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que devuelve una Exception con los requisitos que no se han cumplido
     * en la modificacion de la contraseña mediante el metodo
     * {@link #setPassword(String)} o creando un nuevo usuario mediante el
     * constructor de la clase
     * 
     * @param password         a revisar
     * @param contMayusculas      contador de mayusculas en la contrasenia
     * @param contDigitos         contador de digitos en la contrasenia
     * @param contMinusculas contador de caracteres especiales en la
     *                            contrasenia
     * @throws Exception con los requisitos a cumplir en el siguente intento
     */
    private void requisitosPassword(String password) throws Exception {
        String respuesta = "Su contraseña no cumple los siguientes requisitos:";
        if (password.length() < minCaracteres) {
            respuesta += "\n - Al menos 6 caracteres.";
        }
        if (this.contMayusculas < minMayusculas) {
            respuesta += "\n - Minimo 1 caracter en mayusculas.";
        }
        if (this.contDigitos < minDigitos) {
            respuesta += "\n - Minimo 1 digito.";
        }
        if (this.contMinusculas < minMinusculas) {
            respuesta += "\n - Minimo 1 caracter en minusculas.";
        }
        throw new Exception(respuesta);
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
    private boolean validarEmail(String email) throws Exception {
        if (email.contains("@gmail.com") || email.contains("@hotmail.com")
                || email.contains("@gobiernodecanarias.org")) {
            return true;
        } else {
            throw new Exception("Su email debe ser '@gmail.com', '@hotmail.com' o '@gobiernodecanarias.org'.");
        }
    }
}
