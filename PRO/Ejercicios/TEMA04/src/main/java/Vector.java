public class Vector {
    double[] componentes;
    private static int numVectores=0;

    /**
     * Método para limitar el número de constructores en la clase.
     * @return Número de vectores creados.
     */
    public static int getNumVectores(){
        return Vector.numVectores;
    }

    /**
     * Declaración de la dimensión del array.
     * @param n Numero de variables del array.
     */
    public Vector(int n){
        this.componentes=new double[n];
        Vector.numVectores++;
    }

    public Vector(double[] componentes){
        this.componentes=componentes.clone();
        Vector.numVectores++;
    }

    /**
     * Constructor de copia.
     * @param v Vector
     */
    public Vector(Vector v){
        this.componentes=v.componentes.clone();
        Vector.numVectores++;
    }

    /**
     * Función que comprueba si el vector introducido es compatible con el que ya tenemos generado.
     * @param v Vector.
     * @throws Exception Un error bonico
     */
    public void sonCompatibles(Vector v) throws Exception {
        if (this.componentes.length!=v.componentes.length){
            throw new Exception("Error vectores de distinta dimensión, no puedo sumarlos.");
        }
    }

    public Vector suma(Vector v) throws Exception {
        this.sonCompatibles(v);
        
        double[] suma=new double[this.componentes.length];
        
        for(int i=0;i<this.componentes.length;i++){
            suma[i]=this.componentes[i]+v.componentes[i];
        }
        return new Vector(suma);
    }
    
    public Vector resta(Vector v) throws Exception{
        this.sonCompatibles(v);

        double[] resta=new double[this.componentes.length];
        
        for(int i=0;i<this.componentes.length;i++){
            resta[i]=this.componentes[i]-v.componentes[i];
        }
        return new Vector(resta);
    }

    public double prodEscalar(Vector v) throws Exception{
        this.sonCompatibles(v);
        
        double suma=0;
        
        for(int i=0;i<v.componentes.length-1;i++){
            suma+=this.componentes[i]+v.componentes[i];
        }
        return suma;
    }

    public double modulo(){
        double suma=0;

        for(int i=0;i<this.componentes.length;i++){
            suma+=this.componentes[i]*this.componentes[i]; //Math.pow(this.componentes[i],2)
        }
        return Math.sqrt(suma);
    }

    @Override
    public String toString(){
        String res="(";

        for(int i=0;i<this.componentes.length;i++){
            if(i<this.componentes.length-1){
                res+=this.componentes[i]+",";
            } else {
                res+=this.componentes[i]+")";
            }
        }
        return res;
    }
}
