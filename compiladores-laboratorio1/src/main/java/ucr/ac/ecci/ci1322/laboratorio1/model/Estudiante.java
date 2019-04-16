package ucr.ac.ecci.ci1322.laboratorio1.model;

public class Estudiante {

    private String cedula;
    private String carne;
    private String nombre;
    private String apellido;

    public Estudiante(String cedula, String carne, String nombre, String apellido) {
        this.cedula = cedula;
        this.carne = carne;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
