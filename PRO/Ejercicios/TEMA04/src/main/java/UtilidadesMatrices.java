import java.util.ArrayList;

/**
 * Ejercicios de iniciación sobre arrays.
 * @autor Guillermo Sicilia Hernández
 * @version 1.0
 */
public class UtilidadesMatrices {

    /**
     * 4.- Añadir a la clase del ejercicio anterior el método public int[] suma(int a[],int b[]), el cuál
     * recibe dos arrays, y devuelve un array que representa la suma de todos los elementos que ocupan 
     * la misma posición de en a y b.
     * @param a Array unidimensional A.
     * @param b Array unidimensional B.
     * @return
     */
    public static int[] suma(int[] a,int b[]) throws Exception{
        if(a.length!=b.length){
            throw new Exception("Error en método suma: no coinciden las longitudes.");
        }
        int []res=new int[a.length];
        for(int i=0;i<a.length;i++){
            res[i]=a[i]+b[i];
        }
        return res;
    }

    /**
     * 5.- Añadir a la clase el método arrayBidSuma que recibe dos arrays bidimensionales de números enteros
     * y devuelve un array bidimensional con la suma de los elementos de la misma posición de ambos.
     * @param a Array a bidimensional.
     * @param b Array b bidimensional.
     * @return Suma de ambos arrays bidimensionales.
     */
    public int[][] arrayBidSuma(int a[][],int b[][]) throws Exception{
        if(a.length!=b.length || a[0].length!=b[0].length){
            throw new Exception("Error en método arrayBidSuma: no coinciden las dimensiones.");
        }
        int[][] res=new int[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                res[i][j]=a[i][j]+b[i][j];
            }
        }
        return res;
    }

    /**
     * 6.- Añadir a la clase un método construyeArray que reciba un número entero y devuelva un array de
     * números enteros con sus elementos inicializados a la posición de cada elemento (sólo que comenzando
     * por el lugar 1 en lugar de 0). Por ejemplo, si se le pasa como parámetro 5, devolverá el array de 
     * números enteros: {1,2,3,4,5}.
     * @param num Tamaño del array.
     * @return Array inicializado con sus variables.
     */
    public static int[] construyeArray(int num){
        int res[]=new int[num];

        for(int i=0;i<num;i++){
            res[i]=i+1;
        }
        return res;
    }

    /**
     * 7.- Añadir a la clase un método tablaMultiplicar que devuelve un array con la tabla de multiplicar
     * del número que se le pase por parámetro.
     * @param num Número entero del que se quiere obtener la tabla de multiplicar.
     * @return Tabla de multiplicar del número introducido.
     */
    public static int[] tablaMultiplicar(int num){
        int tabla[]={1,2,3,4,5,6,7,8,9,10};
        int res[]=new int[10];

        for(int i=0;i<10;i++){
            res[i]=tabla[i]*num;
        }
        return res;
    }

    /**
     * 8.- Añadir a la clase un método maximo que reciba un array de enteros y nos devuelve el mayor.
     * @param a Array de números introducidos.
     */
    public static void maximo(int a[]){
        int mayor;

        mayor=a[0];

        for(int i=0;i<a.length;i++){
            if(a[i] > mayor){
                mayor=a[i];
            }
        }
        System.out.printf("El número mayor es: %d",mayor);
    }

    /**
     * 9.- Ídem minimo.
     * @param a Array de números introducidos.
     */
    public static void minimo(int a[]){
        int menor;

        menor=a[0];

        for(int i=0;i<a.length;i++){
            if(a[i] < menor){
                menor=a[i];
            }
        }
        System.out.printf("El número menor es: %d",menor);
    }

    /**
     * 10.- Ídem mínimo y máximo a la vez (array de dos elementos donde el 1º es el mínimo y el 2º el
     * máximo)
     * @param a Array de números introducidos.
     */
    public static void minimoMaximo(int a[]){
        int menor,mayor;

        mayor=menor=a[0];

        for(int i=0;i<a.length;i++){
            if(a[i] > mayor){
                mayor=a[i];
            }
            if(a[i] < menor){
                menor=a[i];
            }
        }
        int res[]={menor,mayor};

        System.out.printf("El número menor y el mayor serán %d respectivamente.",res);
    }
    
    /**
     * 11.- Método posicionArray que recibe un array de enteros y un número entero y me devuelve la
     * posición de éste último dentro del array (-1 en caso de que no exista).
     * @param a Array introducido con números enteros.
     * @param n Número que se quiere comprobar dentro del array 'a'.
     * @param pos ...
     * @return Posiciones donde se repite el número pedido al usuario.
     */
    public static int posicionArray(int[] a,int n,int pos){
        for(int i=pos;i<a.length;i++){
            if(a[i]==n){
                return i;
            }
        }
        return -1;
    }

    public static int posicionArray(int[] a,int n){
        return posicionArray(a,n,0);
    }

    public static int numRepeticiones(int[] a, int n){
        int contador=0;
        
        for(int i=0;i<a.length;i++){
            if(a[i]==n){
                contador++;
            }
        }
        return contador;
    }

    public static String toString(int[] a){
        String res="{";
        int i;
        for(i=0;i<a.length;i++){
            if (i<a.length-1){
                res+=a[i]+", ";
            } else {
                res+=a[i];
            }
        }
        res+="}";
        
        return res;
    }
    
    public static String toString(boolean[] a){
        String res="{";
        int i;
        for(i=0;i<a.length;i++){
            if (i<a.length){
                if(a[i]){
                    res+=i+", ";
                } else{
                    res+="false, ";
                } 
            }
        }
        res+="}";
        return res;
    }

    /**
     * 11.2.- Utilizando el método anterior crear un nuevo método posicionesArray que reciba un array de
     * enteros y un número y nos devuelva un array con las posiciones donde aparece dicho número (array
     * vacío e caso de que no exista).
     * @param a Array de números enteros.
     * @param num Número que se quiere comprobar dentro del array.
     * @return Array con las posiciones de los números repetidos.
     */
    public static int[] posicionesArray(int[] a,int n){
        int numReps=UtilidadesMatrices.numRepeticiones(a,n);
        
        if(numReps==0){
            return new int[]{};
        }
        
        int res[]=new int[numReps];

        for(int i=0,pos=0;i<numReps;i++){
            res[i]=posicionArray(a,n,0);
            pos=res[i]+1;
        }
        return res;
    }

    /**
     * 12.- Añadir un método mediaArray que reciba un array de enteros y devuelva su media.
     * @param a Array de números enteros.
     * @return Media de los componentes del array.
     */
    public static double mediaArray(int a[]){
        int suma=0;

        for(int i=0;i<a.length;i++){
            suma+=a[i];
        }

        return (double)suma/a.length;
    }

    /**
     * 13.- Añadir un método invierteArray que devuelva el array de números enteros pasado como
     * parámetro en orden inverso.
     * @param a Array de números enteros.
     * @return Array 'a' con sus componentes invertidas.
     */
    public static int[] invierteArray(int a[]){
        int aInver[]=new int[a.length];

        for(int i=0,j=a.length-1;i<a.length;i++,j--){
            aInver[j]=a[i];
        }
        return aInver;
    }

    /**
     * 14.- Añadir un método arrayAleatorio que devolverá un array de n números enteros aleatorios
     * comprendidos entre inf y sup (ambos inclusive) y que no tenga ningún elemento repetido. P.ej.:
     * arrayAleatorio(6,1,49) ==> {1,7,6,5,49,39}.
     * @param n Número de elementos del array generado.
     * @param inf Número mín para la generación del número aleatorio.
     * @param sup Número máx para la generación del número aleatorio.
     * @return Array de números aleatorios.
     */
    public static int[] arrayAleatorio(int n,int inf,int sup) throws Exception{
        /* 
            [0,1) ---> [inf,sup)
    
            0 ----> inf   a*0+b=inf --> b=inf
            1 ----> sup   a*1+b=sup --> a+b=sup --> a+inf=sup --> a=sup-inf
           
            a*Math.random()+b
            (sup-inf)*Math.random()+inf
        */
        if(n > sup-inf+1){
            throw new Exception("Error arrayAleatorio: n es demasiado grande.");
        }
        int res[]=new int[n],numAleatorio;

        for(int i=0;i<res.length;){
            numAleatorio=(int)((sup-inf+1)*Math.random()+inf);
            
            if(UtilidadesMatrices.posicionArray(res, numAleatorio)<0){
                res[i]=numAleatorio;
                i++;
            }
        }
        return res;
    }

    /**
     * 15.- Lo mismo del ejercicio 6, sólo que cada posición contiene la suma de las posiciones
     * anteriores. Por ejemplo si se le pasa como parámetro 5, devolverá el array {1,1,2,4,8}.
     * @param num Tamaño del array.
     * @return Array con la suma de los números anteriores a cada posición.
     */
    public static int[] construyeArrayV2(int num){
        int res[]=new int[num];

        res[0]=1;

        for(int i=1;i<num;i++){
            for(int j=0;j<i;j++){
                res[i]+=res[j];
            }
        }
        return res;
    }

    /**
     * La criba de Eratóstenes, renombrado astrónomo y geógrafo griego del s. III a.C., es una técnica
     * para generar números primos. Se comienza escribiendo todos los enteros impares desde el 3 hasta
     * N; a continuación se elimina cada tercer elemento después de 3, cada quinto elemento después de
     * 5, etc. hasta que los múltiplos de todos los enteros impares menores que la raíz cuadrada de N
     * hayan sido eliminados. Los enteros que quedan constituyen la lista exacta de los números primos
     * entre 3 y N. Añadir el método cribaEratóstenes que devuelva una matriz de booleanos que nos
     * indica si el número de la posición correspondiente del índice es primo (true). Por ejemplo una 
     * llamada al método cribaEratóstenes(13) debería devolver la matriz:
     * {false,true,true,true,false,true,false,true,false,false,false,true,false,true}
     *   [0]   [1]  [2]  [3]  [4]   [5]  [6]   [7]  [8]   [9]   [10] [11]  [12]  [13]
     * @param num Número introducido por usuario para delimitar el rango de valores a comprobar.
     * @return Array booleano con la posición de los primos marcados en true.
     */
    /*
    +============================ PSEUDOCÓDIGO ============================+
    | Entrada: Un número natural n                                         |
    |                                                                      |
    | Salida: El conjunto de números primos anteriores a n (incluyendo n)  |
    |                                                                      |
    |   Escribir todos los números naturales desde 2 hasta n               |
    |   Para i desde 2 hasta √n hacer lo siguiente:                        |
    |       Si i no ha sido marcado entonces:                              |
    |           Para j desde i hasta n/i hacer lo siguiente:               |
    |               Poner una marca en i*j                                 |
    |                                                                      |
    | Resultado: Todos los números sin marca.                              |
    +======================================================================+
    */
    public static boolean[] cribaEratostenes(int num){
        int numNat[]=new int[num+1];
        int limite=(int)Math.ceil(Math.sqrt(num)); // condición(ceil): la raiz cuadrada entera mirando hacia arriba

        for(int i=0;i<numNat.length;i++){
            numNat[i]=i;
        }

        boolean res[]=new boolean[num+1];
        res[2]=true;

        for(int i=1;i<res.length;i+=2){ // bucle para poner los impares a true
            res[i]=true;
        }

        for(int i=3;i<=limite;i+=2){
            if(res[i]){
                for(int j=i+i;j<=num;j+=i){
                    res[j]=false;
                }
            }
        }
        return res;
    }

    /** 17.- Añadir un método eliminaRepetidos que reciba una matriz de enteros y devuelva una matriz con los
     * elementos repetidos elminados. P.ej.: eliminaRepetidos(new int[]{4,3,2,1,4,2,1,5,7,5}) devolverá:
     * {4,3,2,1,5,7}
     * @param a Array de números enteros.
     * @return Array resultante sin números repetidos.
     */
    public static int[] eliminaRepetidos(int[] a){
        int aux[]=new int[a.length];
        int i,j;
        boolean encontrado;
        
        aux[0]=a[0];

        for(i=1,j=1;i<a.length;i++){
            encontrado=false;
            for(int k=0;k<j;k++){
                if(a[i]==aux[k]){
                    encontrado=true;
                    break;
                }
            }
            if(encontrado!=true){
                aux[j]=a[i];
                j++;
            }
        }
        int res[]=new int[j];

        for(i=0;i<j;i++){
            res[i]=aux[i];
        }
        return res;
    }

    public static int[] eliminaRepetidosV2Listas(int a[]){
        ArrayList<Integer> l=new ArrayList<>();

        for(int i=0;i<a.length;i++){
            if(l.contains(a[i])){
                l.add(a[i]);
            }
        }
        int res[]=new int[l.size()];

        for(int i=0;i<res.length;i++){
            res[i]=l.get(i);
        }
        return res;
    }
}