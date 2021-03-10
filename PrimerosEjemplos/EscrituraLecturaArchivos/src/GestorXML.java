import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class GestorXML {

    public static void main(String[] args) throws ParserConfigurationException {


        String dir = System.getProperty("user.dir");

        System.out.println(dir);

        try {
            File inputFile = new File(dir + File.separator + "company.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
/*
DocumentBuilder.parse(file) puede generar:
IOException - Error de lectura del archivo
SAXException - Error de parseo
IllegalArgumentException - Cuando el archivo "file" es null
*/
            doc.getDocumentElement().normalize();
/*
Elimina nodos vacíos y combina adyacentes en caso de que los
hubiera
*/
        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (
                SAXException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}