public class Main {
    public static void main(String args[]){
        int num=6;
        int[] a={0,1,2,3,4,5,6};
        try{
            //int[] res=UtilidadesMatrices.construyeArrayV2(num);
            //System.out.println(UtilidadesMatricesProf.toString(UtilidadesMatricesProf.arrayAleatorio(6,1,49)));
            System.out.println(UtilidadesMatricesProf.toString(UtilidadesMatrices.cribaEratostenes(13)));
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }    
}
