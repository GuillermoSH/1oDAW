public class Printer {
    public static String printerError(String s) {
        String[] stringToArray = new String[s.length()];
        int errors = 0;

        for (int index = 0; index < stringToArray.length; index++) {
            char character = s.charAt(index);
            stringToArray[index] = Character.toString(character);

            if (character > 'm') {
                errors++;
            }
        }
        return errors + "/" + s.length();
    }

    public static void main(String args[]) {
        String s = "aaaxbbbbyyhwawiwjjjwwm";
        System.out.println(printerError(s));
    }
}