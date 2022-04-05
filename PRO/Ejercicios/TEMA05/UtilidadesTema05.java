public class UtilidadesTema05 {
    public static int mcd(int a, int b) {
        int resto;

        while (b != 0) {
            resto = a % b;
            a = b;
            b = resto;
        }
        return a;
    }

    public static int mcm(int a, int b) {
        return (a * b) / mcd(a, b);
    }
}