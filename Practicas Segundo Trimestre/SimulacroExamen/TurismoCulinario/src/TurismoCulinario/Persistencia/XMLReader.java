package TurismoCulinario.Persistencia;

import TurismoCulinario.Modelo.Ciudad;
import TurismoCulinario.Modelo.Coordenadas;
import TurismoCulinario.Modelo.Establecimiento;
import TurismoCulinario.Modelo.Plato;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class XMLReader {
    private Document doc;
    private Map<String,Ciudad> ciudades;
    private String file;
    private List<Establecimiento> establecimientos;
    public XMLReader(String file){

        this.file = file;

        String dir = System.getProperty("user.dir");

        try {
            File inputFile = new File(dir + File.separator + file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void setCiudades(Map<String,Ciudad> ciudades){
        this.ciudades = ciudades;
    }

    public Map<String,Ciudad> read() throws XPathExpressionException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        String xpathExpr = "/establecimientos/establecimiento";
        NodeList nodeList = (NodeList) xPath.compile(xpathExpr).evaluate(doc, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element elementoEstablecimiento = (Element) nodeList.item(i);
                Establecimiento establecimiento = addEstablecimientoACiudad(elementoEstablecimiento);
                NodeList platosEstablecimiento = elementoEstablecimiento.getElementsByTagName("plato");
                List<Plato> platos = getPlatosFromNodeList(platosEstablecimiento);
                for (Plato plato: platos)
                    establecimiento.addPlato(plato);
            }
        }
        return ciudades;
    }

    private List<Plato> getPlatosFromNodeList(NodeList platosEstablecimiento) {
        List<Plato> platos = new ArrayList<>();
        for (int i=0; i<platosEstablecimiento.getLength(); i++){
            Element nodoPlato = (Element) platosEstablecimiento.item(i);
            String nombrePlato = nodoPlato.getAttribute("nombre");
            Plato plato = getPlatoFromCiudades(nombrePlato);
            platos.add(plato);
        }
        return platos;
    }

    private Plato getPlatoFromCiudades(String nombrePlato) {
        for (Ciudad ciudad: ciudades.values()) {
            if (ciudad.tienePlato(nombrePlato))
                return ciudad.getPlatoPorNombre(nombrePlato);
        }
        return null;

    }

    private Establecimiento addEstablecimientoACiudad(Element elementoEstablecimiento) {
        String nombreEstablecimiento = elementoEstablecimiento.getAttribute("nombre");
        double latitud = Double.parseDouble(elementoEstablecimiento.getAttribute("latitud"));
        double longitud = Double.parseDouble(elementoEstablecimiento.getAttribute("longitud"));
        Coordenadas coordenadas = new Coordenadas(latitud,longitud);
        String nombreCiudad = elementoEstablecimiento.getAttribute("ciudad");
        Establecimiento establecimiento = new Establecimiento(nombreEstablecimiento,coordenadas);
        ciudades.get(nombreCiudad).addEstablecimiento(establecimiento);
        return establecimiento;
    }
}