package Biblioteca;

public class Revista extends Publicacion {
    private String issn;
    private int codigo;

    public Revista(String issn, String titulo, int anio, int codigo) {
        super(titulo, anio);
        this.issn = issn;
        this.codigo = codigo;
    }

    public String getIssn() {
        return this.issn;
    }

    public int getCodigo() {
        return this.codigo;
    }

    @Override
    public String toString() {
        return "ISSN: " + this.issn + ", título: " + this.titulo + ", año de publicación: " + this.anio;
    }
}
