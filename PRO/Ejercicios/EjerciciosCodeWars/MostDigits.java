import java.util.*;

/**
 * KATA: https://www.codewars.com/kata/58daa7617332e59593000006/train/java
 */
public class MostDigits {
    public static int findLongest(int[] numbers) {
        int[] lengthCounter = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int aux = numbers[i];
            for (int j = 0;; j++) {
                aux /= 10;
                if (aux <= 0) {
                    lengthCounter[i] = j;
                    break;
                }
            }
        }
        int max = lengthCounter[0], i;

        for (i = 1; i < numbers.length; i++) {
            if (lengthCounter[i] > max) {
                max = lengthCounter[i];
            }
        }
        return numbers[i - 1];
    }

    public static void main(String args[]) {
        System.out.println(findLongest(new int[] {9000, 8, 800}));
    }
}