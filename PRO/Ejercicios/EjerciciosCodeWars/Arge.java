public class Arge {

    public static int nbYear(int p0, double percent, int aug, int p) {
        int years = 0;
        percent = percent / 100;

        while (p0 < p) {
            p0 = p0 + (int)(Math.round(p0 * percent)) + aug;
            years++;
        }
        return years;
    }

    
    public static int nbYearv2(int p0, double percent, int aug, int p) {
        int years = 0;
        double result = p0;
        percent = percent / 100;
        
        while ( true ) {
            result = result + result * percent + aug;
            years ++;
            
            if ( result > p ) {
                break;
            }
        }
        return years;
    }
    
    public static int nbYearv3(int p0, double percent, int aug, int p) {
        int years = 0;
        percent = percent / 100;

        while ( Math.round(p0) <= p) {
            p0 = p0 + (int)(p0 * percent) + aug;
            years++;
        }
        return years;
    }
    public static void main(String args[]) {
        System.out.printf("Will be reached in %d years\n", nbYear(1500000, 2.5, 10000, 1690000));
    }
}