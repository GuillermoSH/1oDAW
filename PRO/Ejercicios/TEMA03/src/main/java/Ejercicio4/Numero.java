package Ejercicio4;

public class Numero {
    private int numero;

    public Numero(){
        this.numero=0;
    }
    public Numero(int numero){
        this.numero=numero;
    }
    public void añade(int n2){
        this.numero+=n2;
    }
    public void resta(int n2){
        this.numero-=n2;
    }
    public int getValor(){
        return this.numero;
    }
    public int getDoble(){
        return this.numero*2;
    }
    public int getTriple(){
        return this.numero*3;
    }
    public void setNumero(int numero){
        this.numero=numero;
    }
    public boolean igual(Numero n){ //ver si los numeros son iguales
        if(this.getValor()==n.getValor()){
            return true;
        } else{
            return false;
        }
    }
    public int comp(Numero n2){
        if(this.getValor()<n2.getValor()){
            return -1;
        } else if(this.getValor()==n2.getValor()){
            return 0;
        } else{
            return 1;
        }
    }
}
