package ucr.ac.ecci.ci1322.laboratorio1;

import ucr.ac.ecci.ci1322.laboratorio1.core.student.service.StudentService;
import ucr.ac.ecci.ci1322.laboratorio1.core.student.service.StudentServiceImpl;
import ucr.ac.ecci.ci1322.laboratorio1.model.Estudiante;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsultaEstudiante {
    public static void main(String[] args) throws IOException {
        BufferedReader console = null;

        try {
            console = new BufferedReader(new InputStreamReader(System.in));
            String linea;
            System.out.print("Ingrese la cedula del estudiante por consultar: ");
            if ( (linea = console.readLine()) != null ) {
                StudentService estudianteService = new StudentServiceImpl();
                Estudiante estudiante = estudianteService.findById(linea);
                if (estudiante != null) {
                    System.out.println(estudiante.toString());
                } else {
                    System.out.println("No se encontró ningún estudiante con la cédula especificada.");
                }
            }
        } finally {
            if (console != null) {
                console.close();
            }
        }
    }
}
