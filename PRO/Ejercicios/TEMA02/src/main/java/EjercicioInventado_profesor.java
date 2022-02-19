public class EjercicioInventado_profesor {
    public static long longRandom(long min, long max){
        long resto=max-min+1;
        return (long)(resto*Math.random()+min);
    }
    public static void main(String []args){
        //long numero;
        while(true){
            System.out.println((char)longRandom(32,126));
        }
    }
}
