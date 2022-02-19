/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author daw
 */
public class Ecuacion2 {
    private double a; //no hay acceso a la variable desde otra clase
    double b;
    double c;

    public Ecuacion2(double a1, double b1, double c1){ //constructor
        a=a1;
        b=b1;
        c=c1;
    }
    
    public double solucion1(){ //solucion positiva
        return (-b+Math.sqrt(b*b-4*a*c))/(2*a);
    }

    public double solucion2(){ //solucion negativa
        return (-b-Math.sqrt(b*b-4*a*c))/(2*a);
    }
}
