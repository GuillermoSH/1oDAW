import java.io.*;
import java.util.*;

public class TemperaturasProf {
    private int[][] datos=new int[12][];
    private String path;

    public TemperaturasProf(String path){
        this.path=path;
    }

    public void leerDatos() throws FileNotFoundException{
        String linea;
        String[] datosMesStr;
        Scanner fDatos=new Scanner(new File(this.path));
        int mes=0;

        while(fDatos.hasNextLine()){
            linea=fDatos.nextLine();
            datosMesStr=linea.split(" ");
            datos[mes]=new int[datosMesStr.length];

            for(int dia=0;dia<datos[mes].length;dia++){
                datos[mes][dia]=Integer.parseInt(datosMesStr[dia]);
            }
            mes++;
        }
    }
    
    public double temperaturaMedia(int mes){
        double suma=0;
        
        for(int dia=0;dia<datos[mes].length;dia++){
            suma+=datos[mes][dia];
        }
        return suma/datos[mes].length;
    }
    
    public void imprimeMedias(){
        String[] meses=new String[]{"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

        for(int mes=0;mes<datos.length;mes++){
            System.out.printf("La media del mes de %s es %.2f",meses[mes],this.temperaturaMedia(mes));
        }
    }

    public static void main(String args[]) throws FileNotFoundException{
        TemperaturasProf a2019=new TemperaturasProf("rutaAbsoluta");
        a2019.leerDatos();
        //double m=a2019.temperaturaMedia(0);
        a2019.imprimeMedias();
    }
}
