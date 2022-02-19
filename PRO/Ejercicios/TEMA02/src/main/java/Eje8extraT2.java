/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author daw
 */
public class Eje8extraT2 {
    public static String permisoUnDigito(int digito){
        if(digito<0 || digito>7){
            return "";
        }
        switch(digito){ //digito>=0 && digito<=7
            case 0: return "---"; //000
            case 1: return "--x"; //001
            case 2: return "-w-"; //010
            case 3: return "-wx"; //011
            case 4: return "r--"; //100
            case 5: return "r-x"; //101
            case 6: return "rw-"; //110
            default: return "rwx"; //111
        }
    }
    
    public static String permisos(int n){
        int permisosPropietario, permisosGrupo, permisosOtros;
        
        permisosPropietario=n/100;
        permisosGrupo=(n/10)%10;
        permisosOtros=n%10;
        
        return permisoUnDigito(permisosPropietario)+permisoUnDigito(permisosGrupo)+permisoUnDigito(permisosOtros);
    }
}
