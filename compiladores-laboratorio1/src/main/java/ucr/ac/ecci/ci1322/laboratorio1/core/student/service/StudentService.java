package ucr.ac.ecci.ci1322.laboratorio1.core.student.service;

import ucr.ac.ecci.ci1322.laboratorio1.model.Estudiante;

public interface StudentService {

    /**
     * Devuelve la instancia de <code>Estudiante</code> que se identifica por la hilera especificada dentro del
     * mecanismo de persistencia, o <code>null</code> si el identificador no corresponde a ninguna instancia de
     * <code>Estudiante</code>.
     *
     * @param id    la hilera que identifica a un estudiante
     * @return      el estudiante que tiene el identificador especificado
     */
    Estudiante findById(String id);

    /**
     * Agrega la instancia de <code>Estudiante</code> al mecanismo de persistencia y devuelve la hilera que identifica
     * a la instancia.
     *
     * @param estudiante    el estudiante que se agrega al mecanismo de persistencia
     * @return              la hilera que identifica al estudiante
     */
    String create(Estudiante estudiante);

    /**
     * Actualiza la instancia de <code>Estudiante</code> en el mecanismo de persistencia.
     *
     * @param estudiante    el estudiante que se actualiza en el mecanismo de persistencia
     */
    void update(Estudiante estudiante);

    /**
     * Elimina la instancia de <code>Estudiante</code> del mecanismo de persistencia.
     *
     * @param estudiante    el estudiante que se elimina del mecanismo de persistencia
     */
    void remove(Estudiante estudiante);
}
