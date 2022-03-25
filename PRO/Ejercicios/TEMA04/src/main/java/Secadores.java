import java.util.*;

import javax.sound.midi.Soundbank;

import java.io.*;

public class Secadores {
    private Map<Integer,String> empleados=new TreeMap<>(); // TreeMap ordena por la clave a diferencia del HashMap
    private Map<Integer,Integer> ventas=new TreeMap<>();

    public void leerDatos() throws FileNotFoundException{
        Scanner fichero=new Scanner(new File("/media/daw/Toshiba DDe/Programacion/PRO/Ejercicios/TEMA04/src/main/java/DatosEjercicios/Tema04-HashMap.E02.DatosEmpresaSecadores.txt"));
        String linea;
        String datosLinea[];
        int nEmpleado; //codigo de empleado
        int nVentas; //numero de ventas

        while(fichero.hasNextLine()){
            linea=fichero.nextLine();
            datosLinea=linea.split("\t");
            nEmpleado=Integer.parseInt(datosLinea[0]);
            nVentas=Integer.parseInt(datosLinea[2]);
            this.empleados.put(nEmpleado,datosLinea[1]);

            if(ventas.containsKey(nEmpleado)){
                this.ventas.put(nEmpleado,this.ventas.get(nEmpleado)+nVentas);
            } else{
                this.ventas.put(nEmpleado,nVentas);
            }
        }
    }
    
    public void imprimirDatos(){
        System.out.println("Número Empleado Nombre                Ventas");
        System.out.println("--------------- --------------------- ------");

        for(int nEmpleado:this.empleados.keySet()){ //foreach
            System.out.printf("%15d %-21s %6d\n",nEmpleado,this.empleados.get(nEmpleado),this.ventas.get(nEmpleado)); // "d"=Integer "s"=String "-"=elementos a la izquierda
        }
    }

    public static void main(String args[]) throws FileNotFoundException{
        Secadores s=new Secadores();
        s.leerDatos();
        s.imprimirDatos();
    }
}
