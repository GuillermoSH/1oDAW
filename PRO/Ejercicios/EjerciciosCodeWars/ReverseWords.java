public class ReverseWords {
    public static String reverseWords(final String original) {
        String result = "";

        for (int i = original.length() - 1; i > 0; i--) {
            result += original.charAt(i);
        }
        return result;
    }
}
