import java.io.*;
import java.util.*;

public class TemperaturasProf {
    public int [][] datos=new int[12][];
    private String path;

    //constructor para pasarle la ruta del archivo
    public TemperaturasProf(String path){
        this.path=path;
    }
    public void leerDatos() throws FileNotFoundException {
        //Tema04-ExtraArrays.E05.DatosTemperaturas.txt
        Scanner fDatos=new Scanner(new File(this.path));
        String linea;
        String [] datosMesStr;
        int mes=0;
        
        //has, mientras haya otra linea
        while(fDatos.hasNextLine()){
            linea=fDatos.nextLine();
            datosMesStr=linea.split("  ");
            datos[mes]=new int[datosMesStr.length];

            for(int dia=0; dia<datos[mes].length;dia++){
                datos[mes][dia]=Integer.parseInt(datosMesStr[dia]);
                
            }
            mes++;
        }

    } 
    //la temperatura de media de cada mes
    public double temperaturaMedia(int mes){
        double suma=0;
        for(int dia=0;dia<datos[mes].length;dia++){
            suma+=datos[mes][dia];
        }
        return suma/datos[mes].length;
    }

    public void imprimeMedias(){
        for(int mes=0;mes<datos.length;mes++){
            System.out.printf("La media del mes de %s es %.2f. %n",nombreMes(mes),this.temperaturaMedia(mes));
        }
    }

    //el dia mas caluroso y mas frio de cada mes
    public int [] diasMasExtremos (int mes){
        int indMin=0;
        int indMax=0;
        for(int i=1;i<datos[mes].length;i++){ //si no pongo el corchete [mes] estaria recorriendo los meses, en vez de los dias
            if(datos[mes][i]<datos[mes][indMin]){
                indMin=i;
            } 
            if(datos[mes][i]>datos[mes][indMax]){
                indMax=i;
            }
        }
        //para que nos nos salga el dia 0
        return new int[]{indMin+1,indMax+1};
    }

    public void imprimeTemperaturasExtremas(){
        int [] datosMes;
        for(int i=0;i<datos.length;i++){
            datosMes=diasMasExtremos(i);
            System.out.printf("El dia más frio de %s fue %d. \n",nombreMes(i),datosMes[0]);
            System.out.printf("El dia más caluroso de %s fue %d. \n",nombreMes(i),datosMes[0]);
        }
    }

    public String nombreMes(int m){
        String[] meses=new String[]{"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        return meses[m];
    }


    public void imprimeDiasExtremosAño(){
        
        int [] indMin={0,diasMasExtremos(0)[0]};
        int [] indMax={0,diasMasExtremos(0)[1]};
        for(int i=0;i<datos.length;i++){
            
            if(datos[indMin[0]][indMin[1]]>datos[i][diasMasExtremos(i)[0]]){
                
            }
            if(datos[indMax[0]][indMax[1]]<datos[i][diasMasExtremos(i)[1]]){
                indMax[0]=i;
                indMax[1]=diasMasExtremos(i)[0];
            }
        }
        System.out.printf("El día más frío del año es: %d %s.\n",indMin[1],this.nombreMes(indMin[0]));
        System.out.printf("El día más caluroso del año es: %d %s.\n",indMax[1],this.nombreMes(indMax[0]));
    }

    public static void main(String[] args) throws FileNotFoundException {
      TemperaturasProf a2019=new TemperaturasProf("rutaAbsoluta");
      
      //anio2019.imprimeMedias();
      System.out.printf("Los dias de minima y maxima son: %s",Arrays.toString(a2019.diasMasExtremos(1)));//mes de febrero
      a2019.imprimeTemperaturasExtremas();
      a2019.imprimeDiasExtremosAño();
    }
}