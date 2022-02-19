/**
 * Crear la clase Peso, la cual tendrá las siguientes características:
 *  - Deberá tener un atributo donde se almacene el peso de un objeto en kilogramos
 *  - En el contructor s ele pasará el peso y la medida en la que se ha tomado ('Lb' para libras, 'Li' para lingotes, 'Oz' para onzas, 'P' para peniques, 'K' para kilos, 'G' para gramos y 'Q' para quintales).
 *  - Deberá de tener los siguientes métodos
 *      -getLibras. Devuelve el peso en libras
 *      -getLingotes. Devuelve el peso en lingotes
 *      -getPeso. Devuelve el peso en la medida que se pase como parámetro
 *  - Para la realizacuón del ejercicio toma como referencia los siguientes datos:
 *      1 Libra = 16 onzas = 0,453 Kgramos
 *      1 Lingote = 32,17 libras = 14,59 kg
 *      1 Onza = 0,0635 libras = 0,02835 Kgramos
 *      1 Penique = 0,05 onzas = 0,00155 Kgramos
 *      1 Quintal = 100 libras = 43,3 kg
 *  - Crea además un método main para testear y verificar los métodos de la clase.
 */
package Ejercicio9;

import java.util.Scanner;

public class Peso {
    private double peso;

    public Peso(double peso, String unidad){
        this.peso=peso*conversionUnidad(unidad);
    }

    public double conversionUnidad(String unidad){
        double factor;
        
        switch(unidad){
            case "lb": factor = 0.453;
                break;
            case "li": factor = 14.59;
                break;
            case "oz": factor = 16/0.453;
                break;
            case "p": factor = 0.00155;
                break;
            case "k": factor = 1;
                break;
            case "g": factor = 1000;
                break;
            case "q": factor = 43.3;
                break;
            default: factor = 1; //por si se da el caso de que el usuario responde con otro valor de medida
        }
        return factor;
    }
    public double getLibras(){
        return peso/conversionUnidad("Lb");
    }
    public double getLingotes(){
        return peso/conversionUnidad("Li");
    }
    public double getPeso(String medida){
        return peso/conversionUnidad(medida);
    }
    public static void main(String []args){
        Peso objeto;

        System.out.print("Introduzca el peso que quiere convertir: ");
        Scanner tec = new Scanner(System.in);
        double peso=tec.nextDouble();

        System.out.print("\nIntroduzca la unidad de medida de su pesaje: ");
        tec.nextLine();
        String medida=tec.nextLine();
        tec.close();

        objeto = new Peso(peso,medida);

        System.out.println("\nPeso del objeto en Kilogramos: "+objeto.getPeso("k"));
        System.out.println("\n                   Libras: "+objeto.getPeso("lb"));
        System.out.println("\n                   Lingotes: "+objeto.getPeso("li"));
        System.out.println("\n                   Onzas: "+objeto.getPeso("oz"));
        System.out.println("\n                   Peniques: "+objeto.getPeso("p"));
        System.out.println("\n                   Gramos: "+objeto.getPeso("g"));
        System.out.println("\n                   Quintales: "+objeto.getPeso("q"));
    }
}
