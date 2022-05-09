package Biblioteca;

public class Libro extends Publicacion implements Prestable {
    private String isbn;
    private boolean prestado;

    public Libro(String isbn, String titulo, int anio) {
        super(titulo, anio);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public void prestar() {
        this.prestado = true;
    }

    @Override
    public void devolver() {
        this.prestado = false;
    }

    @Override
    public boolean prestado() {
        return this.prestado;
    }

    @Override
    public String toString() {
        if (prestado) {
            return "ISBN: " + this.isbn + ", título: " + this.titulo + ", año de publicación: " + this.anio + " (prestado)";
        } else {
            return "ISBN: " + this.isbn + ", título: " + this.titulo + ", año de publicación: " + this.anio + " (no prestado)";
        }
    }
}
