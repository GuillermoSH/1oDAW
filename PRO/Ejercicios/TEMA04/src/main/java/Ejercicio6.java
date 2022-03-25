import java.io.*;
import java.util.*;

public class Ejercicio6 {
    private int[][] datos;
    
    public void leerDatos(String fichero) throws FileNotFoundException{
        Scanner fDatos=new Scanner (new File(fichero));
        String linea="";
        String[] lineaDatos;
        int fil=0;

        if(fDatos.hasNextLine()){
            linea=fDatos.nextLine();
        } else{
            System.out.println("El Fichero está vacío.");
            System.exit(1);
        }

        lineaDatos=linea.split("\t");
        datos=new int[lineaDatos.length][lineaDatos.length];

        do{
            for(int col=0;col<datos.length;col++){
                this.datos[fil][col]=Integer.parseInt(lineaDatos[col]);
            }
            fil++;

            if(!fDatos.hasNextLine()){
                break;
            }
            linea=fDatos.nextLine();
            lineaDatos=linea.split("\t");
        } while(true);
    }

    public int getNumFilas(){
        return this.datos.length;
    }

    public int getNumCols(){
        return this.datos[0].length;
    }

    public int[] getNumFilsCols(){
        return new int[]{this.datos.length,this.datos[0].length};
    }

    public int sumaDiagonalPrinc(int i,int j) throws Exception{
        int suma=0;

        if(i!=0 && j!=0){
            throw new Exception("Error celda de inicio incorrecta.");
        }
        for(;i<datos.length && j<datos[0].length;i++,j++){
            suma+=this.datos[i][j];
        }
        return suma;
    }

    public int sumaDiagonalSec(int i,int j) throws Exception{
        int suma=0;

        if(i!=0 && j!=datos[0].length-1){
            throw new Exception("Error celda de inicio incorrecta.");
        }
        for(;j>=0 && i<datos[0].length;i++,j--){
            suma+=this.datos[i][j];
        }
        return suma;
    }

    public double _mediDiagonalPrincipal(){
        int suma=0;
        for(int i=0;i<this.datos.length;i++){
            suma+=this.datos[i][i];
        }
        return (double)suma/this.datos.length;
    }

    public double mediaDiagonalPrincipal() throws Exception{
        int suma=this.sumaDiagonalPrinc(0,0);
        return (double)suma/this.datos.length;
    }

    public void imprimirDiagonalesPrincipales() throws Exception{
        System.out.printf("La suma de los elementos por debajo de la diagonal principal es: %d",this.sumaDiagonalPrinc(1,0));
        System.out.printf("La suma de los elementos por debajo de la diagonal principal es: %d",this.sumaDiagonalPrinc(0,1));
    }

    public void imprimirDiagonalesSecundarias() throws Exception{
        System.out.printf("La suma de los elementos por debajo de la diagonal secundaria es: %d",this.sumaDiagonalSec(1,this.getNumCols()-1));
        System.out.printf("La suma de los elementos por debajo de la diagonal secundaria es: %d",this.sumaDiagonalSec(0,this.getNumCols()-2));
    }

    public double mediaDiagonalSecundaria() throws Exception{
        int suma=this.sumaDiagonalSec(0,0);
        return (double)suma/this.datos.length;
    }

    public double _mediDiagonalSecundaria(){
        int fila=this.datos.length-1;
        int col=0,suma=0;

        for(;fila>=0;fila--,col++){
            suma+=this.datos[fila][col];
        }
        return (double)suma/datos.length;
    }

    public static void main(String args[]) throws FileNotFoundException{
        Ejercicio6 e=new Ejercicio6();
        e.leerDatos("rutaAbsoluta");
        try{
            //a)
            System.out.printf("La media de los elementos de la diagonal principal es: %.2f.\n",e.mediaDiagonalPrincipal());
            //b)
            System.out.printf("La media de los elementos de la diagonal secundaria es: %.2f.\n",e.mediaDiagonalSecundaria());
            //c)
            e.imprimirDiagonalesPrincipales();
            //d)
            e.imprimirDiagonalesSecundarias();

            //System.out.println(e.sumaDiagonalPrinc(0,0));
            //System.out.println(e.sumaDiagonalSec(0,e.getNumCols()-1));
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
