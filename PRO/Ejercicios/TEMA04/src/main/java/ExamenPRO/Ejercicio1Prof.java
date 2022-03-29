package ExamenPRO;

public class Ejercicio1Prof {
    public char[] inverso(String s) {
        char[] res = new char[s.length()];

        for (int i = s.length() - 1, j = 0; i > 0; i--, j++ ) {
            res[j] = s.charAt(i);
        }
        return res;
    }

    public static void main(String args[]){
        Ejercicio1Prof e = new Ejercicio1Prof();
        e.inverso("hola");
    }
}
