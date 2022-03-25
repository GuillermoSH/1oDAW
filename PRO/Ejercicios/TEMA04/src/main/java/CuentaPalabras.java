import java.util.*;

public class CuentaPalabras {
    public static void cuentaPalabras(){
        HashMap<String,Integer>palabras=new HashMap<>();

        String linea="Hola  , que; tal.";
        String palabrasLinea[]=linea.split("[ ,;.\t]");
        String palabraActual;

        for(int i=0;i<palabrasLinea.length;i++){
            palabraActual=palabrasLinea[i];
            if(palabrasLinea[i].length()>0){
                if(palabras.containsKey(palabrasLinea[i])){
                    palabras.put(palabraActual,palabras.get(palabraActual)+1);
                } else{
                    palabras.put(palabraActual,1);
                }
            }
        }
    }
}
