public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion (int numerador, int denominador){
        this.numerador=numerador;
        this.denominador=denominador;
    }

    public Fraccion (Fraccion q){
        this.numerador=q.numerador;
        this.denominador=q.denominador;
    }

    public Fraccion division(Fraccion q){
        return new Fraccion(this.numerador*q.denominador,this.denominador/q.numerador);
    }

    public double getValorReal() throws Exception{
        return (double)this.numerador/this.denominador;
    }

    public Fraccion inverso() throws Exception{
        return new Fraccion(this.denominador,this.numerador);
    }

    public Fraccion opuesto() throws Exception{
        return new Fraccion(-this.numerador,this.denominador);
    }

    public Fraccion producto(Fraccion q){
        return new Fraccion(this.numerador*q.numerador,this.denominador*q.denominador);
    }

    public Fraccion reduce(){
        int mcd=UtilidadesTema05.mcd(this.numerador,this.denominador);
        return new Fraccion(this.numerador/mcm,this.denominador/mcm);
    }

    public Fraccion resta(Fraccion q) throws Exception{
        return this.suma(q.opuesto());
    }

    public Fraccion suma(Fraccion q) throws Exception{
        if(this.denominador==q.denominador){
            return new Fraccion(this.numerador+q.numerador,this.denominador+q.denominador);
        } else{
            int mcm=UtilidadesTema05.mcm(this.denominador,q.denominador);
            return new Fraccion(this.numerador*(mcm/this.denominador)+q.numerador*(mcm/this.denominador));
        }
    }

    @Override
    public String toString(){
        return String.format("%d/%d",this.numerador,this.denominador);
    }
}
