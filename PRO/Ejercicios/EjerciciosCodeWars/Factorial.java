/**
 * KATA: https://www.codewars.com/kata/54ff0d1f355cfd20e60001fc/train/java
 */
public class Factorial {
    public static int factorial(int n) throws IllegalArgumentException {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException("Error01: the number is out of range.");
        } else if (n == 0) {
            return 1;
        }
        int result = n;

        for (int index = n - 1; index > 0; index--) {
            result *= index;
        }

        return result;
    }

    public static void main(String args[]) throws IllegalArgumentException {
        System.out.println(factorial(5));
    }
}
