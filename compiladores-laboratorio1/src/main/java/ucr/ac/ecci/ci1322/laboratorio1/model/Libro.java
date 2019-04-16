package ucr.ac.ecci.ci1322.laboratorio1.model;

public class Libro {

    private String isbn;
    private String titulo;
    private String[] autores;
    private int anno;
    private int edicion;
    private String editorial;

    public Libro(String isbn, String titulo, String[] autores, int anno, int edicion, String editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autores = autores;
        this.anno = anno;
        this.edicion = edicion;
        this.editorial = editorial;
    }

    public Libro(String isbn, String titulo, int anno, int edicion, String editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anno = anno;
        this.edicion = edicion;
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String[] getAutores() {
        return autores;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}
