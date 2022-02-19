public class Circulo {
    private double radio;

    public Circulo(double radio){
        this.radio=radio;
    }

    public double superficie(){
        return Math.PI*radio*radio;
    }
    public double longitudCircunferencia(){
        return 2*Math.PI*radio;
    }
}
