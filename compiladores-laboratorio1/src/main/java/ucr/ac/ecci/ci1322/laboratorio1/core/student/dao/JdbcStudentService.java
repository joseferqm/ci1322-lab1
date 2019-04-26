package ucr.ac.ecci.ci1322.laboratorio1.core.student.dao;

import ucr.ac.ecci.ci1322.laboratorio1.model.Estudiante;

import java.sql.*;
import java.util.Properties;

public class JdbcStudentService implements StudentDao {

    private Connection conexion;

    /**
     * Único constructor.
     */
    public JdbcStudentService() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/lab01DB?useSSL=false";
        try {
            conexion = DriverManager.getConnection(url, "root", "menagerie");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    /**
     * Devuelve la instancia de <code>Estudiante</code> que se identifica por la hilera especificada dentro de la base
     * de datos, o <code>null</code> si el identificador no corresponde a ninguna instancia de <code>Estudiante</code>.
     *
     * @param id    la hilera que identifica a un estudiante
     * @return      el estudiante que tiene el identificador especificado
     */
    public Estudiante findById(String id) {
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT Cedula, Carne, Nombre, Apellido "
                    + "FROM Estudiante WHERE "
                    + "Cedula = '" + id + "'"
            );

            Estudiante estudiante = null;
            if ( resultados.next() ) {
                String carne = resultados.getString("Carne");
                String nombre = resultados.getString("Nombre");
                String apellido = resultados.getString("Apellido");
                estudiante = new Estudiante(id, carne, nombre, apellido);
            }

            return estudiante;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    /**
     * Agrega la instancia de <code>Estudiante</code> a la base de datos y devuelve la hilera que identifica a la
     * instancia.
     *
     * @param estudiante    el estudiante que se agrega a la base de datos
     * @return              la hilera que identifica al estudiante
     */
    public String create(Estudiante estudiante) {
        try {
            Statement statement = conexion.createStatement();

            String cedula = estudiante.getCedula();

            statement.executeUpdate("INSERT INTO Estudiante VALUES"
                    + "("
                    + "'" + cedula + "',"
                    + "'" + estudiante.getCarne() + "',"
                    + "'" + estudiante.getNombre() + "',"
                    + "'" + estudiante.getApellido() + "'"
                    + ")"
            );

            return cedula;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    /**
     * Actualiza la instancia de <code>Estudiante</code> en la base de datos.
     *
     * @param estudiante    el estudiante que se actualiza en la base de datos
     */
    public void update(Estudiante estudiante) {
        try {
            Statement statement = conexion.createStatement();

            String cedula = estudiante.getCedula();

            statement.executeUpdate("UPDATE Estudiante SET "
                    + "Carne = '" + estudiante.getCarne() + "', "
                    + "Nombre = '" + estudiante.getNombre() + "', "
                    + "Apellido = '" + estudiante.getApellido() + "' WHERE "
                    + "Cedula = '" + cedula + "'"
            );
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    /**
     * Elimina la instancia de <code>Estudiante</code> de la base de datos.
     *
     * @param estudiante    el estudiante que se elimina de la base de datos
     */
    public void remove(Estudiante estudiante) {
        try {
            Statement statement = conexion.createStatement();

            String cedula = estudiante.getCedula();

            statement.executeUpdate("DELETE FROM Estudiante WHERE "
                    + "Cedula = '" + cedula + "'"
            );
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
