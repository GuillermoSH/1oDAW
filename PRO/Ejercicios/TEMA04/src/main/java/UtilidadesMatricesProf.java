public class UtilidadesMatricesProf {
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

    public static int[] sumaRara(int[] a,int b[]){
        int maxLen=(a.length>b.length ? a.length : b.length);  // (condicion "a<b" ? devuelve "a menor" : y si no devuelve "a mayor")
        int []res=new int[maxLen];
        int i;
        for(i=0;i<a.length && i<b.length;i++){
            res[i]=a[i]+b[i];
        }
        for(;i<a.length;i++){
            res[i]=a[i];
        }
        for(;i<b.length;i++){
            res[i]=b[i];
        }
        return res;
    }

    public int[][] suma(int a[][],int b[][]) throws Exception{
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

    public static int[] construyeArray(int n){
        int res[]=new int[n];

        for(int i=0;i<res.length;i++){
            res[i]=i+1;
        }
        return res;
    }
    /* 11. */
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
            if (i<a.length-1){
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
    
    /* 11.2- */
    public static int[] posicionesArray(int[] a,int n){
        int numReps=UtilidadesMatricesProf.numRepeticiones(a,n);
        
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

    public static int[] arrayAleatorio(int n,int inf,int sup) throws Exception{
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

    /* 16.- */
    public static boolean[] cribaEratostenes(int num){
        int limite=(int)Math.ceil(Math.sqrt(num)); // condición: la raiz cuadrada entera mirando hacia arriba

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
}
