package Reading;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFicheroTXT {
private File file= new File("ejemplo.txt");
private String rutaArchivo=file.getAbsolutePath();

public void Lee(){

    try {
        FileReader entrada = new FileReader(rutaArchivo);

        int c=0;
        while (c!=-1){
            c=entrada.read();
            char caracteres=(char) c; //casteo c a char para imprimir caracteres y no su valor int
            System.out.print(caracteres);
        }
        entrada.close();//importante cerrar el flujo de datos para no consumir recursos

    } catch (FileNotFoundException e) {
        //e.printStackTrace();
        System.out.println("No se ha encontrado el archivo!!");
    } catch (IOException e) {
        e.printStackTrace();
    }
}


}
