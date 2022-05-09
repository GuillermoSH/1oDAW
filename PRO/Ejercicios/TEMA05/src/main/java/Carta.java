/**
 * 4) Realiza un programa que escoja al azar 10 cartas de la baraja española (10
 * objetos de la clase Carta). Emplea un array de Cartas para almacenarlas y
 * asegúrate de que no se repite ninguna.
 * 
 * @author @GuillermoSH
 * @version 0.3
 */
public class Carta {
    private static String palos[] = { "Bastos", "Copas", "Espadas", "Oros" };
    String palo;
    byte numero;

    public Carta(String palo, byte numero) {
        this.palo = palo;
        this.numero = numero;
    }

    public Carta(){
        
    }

    @Override
    public boolean equals(Object c) {
        Carta e = (Carta) c;
        return this.palo.equals(e.palo) && this.numero == e.numero;
    }

    public static Carta CartaAleatoria() {
        byte palo;
        byte numCarta;
        palo = (byte) (Math.random() * 4);
        numCarta = (byte) (Math.random() * 12 + 1);
        return new Carta(palos[palo], numCarta);
    }

    @Override
    public String toString() {
        return String.format("%d de %s", this.numero, this.palo);

    }

    public static boolean CartaRepetida(Carta[] cartas, Carta cartaAleatoria, int contadorCartas) {
        return false;
    }
}
