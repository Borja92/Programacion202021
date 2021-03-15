package Writing;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirFicheroTXT {


    public void escribir(){
    String frase = "Esto es una cadena de prueba.";

        try {
            FileWriter escribirTXT= new FileWriter("ficheroTXTCreadoPOrCodigo.txt");
            for (int i = 0; i < frase.length(); i++) {
                escribirTXT.write(frase.charAt(i));
            }
            escribirTXT.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("El archivo no se puede crear. Ocurrió un error");
        }
    }
}
