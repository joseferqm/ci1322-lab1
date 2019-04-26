package ucr.ac.ecci.ci1322.laboratorio1.build;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.service.BookService;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.service.BookServiceImpl;
import ucr.ac.ecci.ci1322.laboratorio1.core.student.service.StudentService;
import ucr.ac.ecci.ci1322.laboratorio1.core.student.service.StudentServiceImpl;
import ucr.ac.ecci.ci1322.laboratorio1.model.Estudiante;
import ucr.ac.ecci.ci1322.laboratorio1.model.Libro;

import java.io.FileInputStream;
import java.io.IOException;

public class DataLoader {
    private BookService libroService;
    private StudentService estudianteService;

    /**
     * Único constructor.
     */
    public DataLoader() {
        libroService = new BookServiceImpl();
        estudianteService = new StudentServiceImpl();
    }

    /**
     * Accede a los datos del workbook para cagarlos al mecanismo de persistencia a través de los servicios
     * correspondientes.
     */
    public void cargarDatos() throws IOException {
        FileInputStream archivoInput = null;

        try {
            archivoInput = new FileInputStream("/Users/joseferqm/workspace/ci1322-lab1/compiladores-laboratorio1/src/main/resources/DatosPrueba.xls");
            POIFSFileSystem fileSystem = new POIFSFileSystem(archivoInput);
            HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);

            // La hoja de cálculo de libros tiene índice 0
            HSSFSheet sheet = workbook.getSheetAt(0);
            cargarLibros(sheet);

            // La hoja de cálculo de estudiantes tiene índice 1
            sheet = workbook.getSheetAt(1);
            cargarEstudiantes(sheet);
        } finally {
            if (archivoInput != null) {
                archivoInput.close();
            }
        }
    }

    /**
     * Accede a los datos de la hoja de cálculo de libros para cagarlos al mecanismo de persistencia a través del
     * servicio para libros.
     *
     * @param hojaCalculo   la hoja de cálculo donde están los datos de los libros
     */
    private void cargarLibros(HSSFSheet hojaCalculo) {
        // La fila con índice 0 corresponde a los encabezados de columna.
        // Se debe empezar con el índice 1
        int indFila = 1;
        HSSFRow fila = hojaCalculo.getRow(indFila);

        while (fila != null) {
            String isbn = fila.getCell(0).getStringCellValue();
            String titulo = fila.getCell(1).getStringCellValue();
            int anno = (int) fila.getCell(3).getNumericCellValue();
            int edicion = (int) fila.getCell(4).getNumericCellValue();
            String editorial = fila.getCell(5).getStringCellValue();

            String hilAutores = fila.getCell(2).getStringCellValue();
            String[] autores = hilAutores.split(",");

            Libro libro = new Libro(isbn, titulo, autores, anno, edicion, editorial);
            libroService.create(libro);

            indFila++;
            fila = hojaCalculo.getRow(indFila);
        }
    }

    /**
     * Accede a los datos de la hoja de cálculo de estudiantes para cagarlos al mecanismo de persistencia a través del
     * servicio para estudiantes.
     *
     * @param hojaCalculo   la hoja de cálculo donde están los datos de los estudiantes
     */
    private void cargarEstudiantes(HSSFSheet hojaCalculo) {
        // La fila con índice 0 corresponde a los encabezados de columna.
        // Se debe empezar con el índice 1
        int indFila = 1;
        HSSFRow fila = hojaCalculo.getRow(indFila);

        while (fila != null) {
            String cedula = fila.getCell(0).getStringCellValue();
            String carne = fila.getCell(1).getStringCellValue();
            String nombre = fila.getCell(2).getStringCellValue();
            String apellido = fila.getCell(3).getStringCellValue();

            Estudiante estudiante = new Estudiante(cedula, carne, nombre, apellido);
            estudianteService.create(estudiante);

            indFila++;
            fila = hojaCalculo.getRow(indFila);
        }
    }
}
