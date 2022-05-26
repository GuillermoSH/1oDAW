package es.iespuerto.refactorizacion;

/**
 * Clase para generar obtener los primos a partir de un numero maximo de numeros
 * a estudiar
 * 
 * @author GuillermoSH
 */
public class Numero {
    private int dimension;
    private boolean esPrimo[];
    private int primos[];

    /**
     * Constructor parametrizado de la clase que genera la lista de numeros a partir
     * del parametro introducido
     * 
     * @param maximo de numeros a estudiar
     */
    public Numero(int maximo) {
        this.primos = primos(maximo);
    }

    public int[] getPrimos() {
        return this.primos;
    }

    /**
     * Metodo para la obtencion de los numeros primos entre 0 y el numero maximo
     * introducido
     * 
     * @see #generarArray()
     * @see #noPrimosIgualFalse()
     * @see #contarPrimos()
     * 
     * @param maximo numero a estudiar
     * @return numeros primos entre 0 y maximo
     */
    private int[] primos(int maximo) {
        int i = 0, j = 0;
        if (maximo >= 2) {
            this.dimension = maximo + 1;

            generarArray();

            noPrimosIgualFalse();

            int cuenta = contarPrimos();

            int[] numerosPrimos = new int[cuenta];
            for (i = 0, j = 0; i < dimension; i++) {
                if (esPrimo[i]) {
                    numerosPrimos[j++] = i;
                }
            }
            return numerosPrimos;
        } else {
            return new int[0];
        }
    }

    /**
     * Metodo que pasa todos los pares y numeros no primos a false
     */
    private void noPrimosIgualFalse() {
        int i = 0, j = 0;

        // 0 y 1 no son primos
        esPrimo[0] = esPrimo[1] = false;

        for (i = 2; i < Math.sqrt(dimension) + 1; i++) {
            if (esPrimo[i]) {
                for (j = 2 * i; j < dimension; j += i)
                    esPrimo[j] = false;
            }
        }
    }

    /**
     * Metodo que cuenta la cantidad de numeros primos que hay en el array esPrimo
     * dependiendo si la posicion del array es true o false
     * 
     * @return cuenta de trues en el array esPrimo
     */
    private int contarPrimos() {
        int cuenta = 0;
        for (int i = 0; i < dimension; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }
        return cuenta;
    }

    /**
     * Metodo para generar el array de booleanos igualados a true, para luego
     * cambiar sus valores a false si no son primos
     */
    private void generarArray() {
        esPrimo = new boolean[dimension];
        for (int i = 0; i < dimension; i++) {
            esPrimo[i] = true;
        }
    }
}