public class Persona {
    private String nombre;
    private int edad;
    private String DNI;

    public Persona(String nombre, int edad, String DNI){
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setDNI(DNI);
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setEdad(int edad){
        if(edad>=0 && edad<=270){
            this.edad=edad;
        } else {
            //throw new Exception...
        }
    }

    public void setDNI(String DNI){
        String digitos=DNI.substring(0,DNI.length()-1);
        String letra=DNI.substring(DNI.length()-1,DNI.length());
        String letrasValidas="TRWAGMYFPDXBNJZSQVHLCKE";
        
        int resto=Integer.parseInt(digitos)%23;

        letrasValidas.charAt(resto);

        if(letra.equals(""+letrasValidas.charAt(resto))){
            this.DNI=DNI;
        }else{
            //throw new Exception
        }

        this.DNI=DNI;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public int getEdad(){
        return this.edad;
    }
    public String getDNI(){
        return this.DNI;
    }
    @Override
    public String toString(){
        return "[Persona:\n· DNI:"+this.DNI+"\n· Nombre: "+this.nombre+"\n· Edad: "+this.edad+"]";
    }
    public boolean esMayorDeEdad(){
        return this.edad>=18;
    }
}
