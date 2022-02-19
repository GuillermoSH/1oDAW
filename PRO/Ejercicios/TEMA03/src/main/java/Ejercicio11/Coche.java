package Ejercicio11;

public class Coche {
    private String marca;
    private String modelo;
    public static int numeroCoches=0;

    public Coche(){
        this.marca="Toyota";
        this.modelo="i30";
        numeroCoches++;
    }
    public Coche(String marca, String modelo){
        this.marca=marca;
        this.modelo=modelo;
        numeroCoches++;
    }
    public String getMarca(){
        return marca;
    }
    public String setMarca(String m){
        return marca;
    }
    public String setModelo(String m){
        return modelo;
    }
    public String getModelo(){
        return modelo;
    }
}
