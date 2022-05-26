package TEMA06;

public class Persona implements Comparable<Persona> {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return String.format("(Persona-> Nombre: %s, Edad: %d)", this.nombre, this.edad);
    }

    /*
     * @Override
     * public int compareTo(Persona p) {
     * return this.nombre.compareTo(p.nombre);
     * }
     */
    public int compareTo(Persona p) {
        // return p.edad - this.edad;
        if (this.edad < p.edad) {
            return 1;
        } else if (this.edad == p.edad) {
            return 0;
        } else {
            return -1;
        }
    }
}
