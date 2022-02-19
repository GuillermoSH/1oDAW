public class UtilidadesStrings {
    /**
     * 1.- Método cuentaRepeticiones que recibe un carácter y una cadena y nos devuelve el número
     * de veces que el carácter aparece dentro de la cadena.
     * @param c Carácter que se desea encontrar en el String.
     * @param s String generado para la busqueda.
     * @return Número de veces que aparece el carácter dentro de la cadena.
     */
    public static int cuentaRepeticiones(char c,String s){
        int res=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                res++;
            }
        }
        return res;
    }

    /**
     * 2.- Método cuentaRepeticiones que recibe dos cadenas y nos dice cuantas veces aparece la 
     * primera dentro de la segunda.
     * @param needle Aguja: primera cadena de caracteres.
     * @param haystack Pajar: segunda cadena de caracteres.
     * @return Veces que se repite la primera cadena dentro de la segunda.
     */
    public static int cuentaRepeticiones(String needle, String haystack){
        int res=0,j;
        boolean encontrado;

        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                encontrado=true;

                for(j=1;j<needle.length() && (i+j)<haystack.length();j++){
                    if(needle.charAt(j)!=haystack.charAt(i+j)){
                        encontrado=false;
                        
                        break;
                    }
                }
                if(encontrado){
                    res++;
                    i+=needle.length();
                }
            }
        }
        return res;
    }

    public static int _cuentaRepeticiones(String needle, String haystack){
        int res=0;
        int j;

        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                for(j=1;j<needle.length() && needle.charAt(j)==haystack.charAt(j+i);j++);
                if(j>=needle.length()){
                    res++;
                    i+=needle.length();
                }
            }
        }
        return res;
    }

    /**
     * Método quitaEspacios que recibe una cadena y nos devuelve dicha cadena con todos los espacios
     * eliminados
     * @param s Cadena con espacios.
     * @return Cadena sin espacios.
     */
    public static String quitaEspacios(String s){
        String res="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                res+=s.charAt(i);
            }
        }
        return res;
    }

    /**
     * Método invertir que recibe una cadena s y nos devuelve la cadena "escrita al revés".
     * @param s Cadena inicial.
     * @return Cadena invertida.
     */
    public static String invertir(String s){
        String res="";
        for(int i=s.length()-1;i>=0;i--){
            res+=s.charAt(i);
        }
        return res;
    }

    /**
     * Método palindromo que recibe una cadena s y nos devuelve true si s es palíndromo.
     * @param s Cadena inicial a comprobar.
     * @return True o false dependiendo de si es palíndromo o no.
     */
    public static boolean palindromo(String s){
        return s.equals(UtilidadesStrings.invertir(s));
    }

    /**
     * Método toUpper que convierta una cadena todo a mayúsculas. P.ej.: toUpper("Juan") --> "JUAN"
     * @param s Cadena inicial a convertir.
     * @return Cadena convertida a mayúsculas.
     * @deprecated Obsoleto, para ello mira toUpperV2.
     */
    public static String toUpper(String s){
        String res="";
        for(int i=0;i<s.length();i++){
            res+=Character.toUpperCase(s.charAt(i)); // wrapper: porque envuelve un tipo de dato básico.
        }
        return res;
    }

    /**
     * Método para la conversión de caracteres tanto a mayúsculas como a minúsculas.
     * @param s Cadena de caracteres.
     * @param mayusculas True o false dependiendo de si el carácter esta en mayúsculas o minúsculas.
     * @return Carácter convertido.
     * @deprecated NO TIENE USO EN NINGÚN MÉTODO Y ESTÁ MAL PLANTEADO. Los métodos bien desarrollados
     * serían toUpper y toLower.
     */
    public static String convierteMayusMinus(String s,boolean mayusculas){
        String res="";
        char c;
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            if(mayusculas){
                if('a'<=c && c<= 'z' || c=='á' || c=='é' || c=='í' || c=='ó' || c=='ú' || c=='ñ'){
                    res+=(char)(c-32);
                }
            } else {
                if('A'<=c && c<= 'Z' || c=='Á' || c=='É' || c=='Í' || c=='Ó' || c=='Ú' || c=='Ñ'){
                    res+=(char)(c+32);
                }
            }
        }
        return res;
    }

    public static String toUpperV2(String s){
        String res="";
        char c;
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            if('a'<=c && c<= 'z' || c=='á' || c=='é' || c=='í' || c=='ó' || c=='ú' || c=='ñ'){
                res+=(char)(c-32);
            } else{
                res+=c;
            }
        }
        return res;
    }

    /**
     * Método toLower que convierta una cadena todo a minúsculas. P.ej.: toLower("JuaN") --> "juan"
     * @param s Cadena inicial a convertir.
     * @return Cadena convertida a minúsculas.
     * @deprecated Obsoleto, para ello mira toLoweV2.
     */
    public static String toLower(String s){
        String res="";
        for(int i=0;i<s.length();i++){
            res+=Character.toLowerCase(s.charAt(i)); // wrapper: porque envuelve un tipo de dato básico.
        }
        return res;
    }

    public static String toLowerV2(String s){
        String res="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if('A'<=c && c<= 'Z' || c=='Á' || c=='É' || c=='Í' || c=='Ó' || c=='Ú' || c=='Ñ'){
                res+=(char)(c+32);
            } else{
                res+=c;
            }
        }
        return res;
    }

    /**
     * Método ascii que escriba la tabla de códigos ascii de A-Z a-z 0-9.
     */
    public static void ascii(){
        for(char c='0';c<='9';c++){
            System.out.printf("%3d %3x %3c\n",(int)c,(int)c,c);
        }
        for(char c='A';c<='Z';c++){
            System.out.printf("%3d %3x %3c\n",(int)c,(int)c,c);
        }
        for(char c='a';c<='z';c++){
            System.out.printf("%3d %3x %3c\n",(int)c,(int)c,c);
        }
    }
}
