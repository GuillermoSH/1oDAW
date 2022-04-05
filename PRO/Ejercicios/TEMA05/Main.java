public class Main {
    public static void main(String args[]) throws Exception {
        Fraccion p = new Fraccion(3, 7);
        Fraccion q = new Fraccion(2, 3);
        Fraccion suma = p.suma(q);
        Fraccion resta = p.resta(q);
        Fraccion prod = p.producto(q);
        Fraccion div = p.division(q);
        System.out.printf("Suma: %s\n", suma);
        System.out.printf("Suma reducida: %s\n", suma.reduce());
        System.out.printf("Suma: %s\n", resta);
        System.out.printf("Suma reducida: %s\n", resta.reduce());
        System.out.printf("Suma: %s\n", prod);
        System.out.printf("Suma reducida: %s\n", prod.reduce());
        System.out.printf("Suma: %s\n", div);
        System.out.printf("Suma reducida: %s\n", div.reduce());
    }
}
