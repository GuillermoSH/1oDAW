import java.util.*;

public class Ejercicio6Prof {
    public static void main(String args[]) throws Exception {
        List<CartaProf> cartas = new ArrayList<>();
        CartaProf cAleat;
        String palo;
        int suma = 0;

        while (cartas.size() < 5) {
            cAleat = CartaProf.cartaAleatoria();

            if (!cartas.contains(cAleat)) {
                cartas.add(cAleat);
            }
        }
        System.out.println(HtmlUtil.cabecera("Cartas Brisca"));

        System.out.println("    <table>\n" +
                "       <thead>\n" +
                "           <tr>\n" +
                "               <th colspan='5'>Cartas</th>\n" +
                "           </tr>\n" +
                "       </thead>\n" +
                "       <tbody>\n" +
                "           <tr>");

        for (CartaProf c : cartas) {
            palo = c.getPalo().toLowerCase();
            System.out.printf("               <td><img src='/m/tmp/barajaEspa/%s/%s%d.png' style='max-width': 100%%; height: auto;'/></td>\n",palo, palo, c.getNumero());
        }

        System.out.println("            </tr>\n" +
                "           <tr>");

        for (CartaProf c : cartas) {
            System.out.printf("             <td>%d</td>\n", c.getValor());
            suma += c.getValor();
        }

        System.out.println("            </tr>");
        System.out.printf("            </tr><td>Total:</td><td>%d</td></tr>\n",suma);
        System.out.println("        </tbody>\n"+
        "   </table>");

        System.out.println(HtmlUtil.pieHtml());
    }
}
