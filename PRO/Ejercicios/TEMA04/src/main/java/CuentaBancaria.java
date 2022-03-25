/**
 * 2.- Método que devuelva los dígitos de control de una cuenta bancaria (ver notas al final de este documento).
 * @author Guillermo Sicilia Hernández
 * @version 0.3
 */
public class CuentaBancaria {
    static String banco="2048";
    static String oficina="0004";
    static String cuenta="1539880016";

    /**
     * Método que convierte los distintos string con valores a arrays de bytes para un mejor manejo.
     * @param cadena string que se quiera convertir a bytes.
     * @return Array de bytes con los valores del string introducido.
     */
    public static byte[] stringToBytes(String cadena){
        byte[] res=new byte[cadena.length()];

        for(int i=0;i<res.length;i++){
            res[i]=(byte)(cadena.charAt(i)-'0');
        }
        return res;
    }

    /**
     * Método para el cálculo de los digitos de control de una cuenta bancaria definida por:
     * @param banco Código de banco.
     * @param oficina Código de oficina.
     * @param cuenta Código de cuenta.
     * @return Digitos de control de la cuenta bancaria.
     */
    public static String DigitosControl(String banco, String oficina, String cuenta){
        byte[] b=stringToBytes(banco); //digitos del banco
        byte[] o=stringToBytes(oficina); //digitos de la oficina
        byte[] c=stringToBytes(cuenta); //digitos cuenta

        int suma1=4*b[0]+8*b[1]+5*b[2]+10*b[3]+9*o[0]+7*o[1]+3*o[2]+6*o[3]; //suma1=4*b1+8*b2+5*b3+10*b4+9*o1+7*o2+3*o3+6*o4
        int suma2=1*c[0]+2*c[1]+4*c[2]+8*c[3]+5*c[4]+10*c[5]+9*c[6]+7*c[7]+3*c[8]+6*c[9]; //suma2=1*c1+2*c2+4*c3+8*c4+5*c5+10*c6+9*c7+7*c8+3*c9+6*c10
        
        String digitosControl="";

        if((11-(suma1%11))==0){
            digitosControl+="0";
        } else {
            digitosControl+="1";
        }

        if((11-(suma2%11))==0){
            digitosControl+="0";
        } else {
            digitosControl+="1";
        }

        return digitosControl;
    }

    public static void main(String args[]){
        System.out.println("Digitos de control: "+DigitosControl(banco,oficina,cuenta));
    }
}
