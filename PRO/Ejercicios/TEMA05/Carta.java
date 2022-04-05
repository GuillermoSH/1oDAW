/**
 * 4) Realiza un programa que escoja al azar 10 cartas de la baraja española (10
 * objetos de la clase Carta). Emplea un array de Cartas para almacenarlas y
 * asegúrate de que no se repite ninguna.
 * 
 * @author @GuillermoSH
 * @version 0.3
 */
public class Carta {
    private static String[] numeros = { "as", "dos", "tres", "cuatro", "cinco", "seis", "siete", "sota", "caballo",
            "rey" };
    private static String[] palos = { "bastos", "copas", "espadas", "oros" };

    private String numeroCarta;
    private String paloCarta;

    public Carta() {
        this.numeroCarta = numeros[(int) (Math.random() * 10)];
        this.paloCarta = palos[(int) (Math.random() * 4)];
    }

    public String getNumero() {
        return numeroCarta;
    }

    public String getPalo() {
        return paloCarta;
    }

    @Override
    public String toString() {
        return this.numeroCarta + " de " + this.paloCarta;
    }
    // Objects cannot be resolved at Carta.equals(Carta.java:47)
    /*@Override
    public boolean equals(Object objeto) {
        if (objeto == null) {
            return false;
        }
        if (getClass() != objeto.getClass()) {
            return false;
        }

        final Carta other = (Carta) objeto;

        if (!Objects.equals(this.numeroCarta, other.numeroCarta) && Objects.equals(this.paloCarta, other.paloCarta)) {
            return false;
        }
        return true;
    }*/
}
