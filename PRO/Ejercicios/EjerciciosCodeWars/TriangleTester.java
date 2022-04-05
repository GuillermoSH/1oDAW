/**
 * KATA: https://www.codewars.com/kata/56606694ec01347ce800001b/train/java
 */
public class TriangleTester {
    public static boolean isTriangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }

        if (a + b > c && a + c > b && c + b > a) {
            return true;
        } else {
            return false;
        }
    }
}
