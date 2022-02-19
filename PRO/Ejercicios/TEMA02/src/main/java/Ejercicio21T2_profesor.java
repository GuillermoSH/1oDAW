public class Ejercicio21T2_profesor {
    public static boolean esBisiesto(int anio){

        return (anio%4==0 && anio%100!=0 || anio%100==0 && anio%400==0); // el &&='y' tiene prioridad sobre el ||='o' por lo que no hará falta poner el parentesis en ambas coondiciones
    }
    
    public static int numDias(int mes, int anio){
        int maxDia;
        
        switch(mes){
            case 4: case 6: case 9: case 11:
                maxDia=30;
                break;
            case 2:
                if(esBisiesto(anio)){
                    maxDia=29;
                } else{
                    maxDia=28;
                } 
                break;
            default: maxDia=31;
        }
        return maxDia;
        /*
        if(mes==4 || mes==6 || mes==9 || mes==11){
            maxDia=30;
        } else if(mes==2){
            if(esBisiesto(anio)){
                maxDia=29;
            } else{                       el switch hecho en el método numDias
                maxDia=28;                pero con ifs
            }
        } else{
            maxDia=31;
        }
        */
    }

    public static void main(String[] args) {
        
        int dia=Integer.parseInt(args[0]);
        int mes=Integer.parseInt(args[1]);
        int anio=Integer.parseInt(args[2]);

        if(mes<1 || mes>12){
            System.out.println("El mes es incorrecto, prueba de nuevo.");
            System.exit(1);
        }
        int maxDia=numDias(mes,anio);
        if(dia<1 || dia>maxDia){
            System.out.println("Error en día, el mes "+mes+" no puede tener como día: "+dia);
            System.exit(2);
        }
        System.out.println("La fecha es correcta!!");
    }    
}

/* 
hacer metodo para saber 
si el año es viciesto o no

viciesto=año/4
viciesto!=año/100
*/