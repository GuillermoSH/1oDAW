package Ejercicio10;

import java.util.Scanner;

public class ConversorMillas {
    private double millaAmetro = 1852;
    
    /**
     * Contructor vacío de la clase
     * @param millas introducidas por teclado
     */
    public ConversorMillas(double millas){ 
    }

    /**
     * Función que convierte de millas a metros
     * @param millas introducidas por teclado
     * @return conversión a metros
     */
    public double millasAMetrosQ(double millas){
        return millas*millaAmetro;
    }

    /**
     * Función que convierte de millas a kilómetros
     * @param millas introducidas por teclado
     * @return conversión a kilómetros
     */
    public double millasAKilometrosQ(double millas){
        return millas*millaAmetro/1000;
    }

    public static void main(String []args){
        Scanner tec=new Scanner(System.in);
        
        System.out.print("Introduzca las millas que quiere convertir: ");
        double millas=tec.nextDouble();
        tec.close();

        ConversorMillas input = new ConversorMillas(millas);
        
        System.out.println("Sus "+millas+" millas son: "+input.millasAMetrosQ(millas)+" metros y "+input.millasAKilometrosQ(millas)+" kilómetros.");
    }
}
