package Ejercicio12;
import java.util.Scanner;
public class Consumo {
    private double kms;
    private double litros;
    private double vmed;
    private double pgas;

    public Consumo(double kms, double litros, double vmed, double pgas){
        this.kms=kms;
        this.litros=litros;
        this.vmed=vmed;
        this.pgas=pgas;
    }
    public double getTiempo(){
        return kms/vmed;
    }
    public double consumoMedio(){
        return litros/kms*100;
    }
    public double consumoEuros(){
        return litros*pgas/kms*100;
    }
    public void setKms(double kms){
        this.kms=kms;
    }
    public void setLitros(double litros){
        this.litros=litros;
    }
    public void setVmed(double vmed){
        this.vmed=vmed;
    }
    public void setPgas(double pgas){
        this.pgas=pgas;
    }
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        System.out.println("En este orden, escribe los kilometros recorridos, los litros usados, la velocidad media y el precio del gas"); 
        double litros, vmed, pgas,kms;
        kms = tec.nextInt();
        litros = tec.nextDouble();
        vmed = tec.nextDouble();
        pgas = tec.nextDouble();
        tec.close();

        Consumo consumo = new Consumo(kms, litros, vmed, pgas);

        System.out.println("Duracion del trayecto: " + consumo.getTiempo() + " horas");
        System.out.println("Consumo medio en litros: " + consumo.consumoMedio() + " litros cada 100 kilometros");
        System.out.println("Consumo medio en euros: " + consumo.consumoEuros() + " euros cada 100 kilometros");
    }
}