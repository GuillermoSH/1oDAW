import java.io.*;
import java.util.*;

public class Futbol {
    private Map<String,Integer> puntos=new TreeMap<>();
    private Map<String,Integer> partidosJugados=new TreeMap<>();
    private String fichero;

    public Futbol(String fichero) throws FileNotFoundException{
        this.fichero=fichero;
        this.leerDatos();
        this.ordenar();
    }
    private void incrementarPartidosJugados(String equipo){
        if(this.partidosJugados.containsKey(equipo)){
            this.partidosJugados.put(equipo, this.partidosJugados.get(equipo)+1);
        } else{
            this.partidosJugados.put(equipo,1);
            // this.puntos.put(equipo,0);
        }
    }
    private void incrementaPuntos(String equipo, int puntos){
        if(this.puntos.containsKey(equipo)){
            this.puntos.put(equipo,this.puntos.get(equipo)+puntos);
        } else{
            this.puntos.put(equipo,puntos);
        }
    }
    public void leerDatos() throws FileNotFoundException{
        Scanner fichero=new Scanner(new File(this.fichero));
        String linea,nombreEquipo1,nombreEquipo2, resultado;
        String datosLinea[];

        while(fichero.hasNextLine()){
            linea=fichero.nextLine();
            datosLinea=linea.split(",");
            nombreEquipo1=datosLinea[0];
            nombreEquipo2=datosLinea[1];
            resultado=datosLinea[2];

            this.incrementarPartidosJugados(nombreEquipo1);
            this.incrementarPartidosJugados(nombreEquipo2);
            if(resultado.equals("1")){ // gana el 1er equipo +3ptos
                this.incrementaPuntos(nombreEquipo1,3);
            } else if(resultado.equals("2")){ // gana el 2o equipo +3ptos
                this.incrementaPuntos(nombreEquipo2,3);
            } else{ // X empatan +1pto a cada equipo
                this.incrementaPuntos(nombreEquipo1,1);
                this.incrementaPuntos(nombreEquipo2,1);
            }
        }
    }
    public void ordenar(){
        Map<String,Integer> puntosAux=new LinkedHashMap<>();
        
        while(this.puntos.size()>0){
            int maxPunt=-1;
            String equipoMax=null;

            for(String equipo:this.puntos.keySet()){
                if(this.puntos.get(equipo)>maxPunt){
                    equipoMax=equipo;
                    maxPunt=this.puntos.get(equipo);
                }
            }
            puntosAux.put(equipoMax,maxPunt);
            this.puntos=puntosAux;
        }
    }
    public void imprimir(){
        System.out.println("Liga nacional de fútbol, temporada 2021-2022");
        System.out.println("Clasificación:");
        System.out.println("Equipo               Puntos");
        System.out.println("-------------------- ------");
        for(String equipo:this.puntos.keySet()){
            System.out.printf("%-20s %6d\n",equipo,this.puntos.get(equipo));
        }
    }
    public static void main(String args[]) throws FileNotFoundException{
        String fichero="/media/daw/Toshiba DDe/Programacion/PRO/Ejercicios/TEMA04/src/main/java/DatosEjercicios/Tema04-ExtraArrays.E03.Partidos.txt";
    }
}
