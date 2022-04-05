import java.util.*;

public class FindStrayNumber {
    public static int stray(int[] numbers) {
        if (numbers.length < 3) {
            return 0;
        }
        Arrays.sort(numbers);
        int diffNumber = numbers[0], counter = 0;

        for (int index = 1; index < numbers.length; index++) {
            if (numbers[index] == diffNumber) {
                counter++;
            } else {
                diffNumber = numbers[index];
            }
        }
        if (counter > 0) {
            return diffNumber = numbers[0];
        } else {
            return diffNumber;
        }
    }

    public static void main(String args[]) {
        int[] array = { 1, 1, 2 };
        System.out.println(stray(array));
    }
}
