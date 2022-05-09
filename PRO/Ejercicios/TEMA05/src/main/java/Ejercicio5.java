import java.util.*;

/**
 * 5) Escribe un programa que genere una secuencia de 5 cartas de la baraja
 * española y que sume los puntos según el juego de la brisca. El valor de las
 * cartas se debe guardar en un array de Cartas. El valor de las cartas es el
 * siguiente: as → 11, tres → 10, sota → 2, caballo → 3, rey → 4; el resto de
 * cartas no vale nada
 * 
 * @author @GuillermoSH
 * @version 0.1
 */
public class Ejercicio5 {
    public static void main(String args[]) {
        ArrayList<Carta> carta = new ArrayList<Carta>();
        Carta cartaAuxiliar = new Carta();
        carta.add(cartaAuxiliar);
        int suma = 0;

        for (int i = 0; i < 4; i++) {
            do {
                cartaAuxiliar = new Carta();
            } while (carta.contains(cartaAuxiliar));

            carta.add(cartaAuxiliar);
        }

        for (Carta cartaAleatoria : carta) {
            String cartaStr = "" + cartaAleatoria;

            if (cartaStr.contains("as")) {
                suma += 11;
            } else if (cartaStr.contains("tres")) {
                suma += 10;
            } else if (cartaStr.contains("sota")) {
                suma += 2;
            } else if (cartaStr.contains("caballo")) {
                suma += 3;
            } else if (cartaStr.contains("rey")) {
                suma += 4;
            }
        }

        System.out.printf("La suma total es de: %d puntos.", suma);
    }
}
