package TurismoCulinario.Persistencia;

import TurismoCulinario.Modelo.Ciudad;
import TurismoCulinario.Modelo.Plato;

import javax.swing.text.Document;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CSVReader {
    private String file;
    private Document doc;

    public CSVReader(String file) {
        this.file = file;
    }

    public Map<String, Ciudad> read(){
        String dir = System.getProperty("user.dir");
        Scanner lectorCSV;

        Map<String, Ciudad> ciudades = new HashMap<>();


        try {
            lectorCSV= new Scanner(new File(dir+File.separator+file)).useDelimiter("\n");

            while (lectorCSV.hasNext()) {

                String[] campos = lectorCSV.next().split(";");
                String nombreCiudad = campos[2];
                Plato plato = new Plato(campos[0], campos[1]);
                if (!ciudades.containsKey(nombreCiudad))
            ciudades.put(nombreCiudad, new Ciudad(nombreCiudad));
                    ciudades.get(nombreCiudad).addPlato(plato);
            }

            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
return ciudades;
    }


}
