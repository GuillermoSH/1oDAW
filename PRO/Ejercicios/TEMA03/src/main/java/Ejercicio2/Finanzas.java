package Ejercicio2;

public class Finanzas {
    private double cambio;

    public Finanzas(){
        this.cambio=0.89;
    }
    public Finanzas(double cambio){
        this.cambio=cambio;
    }
    public double dolaresToEuros(double dolares){
        return dolares*this.cambio;
    }
    public double eurosToDolares(double euros){
        return euros/this.cambio;
    }
}
