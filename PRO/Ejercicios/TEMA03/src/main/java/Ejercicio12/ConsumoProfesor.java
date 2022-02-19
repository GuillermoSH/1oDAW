package Ejercicio12;

public class ConsumoProfesor {
    private double kms;
    private double litros;
    private double vmed;
    private double pgas;

    public ConsumoProfesor(double kms,double litros,double vmed,double pgas){
        this.kms=kms;
        this.litros=litros;
        this.vmed=vmed;
        this.pgas=pgas;
    }
    public double getTiempo(){
        return this.kms/this.vmed;
    }
    public double consumoMedio(){
        return this.litros/(this.kms/100);
    }
    public double consumoEuros(){
        return this.consumoMedio()*this.pgas;
    }
    public void setKms(double kms){
        this.kms=kms;
    }
}
