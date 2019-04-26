package ucr.ac.ecci.ci1322.laboratorio1.core.book.dao;

import ucr.ac.ecci.ci1322.laboratorio1.model.Libro;

public interface BookDao {

    /**
     * Devuelve la instancia de <code>Libro</code> que se identifica por la hilera especificada dentro del mecanismo de
     * persistencia, o <code>null</code> si el identificador no corresponde a ninguna instancia de <code>Libro</code>.
     *
     * @param id    la hilera que identifica a un libro
     * @return      el libro que tiene el identificador especificado
     */
    Libro findById(String id);

    /**
     * Agrega la instancia de <code>Libro</code> al mecanismo de persistencia y devuelve la hilera que identifica a la
     * instancia.
     *
     * @param libro el libro que se agrega al mecanismo de persistencia
     * @return      la hilera que identifica al libro
     */
    String create(Libro libro);

    /**
     * Actualiza la instancia de <code>Libro</code> en el mecanismo de persistencia.
     *
     * @param libro el libro que se actualiza en el mecanismo de persistencia
     */
    void update(Libro libro);

    /**
     * Elimina la instancia de <code>Libro</code> del mecanismo de persistencia.
     *
     * @param libro el libro que se elimina del mecanismo de persistencia
     */
    void remove(Libro libro);
}
