package ucr.ac.ecci.ci1322.laboratorio1.build;

import java.io.IOException;

public class DataLoaderMain {
    public static void main(String[] args) {
        DataLoader dl = new DataLoader();
        try {
            dl.cargarDatos();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
