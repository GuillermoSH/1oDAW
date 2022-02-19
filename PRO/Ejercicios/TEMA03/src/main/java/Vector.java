public class Vector {
    private double x,y;

    public Vector(double x, double y){
        this.x=x;
        this.y=y;
    }
    public Vector suma(Vector v2){
        double sumax=this.x+v2.x;
        double sumay=this.y+v2.y;

        return new Vector(sumax,sumay);
    }
}
/**
 * Vector v1=new Vector(2,1);
 * Vector v2=new Vector(2,0);
 * Vector r=v1.suma(v2);
 */
