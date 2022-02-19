import java.util.Scanner;

public class CalculoAreas {
    /**
     * Función encargada de calcular el area de un cuadrado
     * @param lado valor del lado
     * @return area calculada
     */
    private double areaCuadrado(double lado){
        return calculaMultiplicación(lado, lado);
    }

    /**
     * Función encargada de calcular el área de un rectángulo
     * @param base base del rectángulo
     * @param altura altura del rectángulo
     * @return area calculada
     */
    private double areaRectangulo(double base, double altura){
        return calculaMultiplicación(base, altura);
    }

    /**
     * Función encargada de calcular el área de un romboide
     * @param base base del romboide
     * @param altura altura del romboide
     * @return area calculada
     */
    private double areaRomboide(double base, double altura){
        return calculaMultiplicación(base, altura);
    }

    /**
     * Función encargada de calcular el área de un triángulo
     * @param base base del triángulo
     * @param altura altura del triángulo
     * @return area calculada
     */
    private double areaTriangulo(double base, double altura){
        return calculaMultiplicación(base, altura)/2;
    }

    /**
     * Función encargada de calcular el área de un rombo
     * @param diametro1 diámetro1 del rombo
     * @param diametro2 diámetro2 del rombo
     * @return area calculada
     */
    private double areaRombo(double diametro1, double diametro2){
        return areaTriangulo(diametro1, diametro2);
    }

    /**
     * Función encargada de calcular la multiplicación 
     * @param valor1 valor1 de la multiplicación
     * @param valor2 valor2 de la multiplicación
     * @return resultado
     */
    private double calculaMultiplicación(double valor1, double valor2){
        return valor1*valor2;
    }
}