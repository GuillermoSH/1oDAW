import java.util.Scanner;

public class CalculoAreasPropio {
    /**
     * Función encargada de calcular el area de un cuadrado
     * @param lado valor del lado
     * @return area calculada
     */
    private static double areaCuadrado(double lado){
        return calculaMultiplicación(lado, lado);
    }

    /**
     * Función encargada de calcular el área de un rectángulo
     * @param base base del rectángulo
     * @param altura altura del rectángulo
     * @return area calculada
     */
    private static double areaRectangulo(double base, double altura){
        return calculaMultiplicación(base, altura);
    }

    /**
     * Función encargada de calcular el área de un romboide
     * @param base base del romboide
     * @param altura altura del romboide
     * @return area calculada
     */
    private static double areaRomboide(double base, double altura){
        return calculaMultiplicación(base, altura);
    }

    /**
     * Función encargada de calcular el área de un triángulo
     * @param base base del triángulo
     * @param altura altura del triángulo
     * @return area calculada
     */
    private static double areaTriangulo(double base, double altura){
        return calculaMultiplicación(base, altura)/2;
    }

    /**
     * Función encargada de calcular el área de un rombo
     * @param diametro1 diámetro1 del rombo
     * @param diametro2 diámetro2 del rombo
     * @return area calculada
     */
    private static double areaRombo(double diametro1, double diametro2){
        return areaTriangulo(diametro1, diametro2);
    }

    /**
     * Función encargada de calcular la multiplicación 
     * @param valor1 valor1 de la multiplicación
     * @param valor2 valor2 de la multiplicación
     * @return resultado
     */
    private static double calculaMultiplicación(double valor1, double valor2){
        return valor1*valor2;
    }

    public static void main(String args[]){
        System.out.println("   0) Salir.");
        System.out.println("   1) Calculo área de cuadrado.");
        System.out.println("   2) Calculo área de rectángulo.");
        System.out.println("   3) Calculo área de romboide.");
        System.out.println("   4) Calculo área de triangulo.");
        System.out.println("   5) Calculo área de rombo.");
        System.out.print("\nIntroduce el valor de la opción que quiere realizar: ");
        Scanner tec=new Scanner(System.in);
        int opcion=tec.nextInt();

        switch(opcion){
            case 0: 
                break;
            case 1:
                System.out.print("\n\nIntroduce el valor del lado: ");
                tec.nextLine();
                double lado=tec.nextInt();
                tec.close();

                System.out.println("\nEl área es de: "+areaCuadrado(lado));
                break;
            case 2:
                System.out.print("\n\nIntroduce el valor de la base: ");
                tec.nextLine();
                double base=tec.nextInt();
                System.out.print("\nIntroduce el valor de la altura: ");
                tec.nextLine();
                double altura=tec.nextInt();
                tec.close();

                System.out.println("\nEl área es de: "+areaRectangulo(base,altura));
                break;
            case 3:
                System.out.print("\n\nIntroduce el valor de la base: ");
                tec.nextLine();
                double base2=tec.nextInt();
                System.out.print("\nIntroduce el valor de la altura: ");
                tec.nextLine();
                double altura2=tec.nextInt();
                tec.close();

                System.out.println("\nEl área es de: "+areaRectangulo(base2,altura2));
                break;
            case 4:
                System.out.print("\n\nIntroduce el valor de la base: ");
                tec.nextLine();
                double base1=tec.nextInt();
                System.out.print("\nIntroduce el valor de la altura: ");
                tec.nextLine();
                double altura1=tec.nextInt();
                tec.close();

                System.out.println("\nEl área es de: "+areaRomboide(base1,altura1));
                break;
            case 5:
                System.out.print("\n\nIntroduce el valor del diámetro 1: ");
                tec.nextLine();
                double diametro1=tec.nextInt();
                System.out.print("\nIntroduce el valor del diámetro 2: ");
                tec.nextLine();
                double diametro2=tec.nextInt();
                tec.close();

                System.out.println("\nEl área es de: "+areaRombo(diametro1,diametro2));
                break;
        }
    }
}
