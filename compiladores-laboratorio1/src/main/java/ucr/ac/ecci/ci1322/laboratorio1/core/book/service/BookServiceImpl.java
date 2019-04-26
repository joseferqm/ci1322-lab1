package ucr.ac.ecci.ci1322.laboratorio1.core.book.service;

import ucr.ac.ecci.ci1322.laboratorio1.core.book.dao.BookDao;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.dao.JdbcBookService;
import ucr.ac.ecci.ci1322.laboratorio1.model.Libro;

public class BookServiceImpl implements BookService {

    private BookDao libroDao;

    /**
     * Único constructor.
     */
    public BookServiceImpl() {
        libroDao = new JdbcBookService();
    }

    /**
     * Devuelve la instancia de <code>Libro</code> que se identifica por la hilera especificada dentro de la base de
     * datos, o <code>null</code> si el identificador no corresponde a ninguna instancia de <code>Libro</code>.
     *
     * @param id    la hilera que identifica a un libro
     * @return      el libro que tiene el identificador especificado
     */
    public Libro findById(String id) {
        return libroDao.findById(id);
    }

    /**
     * Agrega la instancia de <code>Libro</code> a la base de datos y devuelve la hilera que identifica a la instancia.
     *
     * @param libro el libro que se agrega a la base de datos
     * @return      la hilera que identifica al libro
     */
    public String create(Libro libro) {
        return  libroDao.create(libro);
    }

    /**
     * Actualiza la instancia de <code>Libro</code> en la base de datos.
     *
     * @param libro el libro que se actualiza en la base de datos
     */
    public void update(Libro libro) {
        libroDao.update(libro);
    }

    /**
     * Elimina la instancia de <code>Libro</code> de la base de datos.
     *
     * @param libro el libro que se elimina de la base de datos
     */
    public void remove(Libro libro) {
        libroDao.remove(libro);
    }
}
