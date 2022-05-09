public class DominoAppProf {
    public static void main(String args[]) {
        FichaDominoProf f1 = new FichaDominoProf(6, 1);
        FichaDominoProf f2 = new FichaDominoProf(0, 4);
        FichaDominoProf f3 = new FichaDominoProf(3, 3);
        FichaDominoProf f4 = new FichaDominoProf(0, 1);

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);
        System.out.println(f2.voltea());
        System.out.println(f2.encaja(f4));
        System.out.println(f1.encaja(f4));
        System.out.println(f1.encaja(f3));
        System.out.println(f1.encaja(f2));
    }
}
