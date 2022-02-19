public class Amigo {
    private String nombre;
    private String telefono;
    private String cumple;
    private String email;

    public Amigo(String nombre, String telefono, String cumple, String correo){
        this.nombre=nombre;
        this.telefono=telefono;
        this.cumple=cumple;
        this.email=correo;
    }
    public void setCumple(String cumple){
        this.cumple=cumple;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return this.email;
    }
}
