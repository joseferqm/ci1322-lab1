package ucr.ac.ecci.ci1322.laboratorio1.core.student.service;

import ucr.ac.ecci.ci1322.laboratorio1.core.student.dao.JdbcStudentService;
import ucr.ac.ecci.ci1322.laboratorio1.core.student.dao.StudentDao;
import ucr.ac.ecci.ci1322.laboratorio1.model.Estudiante;

public class StudentServiceImpl implements StudentService {

    private StudentDao estudianteDao;

    /**
     * Único constructor.
     */
    public StudentServiceImpl() {
        estudianteDao = new JdbcStudentService();
    }

    /**
     * Devuelve la instancia de <code>Estudiante</code> que se identifica por la hilera especificada dentro de la base
     * de datos, o <code>null</code> si el identificador no corresponde a ninguna instancia de <code>Estudiante</code>.
     *
     * @param id    la hilera que identifica a un estudiante
     * @return      el estudiante que tiene el identificador especificado
     */
    public Estudiante findById(String id) {
        return estudianteDao.findById(id);
    }

    /**
     * Agrega la instancia de <code>Estudiante</code> a la base de datos y devuelve la hilera que identifica a la
     * instancia.
     *
     * @param estudiante    el estudiante que se agrega a la base de datos
     * @return              la hilera que identifica al estudiante
     */
    public String create(Estudiante estudiante) {
        return estudianteDao.create(estudiante);
    }

    /**
     * Actualiza la instancia de <code>Estudiante</code> en la base de datos.
     *
     * @param estudiante    el estudiante que se actualiza en la base de datos
     */
    public void update(Estudiante estudiante) {
        estudianteDao.update(estudiante);
    }

    /**
     * Elimina la instancia de <code>Estudiante</code> de la base de datos.
     *
     * @param estudiante    el estudiante que se elimina de la base de datos
     */
    public void remove(Estudiante estudiante) {
        estudianteDao.remove(estudiante);
    }
}
