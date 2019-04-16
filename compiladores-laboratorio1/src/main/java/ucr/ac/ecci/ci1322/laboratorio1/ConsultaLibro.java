package ucr.ac.ecci.ci1322.laboratorio1;

import ucr.ac.ecci.ci1322.laboratorio1.core.book.service.BookService;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.service.BookServiceImpl;
import ucr.ac.ecci.ci1322.laboratorio1.model.Libro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsultaLibro {
    public static void main(String[] args) throws IOException {
        BufferedReader console = null;

        try {
            console = new BufferedReader(new InputStreamReader(System.in));
            String linea;
            System.out.print("Ingrese el id del libro por consultar: ");
            if ( (linea = console.readLine()) != null ) {
                BookService libroService = new BookServiceImpl();
                Libro libro = libroService.findById(linea);
                if (libro != null) {
                    System.out.println("Datos del libro:");
                    System.out.println( String.format("\tISBN: %s", libro.getIsbn()) );
                    System.out.println( String.format("\tTítulo: %s", libro.getTitulo()) );
                    System.out.println("\tAutores:");
                    String[] autores = libro.getAutores();
                    for (String autor : autores) {
                        System.out.println( String.format("\t\t\t%s", autor) );
                    }
                    System.out.println( String.format("\tAño: %d", libro.getAnno()) );
                    System.out.println( String.format("\tEdición: %d", libro.getEdicion()) );
                    System.out.println( String.format("\tEditorial: %s", libro.getEditorial()) );
                } else {
                    System.out.println("No se encontró ningún libro con el id especificado.");
                }
            }
        } finally {
            if (console != null) {
                console.close();
            }
        }
    }
}
