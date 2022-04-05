public class Estudiante {
    String nombre, ap1, ap2, curso;
    int edad;

    public Estudiante() {
    }

    public Estudiante(String nombre, String ap1, String ap2) {
        this.nombre = nombre;
        this.ap1 = ap1;
        this.ap2 = ap2;
    }

    public Estudiante(String nombre, String ap1, String ap2, int edad, String curso) {
        this(nombre, ap1, ap2);
        this.edad = edad;
        this.curso = curso;
    }

    public Estudiante(Estudiante e) {
        this(e.nombre, e.ap1, e.ap2, e.edad, e.curso);
    }

    public String toString() {
        return String.format("Nombre: %s %s %s, Edad: %d, Curso: %s", this.nombre, this.ap1, this.ap2, this.edad,
                this.curso);
    }

    public boolean equals(Object o) {
        Estudiante e = (Estudiante) o;
        return this.nombre.equals(e.nombre) && this.ap1.equals(e.ap1) && this.ap2.equals(ap2) && this.edad == e.edad
                && this.curso.equals(e.curso);
    }
}
