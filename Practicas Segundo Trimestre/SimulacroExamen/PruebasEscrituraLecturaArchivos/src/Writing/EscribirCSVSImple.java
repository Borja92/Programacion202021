package Writing;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class EscribirCSVSImple {
    


public void pasarACSV(List<String[]> texto){

    try {
        FileWriter escribirCSV= new FileWriter("archivoCSVCreadoPorCodigo.csv");
       escribirCSV.flush();
        for (int i = 0; i < texto.size(); i++) {
        escribirCSV.write(Arrays.toString(texto.get(i))+"\n");
        }

        escribirCSV.close();
    } catch (IOException e) {
        //e.printStackTrace();
        System.out.println("El archivo no se puede crear. Ocurrió un error");
    }
}



private String escaparCaracteresEspeciales(String texto){

    String escaparTexto= texto.replaceAll("\\R", " ");
    if (texto.contains(",") || texto.contains("\"") || texto.contains("'")){

        texto=texto.replace("\"", "\"\"");
        escaparTexto="\""+texto+"\"";
    }
    return escaparTexto;
}



}
