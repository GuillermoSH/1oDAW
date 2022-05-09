/**
 * 6) Basándose en el anterior, escribir un programa que genere un fichero html,
 * donde se muestren las imágenes de las cartas y la puntuación obtenida, se te
 * entrega un fichero con las imágenes de la cartas de la baraja española.
 * 
 * @author @GuillermoSH
 * @version 0.1
 */
public class Ejercicio6 {
    public static void main(String args[]) {
        Carta[] cartas = new Carta[5];
        int contadorCartas = 0;
        Carta cartaAleatoria = null;
        
        while (contadorCartas < cartas.length) {
            cartaAleatoria = Carta.CartaAleatoria();
            
            if (!Carta.CartaRepetida(cartas, cartaAleatoria, contadorCartas)) {
                cartas[contadorCartas] = cartaAleatoria;
                contadorCartas++;
            }
        }
        int suma = 0;

        for (int index = 0; index < cartas.length; index++) {
            if (cartas[index].numero == 1) {
                suma += 11;
            } else if (cartas[index].numero == 3) {
                suma += 10;
            } else if (cartas[index].numero == 10) {
                suma += 2;
            } else if (cartas[index].numero == 11) {
                suma += 3;
            } else if (cartas[index].numero == 12) {
                suma += 4;
            }
        }
        System.out.println("<!DOCTYPE html>");
        System.out.println("<html lang=\"es\">");
        System.out.println("<head>");
        System.out.println("<meta charset=\"UTF-8\">");
        System.out.println("<title>Juego de la Brisca</title>");
        System.out.println("</head>");
        System.out.println("<body>");
        System.out.println("<table>");
        System.out.println("<tr><th>Juego de la Brisca</th></tr>");
        System.out.println("<tr>");
        System.out.printf(
                "<td><img src=\"H:\\1º DAW\\VisualStudio\\PRO\\Tema05\\Ejercicio 6,7,8,9,10\\Ejercicio 6\\barajaEspa\\%s\\%s%d.png\"></td>",
                cartas[0].palo.toLowerCase(), cartas[0].palo.toLowerCase(), cartas[0].numero);
        System.out.printf(
                "<td><img src=\"H:\\1º DAW\\VisualStudio\\PRO\\Tema05\\Ejercicio 6,7,8,9,10\\Ejercicio 6\\barajaEspa\\%s\\%s%d.png\"></td>",
                cartas[1].palo.toLowerCase(), cartas[1].palo.toLowerCase(), cartas[1].numero);
        System.out.printf(
                "<td><img src=\"H:\\1º DAW\\VisualStudio\\PRO\\Tema05\\Ejercicio 6,7,8,9,10\\Ejercicio 6\\barajaEspa\\%s\\%s%d.png\"></td>",
                cartas[2].palo.toLowerCase(), cartas[2].palo.toLowerCase(), cartas[2].numero);
        System.out.printf(
                "<td><img src=\"H:\\1º DAW\\VisualStudio\\PRO\\Tema05\\Ejercicio 6,7,8,9,10\\Ejercicio 6\\barajaEspa\\%s\\%s%d.png\"></td>",
                cartas[3].palo.toLowerCase(), cartas[3].palo.toLowerCase(), cartas[3].numero);
        System.out.printf(
                "<td><img src=\"H:\\1º DAW\\VisualStudio\\PRO\\Tema05\\Ejercicio 6,7,8,9,10\\Ejercicio 6\\barajaEspa\\%s\\%s%d.png\"></td>",
                cartas[3].palo.toLowerCase(), cartas[3].palo.toLowerCase(), cartas[3].numero);
        System.out.println("</tr>");
        System.out.println("<tr>");
        System.out.printf("<td>%2d de %2s </td>", cartas[0].numero, cartas[0].palo);
        System.out.printf("<td>%2d de %2s </td>", cartas[1].numero, cartas[1].palo);
        System.out.printf("<td>%2d de %2s </td>", cartas[2].numero, cartas[2].palo);
        System.out.printf("<td>%2d de %2s</td>", cartas[3].numero, cartas[3].palo);
        System.out.printf("<td>%2d de %2s </td>", cartas[4].numero, cartas[4].palo);
        System.out.println("</tr>");
        System.out.println("</table>");
        System.out.printf("<h1>Puntuación Final: %2d</h1>", suma);
    }
}
