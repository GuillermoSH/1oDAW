/**
 * 2.- Método que devuelva los dígitos de control de una cuenta bancaria (ver notas al final de este documento).
 * @author Guillermo Sicilia Hernández
 * @version 0.1
 */
public class CuentaBancaria {
    String banco;
    String oficina;
    String cuenta;

    public byte[] stringToBytes(String cadena){
        byte[] res=new byte[cadena.length()];

        for(int i=0;i<res.length;i++){
            res[i]=(byte)(cadena.charAt(i)-'0');
        }
        return res;
    }

    public String DigitosControl(String banco, String oficina, String cuenta){
        byte[] b=stringToBytes(banco); //digitos del banco
        byte[] o=stringToBytes(oficina); //digitos de la oficina
        byte[] c=stringToBytes(cuenta); //digitos cuenta

        int suma1=4*b[0]+8*b[1]+5*b[2]+10*b[3]+9*o[0]+7*o[1]+3*o[2]+6*o[3]; //suma1=4*b1+8*b2+5*b3+10*b4+9*o1+7*o2+3*o3+6*o4
        int dif=11-(suma1%11);

        /*
        suma1 y suma2 contemplan la misma suma y productos de variables por tanto se podria usar
        una parte para ambas sumas:

        4*a+8*b+5*c+10*d+9*e+7*f+3*g+6*h
        */
        return banco;
    }
}
