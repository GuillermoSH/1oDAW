public class CartaProf {
    private static String[] palos = { "Bastos", "Copas", "Espadas", "Oros" };
    private static int[] valores = { 0, 11, 0, 10, 0, 0, 0, 0, 0, 0, 2, 3, 4 };
    private String palo;
    private int numero;
    private int valor = 0;

    public CartaProf(String palo, int numero) throws Exception {
        if (numero < 1 || numero > 12) {
            throw new Exception("Error Constructor de Carta,número de carta incorrecto.");
        }

        if (!compruebaPalo(palo)) {
            throw new Exception("Error Constructor de Carta, palo de carta incorrecto.");
        }

        this.palo = palo;
        this.numero = numero;
        this.valor = CartaProf.valores[numero];
    }

    public boolean compruebaPalo(String palo) {
        for (int i = 0; i < CartaProf.palos.length; i++) {
            if (palo.equals(palos[i])) {
                return true;
            }
        }

        return false;
    }

    public String getPalo() {
        return this.palo;
    }

    public int getNumero() {
        return this.numero;
    }
    
    public int getValor() {
        return this.valor;
    }

    public static CartaProf cartaAleatoria() throws Exception{
        String palo;
        int numero;
        numero = (int) (12 * Math.random() + 1);
        palo = CartaProf.palos[(int)(4*Math.random())];

        return new CartaProf(palo,numero);
    }

    @Override
    public String toString() {
        return String.format("%d de %s",this.numero,this.palo);
    }

    @Override
    public boolean equals(Object o) {
        CartaProf c = (CartaProf) o;
        return this.numero == c.numero && this.palo.equals(c.palo);
    }
}
