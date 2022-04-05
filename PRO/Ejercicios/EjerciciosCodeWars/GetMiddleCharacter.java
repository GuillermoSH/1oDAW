/**
 * KATA: https://www.codewars.com/kata/56747fd5cb988479af000028/train/java
 */
public class GetMiddleCharacter {
    public static String getMiddle(String word) {
        if (word.length() % 2 == 0) {
            return word.charAt(word.length() / 2 - 1) + "" + word.charAt(word.length() / 2);
        } else {
            return "" + word.charAt(word.length() / 2);
        }
    }

    public static void main(String args[]) {
        System.out.println(getMiddle("test"));
    }
}
