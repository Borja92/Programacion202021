import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class EscrituraXML {

    public static void main(String[] args) {

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
// definimos el elemento raíz del documento
            Element eRaiz = doc.createElement("concesionario");
            doc.appendChild(eRaiz);
// definimos el nodo que contendrá los elementos
            Element eCoche = doc.createElement("coche");
            eRaiz.appendChild(eCoche);
// atributo para el nodo coche
            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            eCoche.setAttributeNode(attr);
// definimos cada uno de los elementos y le asignamos un valor
            Element eMarca = doc.createElement("marca");
            eMarca.appendChild(doc.createTextNode("Renault"));
            eCoche.appendChild(eMarca);
            Element eModelo = doc.createElement("modelo");
            eModelo.appendChild(doc.createTextNode("Megano"));
            eCoche.appendChild(eModelo);
            Element eCilindrada = doc.createElement("cilindrada");
            eCilindrada.appendChild(doc.createTextNode("1.5"));
            eCoche.appendChild(eCilindrada);

// clases necesarias finalizar la creación del archivo XML
            TransformerFactory transformerFactory =
                    TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new
                    File("ejercicio3.xml"));
            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
