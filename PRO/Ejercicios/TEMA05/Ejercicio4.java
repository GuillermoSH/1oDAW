import java.util.*;

/**
 * 4) Realiza un programa que escoja al azar 10 cartas de la baraja española (10
 * objetos de la clase Carta). Emplea un array de Cartas para almacenarlas y
 * asegúrate de que no se repite ninguna.
 * 
 * @author @GuillermoSH
 * @version 0.3
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        ArrayList<Carta> carta = new ArrayList<Carta>();
        Carta cartaAuxiliar = new Carta();
        carta.add(cartaAuxiliar);

        for (int i = 0; i < 9; i++) {
            do {
                cartaAuxiliar = new Carta();
            } while (carta.contains(cartaAuxiliar));

            carta.add(cartaAuxiliar);
        }
        int i = 1;

        for (Carta cartaAleatoria : carta) {
            System.out.printf("\nCarta %2d: %s", i, cartaAleatoria);
            i++;
        }
    }
}
