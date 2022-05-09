public class Persona implements Cloneable {
    private String nombre, apellidos;
    private int edad;

    /**
     * Constructor de copia
     * 
     * @param p
     */
    public Persona(Persona p) {
        this.nombre = p.nombre;
        this.apellidos = p.apellidos;
        this.edad = p.edad;
    }

    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.nombre = nombre;
        this.edad = edad;
    }

    public void setEdad(int edad) {
        this.edad = edad; // es necesario el uso de this, porque hay ambigüedad
    }

    public void setNombre(String nom) {
        nombre = nom; // aquí no es necesario usar this, porque no hay ambigüedad
    }

    @Override
    public boolean equals(Object p) {
        if (this.nombre.equals(((Persona) p).nombre) && this.edad == ((Persona) p).edad
                && this.apellidos.equals(((Persona) p).apellidos)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s, Apellidos: %s, Edad: %s, IdObjPersona: %s.", this.nombre, this.apellidos,
                this.edad, super.toString());
    }

    @Override
    public Persona clone() throws CloneNotSupportedException {
        return (Persona) super.clone();
    }
}