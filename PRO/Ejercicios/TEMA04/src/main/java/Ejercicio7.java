import java.io.*;
import java.util.*;

public class Ejercicio7 {
    private double[] categorias=new double[5]; // a cuanto se paga la hora de cada categoria
    private int[] categoriasEmpleados=new int[101]; // a que categoria pertenece cada empleado
    private int[][] horasExtra=new int[101][32]; // cantidad de horas echadas por cada empleado

    public void cargarCategorias() throws FileNotFoundException{
        String fichero="/media/daw/Toshiba DDe/Programacion/PRO/Ejercicios/TEMA04/src/main/java/DatosEjercicios/Tema04-ExtraArrays.E07.DatosEmpresaPrecioHorasExtraCategorias.txt";
        String linea;
        String[] lineaDatos;
        Scanner fDatos=new Scanner(new File(fichero));

        fDatos.nextLine(); //salto de la primera linea de titulos

        while(fDatos.hasNextLine()){
            linea=fDatos.nextLine();
            lineaDatos=linea.split("[ ]+"); //separador por un espacio o más
            //lineaDatos=linea.split("\\s+") lo mismo que arriba
            this.categorias[Integer.parseInt(lineaDatos[0])]=Double.parseDouble(lineaDatos[1]);
        }
        fDatos.close();
    }

    public void cargarCategoriasEmpleados() throws FileNotFoundException{
        String fichero="/media/daw/Toshiba DDe/Programacion/PRO/Ejercicios/TEMA04/src/main/java/DatosEjercicios/Tema04-ExtraArrays.E07.DatosEmpresaCategoriasEmpleados.txt";
        String linea;
        String[] lineaDatos;
        Scanner fDatos=new Scanner(new File(fichero));

        fDatos.nextLine(); //salto de la primera linea de titulos

        while(fDatos.hasNextLine()){
            linea=fDatos.nextLine();
            lineaDatos=linea.split("[ ]+"); //separador por un espacio o más
            //lineaDatos=linea.split("\\s+") lo mismo que arriba
            this.categoriasEmpleados[Integer.parseInt(lineaDatos[0])]=Integer.parseInt(lineaDatos[1]);
        }
        fDatos.close();
    }

    public void cargarHorasExtra() throws FileNotFoundException{
        String fichero="/media/daw/Toshiba DDe/Programacion/PRO/Ejercicios/TEMA04/src/main/java/DatosEjercicios/Tema04-ExtraArrays.E07.DatosEmpresaHorasExtra.txt";
        String linea;
        String[] lineaDatos;
        Scanner fDatos=new Scanner(new File(fichero));
        int numEmp;

        fDatos.nextLine(); //salto de la primera linea de titulos

        while(fDatos.hasNextLine()){
            linea=fDatos.nextLine();
            lineaDatos=linea.split("[ ]+"); //separador por un espacio o más
            //lineaDatos=linea.split("\\s+") lo mismo que arriba
            numEmp=Integer.parseInt(lineaDatos[0]);

            for(int i=1;i<lineaDatos.length;i++){
                this.horasExtra[numEmp][i]=Integer.parseInt(lineaDatos[i]);
            }
        }
        fDatos.close();
    }

    public String format(int n, boolean izquierda, int longitud){
        String res=""+n;
        
        for(int i=0;i<longitud-res.length();i++){
            if(izquierda){
                res+=" ";
            } else{
                res=" "+res;
            }
        }
        return res;
    }

    public void listarHorasExtra(){
        int totalHoras=0;
        double totalPagado=0;

        System.out.printf("Empleado Horas Extra Cantidad a cobrar%n");
        System.out.printf("-------- ----------- -----------------%n");
        
        for(int nEmp=1;nEmp<this.horasExtra.length;nEmp++){
            if(this.categoriasEmpleados[nEmp]!=0){
                totalHoras=0;
                for(int dia=1;dia<this.horasExtra[0].length;dia++){
                    totalHoras+=this.horasExtra[nEmp][dia];
                }
                System.out.printf("%8d %11d %17.df",nEmp,totalHoras*this.categorias[this.categoriasEmpleados[nEmp]]);
                
                totalPagado+=totalHoras+this.categorias[this.categoriasEmpleados[nEmp]];
            }
        }
        System.out.printf("Total Pagado: %24.2f\n",totalPagado);
    }

    public void leerDatos() throws FileNotFoundException{
        this.cargarCategorias();
        this.cargarCategoriasEmpleados();
        this.cargarHorasExtra();
    }

    public static void main(String args[]) throws FileNotFoundException{
        Ejercicio7 e=new Ejercicio7();
        e.leerDatos();
        e.listarHorasExtra();
    }
}
