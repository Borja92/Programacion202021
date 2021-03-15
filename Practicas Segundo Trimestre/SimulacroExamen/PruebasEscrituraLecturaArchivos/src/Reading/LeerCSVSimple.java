package Reading;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class LeerCSVSimple {
    private File file = new File("ejemploCSV.csv");
    private String rutaArchivo = file.getAbsolutePath();
    private final static String SEPARADOR = ",";
    //private final static char SEPARADOR=';';
private final static String COMILLAS = "\"";
    private BufferedReader lectorCSV = null;




    public void leerCSVSimpleConBufferedReader() {

        String dir = System.getProperty("user.dir");
        try {
            lectorCSV = new BufferedReader(new FileReader(dir + File.separator + "ejemploCSV.csv"));
            String linea = lectorCSV.readLine();
            while (null != linea) {

                String[] campos = linea.split(SEPARADOR);
                campos = eliminarComillasEnExtremos(campos);
                System.out.println(Arrays.toString(campos));
                linea = lectorCSV.readLine();
            }
            lectorCSV.close();

        } catch (IOException e) {
            System.out.println("=====");
            System.out.println("CSV not found");
            System.out.println("=====");
        }

    }

public void leerCSVSimpleConScanner(){

        String dir= System.getProperty("user.dir");
    Scanner lectorCSV;

    try {
        lectorCSV= new Scanner(new File(dir+File.separator+"ejemploCSV.csv")).useDelimiter(" ");

        while (lectorCSV.hasNext()){
            String[] campos = lectorCSV.next().split(",");
            campos=eliminarComillasEnExtremos(campos);
            System.out.print(Arrays.toString(campos));
        }
        lectorCSV.close();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }



}
    private static String[] eliminarComillasEnExtremos(String[] campos) {
        String[] resultado = new String[campos.length];
        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = campos[i].replaceAll("^" + COMILLAS, "").replaceAll(COMILLAS + "$", "");
        }
        return resultado;
    }

}
