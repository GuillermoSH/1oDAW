package Ejercicio5;

public class Satelite {
    private double meridiano;
    private double paralelo;
    private double distancia_tierra;

    Satelite(double m, double p, double d){
        meridiano=m;
        paralelo=p;
        distancia_tierra=d;
    }
    Satelite(){
        meridiano=paralelo=distancia_tierra=0;
    }
    public void setPosicion(double m, double p, double d){
        meridiano=m;
        paralelo=p;
        distancia_tierra=d;
    }
    public void printPosicion(){
        System.out.println("El satélite se encuentra en el paralelo "+paralelo+" Meridiano "+meridiano+" a una distancia de "+distancia_tierra);
    }
    public boolean enOrbita(){
        return distancia_tierra!=0;
    }
    public void variaAltura(double desplazamiento){
        this.distancia_tierra=this.distancia_tierra+desplazamiento;
    }
    public void variaPosicion(double variap, double variam){
        this.paralelo+=variap;
        this.paralelo+=variam;
    }
}
