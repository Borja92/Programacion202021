package Reading;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LeerXML {
    /**
     * Variable del doc
     */
    private Document doc;
    /**
     * Constructor para CARGAR el archivo
     */

    public  LeerXML(String nombreArchivo){

        String dir= System.getProperty("user.dir");

        try {

            File archivoEntrada= new File(dir+File.separator+nombreArchivo);
            DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder =  dbFactory.newDocumentBuilder();
            doc=documentBuilder.parse(archivoEntrada);
       doc.getDocumentElement().normalize();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * Método para LEER el archivo
     */

    public void read(){

        NodeList nl=doc.getDocumentElement().getChildNodes();
        for (int i = 0; i <nl.getLength() ; i++) {

            if (nl.item(i).getNodeType()== Node.ELEMENT_NODE){
                Element elm= (Element) nl.item(i);
                if (elm.getNodeName().contains("staff")){ //Atención a esta línea puesto que el elemento coche variará en funcion del xml sobre el que trabajamos
                    String name=elm.getElementsByTagName("name").item(0).getTextContent();
                    String phone=elm.getElementsByTagName("phone").item(0).getTextContent();
                    String email=elm.getElementsByTagName("email").item(0).getTextContent();
                    String area=elm.getElementsByTagName("area").item(0).getTextContent();
                    String city=elm.getElementsByTagName("city").item(0).getTextContent();
                    System.out.println(name+", "+phone+", "+email+", "+area+", "+city);

                }

            }
        }

    }

    public void readCoches(){

        NodeList nl=doc.getDocumentElement().getChildNodes();
        for (int i = 0; i <nl.getLength() ; i++) {

            if (nl.item(i).getNodeType()== Node.ELEMENT_NODE){
                Element elm= (Element) nl.item(i);
                if (elm.getNodeName().contains("coche")){ //Atención a esta línea puesto que el elemento coche variará en funcion del xml sobre el que trabajamos
                    String marca=elm.getElementsByTagName("marca").item(0).getTextContent();
                    String modelo=elm.getElementsByTagName("modelo").item(0).getTextContent();
                    String cilindrada=elm.getElementsByTagName("cilindrada").item(0).getTextContent();
                    System.out.println(marca+", "+modelo+", "+cilindrada);
                }

            }
        }




    }

}
