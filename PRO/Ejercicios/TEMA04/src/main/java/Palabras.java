import java.util.*;
import java.io.*;

public class Palabras {
    private Map<String,Integer> palabras=new HashMap<>();

    public void leerDatos() throws FileNotFoundException{
        String linea;
        String palabrasLinea[];

        Scanner fichero=new Scanner(new File("/PRO/Unidades/T04-ArraysStringAlgoritmosOrdenacionHashMaps/DatosEjercicios/Tema04-HashMap.E01.txt"));
        
        while(fichero.hasNextLine()){
            linea=fichero.nextLine();
            palabrasLinea=linea.split("[ .,;\t]+");

            for(int i=0;i<palabrasLinea.length;i++){
                if(palabras.containsKey(palabrasLinea[i])){
                    int anterior=palabras.get(palabrasLinea[i]);
                    palabras.put(palabrasLinea[i],anterior+1);
                } else{
                    palabras.put(palabrasLinea[i],1);
                }
            }
        }
        fichero.close();
    }

    public void imprimirDatos(){
        for(String palabra:palabras.keySet()){
            System.out.printf("%s se repite %d veces.",palabra,palabras.get(palabra));
        }
    }

    public static void main(String args[]){
        Palabras p=new Palabras();
        try{
            p.leerDatos();
            p.imprimirDatos();
        } catch (Exception ex){
            ex.getMessage();
        }
    }
}
