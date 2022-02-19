package Ejercicio9;

public class PesoProfesor {
    private double peso;
    
    public PesoProfesor(double peso, String unidad){
        this.peso=PesoProfesor.toKilogramos(peso,unidad);
    }
    public double getLibras(){
        return PesoProfesor.kilogramosTo(this.peso,"Lb");
    }
    public double getLingotes(){
        return PesoProfesor.kilogramosTo(this.peso,"Li");
    }
    public double getPeso(String unidad){
        return PesoProfesor.kilogramosTo(this.peso,unidad);
    }
    public static double factorConversion(String unidad){
        switch(unidad){
            case "Lb": return 0.453;
            case "Li": return 14.59;
            case "Oz": return 0.002835;
            case "P" : return 0.00155;
            case "Q" : return 43.3;
            case "K" : return 1;
            case "G" : return 0.001;
            default  : return Double.NaN;
        }
    }
    public static double toKilogramos(double peso, String unidad){
        return peso*PesoProfesor.factorConversion(unidad);
    }
    public static double kilogramosTo(double peso, String unidad){
        return peso/PesoProfesor.factorConversion(unidad);
    }
}
