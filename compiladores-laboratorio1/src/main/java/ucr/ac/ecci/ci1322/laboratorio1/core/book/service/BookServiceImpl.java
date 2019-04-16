package ucr.ac.ecci.ci1322.laboratorio1.core.book.service;

import ucr.ac.ecci.ci1322.laboratorio1.core.book.dao.BookDao;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.dao.JdbcBookService;
import ucr.ac.ecci.ci1322.laboratorio1.model.Libro;

public class BookServiceImpl implements BookService {

    /**
     * TODO: comentar
     */
    private BookDao libroDao;

    /**
     * TODO: comentar
     */
    public BookServiceImpl() {
        libroDao = new JdbcBookService();
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
        return libroDao.findById(id);
    }

    /**
     * Agrega la instancia de <code>Libro</code> al mecanismo
     * de persistencia y devuelve la hilera que identifica a la instancia.
     *
     * @param libro el libro que se agrega al mecanismo de persistencia
     * @return      la hilera que identifica al libro
     */
    public String create(Libro libro) {
        return  libroDao.create(libro);
    }

    /**
     * Actualiza la instancia de <code>Libro</code> en el mecanismo
     * de persistencia.
     *
     * @param libro
     */
    public void update(Libro libro) {
        libroDao.update(libro);
    }

    /**
     * Elimina la instancia de <code>Libro</code> del mecanismo
     * de persistencia.
     *
     * @param libro
     */
    public void remove(Libro libro) {
        libroDao.remove(libro);
    }
}
