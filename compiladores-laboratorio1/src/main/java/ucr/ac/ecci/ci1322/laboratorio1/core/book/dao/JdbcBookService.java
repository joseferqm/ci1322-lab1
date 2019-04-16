package ucr.ac.ecci.ci1322.laboratorio1.core.book.dao;

import ucr.ac.ecci.ci1322.laboratorio1.model.Libro;

import java.sql.*;
import java.util.ArrayList;

public class JdbcBookService implements BookDao {

    private Connection conexion;

    /**
     * TODO: comentar
     */
    public JdbcBookService() {
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
     * Devuelve la instancia de <code>Libro</code> que se identifica
     * por la hilera especificada dentro del mecanismo de persistencia,
     * o <code>null</code> si el identificador no corresponde a ninguna
     * instancia de <code>Libro</code>.
     *
     * @param id    la hilera que identifica a un libro
     * @return      el libro que tiene el identificador especificado
     */
    public Libro findById(String id) {
        try {
            Statement statement = conexion.createStatement();
            ResultSet resultados = statement.executeQuery("SELECT Isbn, Titulo, Anno, Edicion, Editorial"
                    + " FROM Libro WHERE"
                    + " Isbn = '" + id + "'"
            );

            Libro libro = null;
            if ( resultados.next() ) {
                String titulo = resultados.getString("Titulo");
                int anno = resultados.getInt("Anno");
                int edicion = resultados.getInt("Edicion");
                String editorial = resultados.getString("Editorial");
                libro = new Libro(id, titulo, anno, edicion, editorial);

                resultados = statement.executeQuery("SELECT Autor FROM Escrito_por WHERE"
                        + " Isbn = '" + id + "'"
                );

                ArrayList<String> listaAutores = new ArrayList<String>();
                String[] autores = null;
                while ( resultados.next() ) {
                    listaAutores.add(resultados.getString("Autor"));
                }
                autores = listaAutores.toArray(new String[listaAutores.size()]);
                libro.setAutores(autores);
            }

            return libro;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    /**
     * Agrega la instancia de <code>Libro</code> al mecanismo
     * de persistencia y devuelve la hilera que identifica a la instancia.
     *
     * @param libro el libro que se agrega al mecanismo de persistencia
     * @return      la hilera que identifica al libro
     */
    public String create(Libro libro) {
        try {
            Statement statement = conexion.createStatement();

            String isbn = libro.getIsbn();

            statement.executeUpdate("INSERT INTO Libro VALUES"
                    + "("
                    + "'" + isbn + "',"
                    + "'" + libro.getTitulo() + "',"
                    + libro.getAnno() + ","
                    + libro.getEdicion() + ","
                    + "'" + libro.getEditorial() + "'"
                    + ")"
            );

            String[] autores = libro.getAutores();
            for (String autor : autores) {
                statement.executeUpdate("INSERT IGNORE INTO Autor VALUES"
                        + "("
                        + "'" + autor + "'"
                        + ")"
                );
                statement.executeUpdate("INSERT INTO Escrito_por VALUES"
                        + "("
                        + "'" + isbn + "',"
                        + "'" + autor + "'"
                        + ")"
                );
            }

            return isbn;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    /**
     * Actualiza la instancia de <code>Libro</code> en el mecanismo
     * de persistencia.
     *
     * @param libro
     */
    public void update(Libro libro) {
        // TODO: implementar
    }

    /**
     * Elimina la instancia de <code>Libro</code> del mecanismo
     * de persistencia.
     *
     * @param libro
     */
    public void remove(Libro libro) {
        // TODO: implementar
    }
}
