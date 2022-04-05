/**
 * KATA: https://www.codewars.com/kata/59377c53e66267c8f6000027/train/java
 */
public class AlphabetWar {
    public static String alphabetWar(String fight) {
        int rightSide = 0;
        int leftSide = 0;

        for (int index = 0; index < fight.length(); index++) {
            char letter = fight.charAt(index);
            if (letter == 'w') {
                leftSide += 4;
            } else if (letter == 'p') {
                leftSide += 3;
            } else if (letter == 'b') {
                leftSide += 2;
            } else if (letter == 's') {
                leftSide += 1;
            } else if (letter == 'm') {
                rightSide += 4;
            } else if (letter == 'q') {
                rightSide += 3;
            } else if (letter == 'd') {
                rightSide += 2;
            } else if (letter == 'z') {
                rightSide += 1;
            }
        }

        if ( leftSide > rightSide ) {
            return "Left side wins!";
        } else if ( rightSide > leftSide ){
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }
    public static void main(String args[]){
        System.out.println(alphabetWar("wmbpqz"));
    }
}
