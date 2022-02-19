public class CuentaJoven extends Cuenta {
    private int bonificacion;

    public CuentaJoven(Persona titular,int bonificacion){
        super(titular);
        this.bonificacion=bonificacion;
    }
    public CuentaJoven(Persona titular,double cantidad,int bonificacion){
        super(titular,cantidad);
        this.bonificacion=bonificacion;
    }
    public void setBonificacion(int bonificacion){
        this.bonificacion=bonificacion;
    }
    public int getBonificacion(){
        return this.bonificacion;
    }
    public boolean esTitularValido(){
        Persona titular=this.getTitular();
        return titular.esMayorDeEdad() && titular.getEdad()<25;
    }
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("Cuenta Joven");
        System.out.println("Bonificación: "+this.bonificacion);
    }
    @Override
    public void retirar(double reintegro){
        if(this.esTitularValido()){
            super.retirar(reintegro);
        }else{
            //throw new Exception...
        }
    }
}
