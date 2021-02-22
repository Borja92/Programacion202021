import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GestionCsv extends Exception {
    private final static char SEPARADOR = ';';
    private final static char COMILLAS = '"';

    String dir = System.getProperty("user.dir");
    Scanner lectorCSV;


    private String[] eliminarComillasEnExtremos(String[] campos) {

        String result[] = new String[campos.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = campos[i].replaceAll("^" + COMILLAS,
                    "").replaceAll(COMILLAS + "$", "");
        }
        return result;
    }

        try{
            lectorCSV = new Scanner(new File(dir + File.separator + "jugadores.csv")).useDelimiter("");
        while(lectorCSV.hasNextInt()){
            String[] campos = lectorCSV.next().split(";");
            campos = eliminarComillasEnExtremos(campos);
    }
        } catch(FileNotFoundException ex){
        ex.printStackTrace();
    }
    }


}
