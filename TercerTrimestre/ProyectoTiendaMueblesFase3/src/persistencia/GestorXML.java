package persistencia;

import modelo.Elemento;
import modelo.Modelo;
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
import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * Clase GestorXML
 */
public class GestorXML {

    /**
     * Objetos de la clase
     */

    private DBConn dbConn;
    private String fichero;
    private Document doc;
    private Connection conn;


    /**
     * Cosntructor
     *
     * @param fichero
     */
    public GestorXML(String fichero) {
        try {
            dbConn = new DBConn();
            String dir = System.getProperty("user.dir");
            //System.out.println(dir+File.separator+fichero);

            File inputFile = new File(dir + File.separator + fichero);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();


            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            doc = dbBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
//Indica que el modelo DOM no debe contemplar los comentarios que tenga el XML
            dbFactory.setIgnoringComments(true);

            //Ignora los espacios en blanco que tenga el documento
            dbFactory.setIgnoringElementContentWhitespace(true);
            // Ahora doc apunta al árbol DOM listo para ser recorrido
            NodeList nodeListRaiz = doc.getElementsByTagName("modelo");

            fillModelo(nodeListRaiz);

            NodeList nodeListELementos = doc.getElementsByTagName("elem");

            fillElemento(nodeListELementos);
            // getModelos(nodeList);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }

    /**
     * fillModelo
     * @param nodeList
     */
    private void fillModelo(NodeList nodeList) {
        cargarCategoria(nodeList);
        cargarSeccion(nodeList);
        cargarModelo(nodeList);
    }

    /**
     * fillElemento
     * @param nodeList
     */
    private void fillElemento(NodeList nodeList) {
        cargarElementos(nodeList);
    }


    /**
     * getSeccion
     * @param nodoModelo
     * @return string
     */
    private String getSeccion(Node nodoModelo) {
        String seccion = "";
        if (nodoModelo.getNodeType() == Node.ELEMENT_NODE) {

            Element elementSeccion = (Element) nodoModelo;
            seccion = elementSeccion.getElementsByTagName("seccion").item(0).getTextContent();
        }
        return seccion;

    }

    /**
     * getCategoria
     * @param nodoModelo
     * @return string
     */
    private String getCategoria(Node nodoModelo) {

        String categoria = "";

        if (nodoModelo.getNodeType() == Node.ELEMENT_NODE) {
            Element elementCategoria = (Element) nodoModelo;
            categoria = elementCategoria.getElementsByTagName("categoria").item(0).getTextContent();
        }
        return categoria;

    }

    /**
     * getModelo
     * @param nodeModelo
     * @return modelo.Modelo
     */
    private modelo.Modelo getModelo(Node nodeModelo) {

        Element elementoModelo = (Element) nodeModelo;

        elementoModelo.getElementsByTagName("modelo");
        return new modelo.Modelo(elementoModelo.getAttribute("codigo"), getSeccion(nodeModelo), getCategoria(nodeModelo));
    }

    /**
     * cargarModelo
     * @param nodeList
     * @return boolean
     */
    private boolean cargarModelo(NodeList nodeList) {
        boolean accion = false;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                ModeloDAO modeloDAO = new ModeloDAO(dbConn.conectar());
                if (modeloDAO.crear(getModelo(node))) {
                    accion = true;
                }
            }
        }
        return accion;

    }

    /**
     * cargarCategoria
     * @param nodeList
     * @return boolean
     */
    private boolean cargarCategoria(NodeList nodeList) {
        boolean accion = false;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                CategoriaDAO categoriaDAO = new CategoriaDAO(dbConn.conectar());
                if (categoriaDAO.crear(getCategoria(node))) {
                    accion = true;
                }
            }
        }
        return accion;
    }

    /**
     * cargarSeccion
     * @param nodeList
     * @return boolean
     */
    private boolean cargarSeccion(NodeList nodeList) {

        boolean accion = false;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                SeccionDAO seccionDAO = new SeccionDAO(dbConn.conectar());
                if (seccionDAO.crear(getSeccion(node))) {
                    accion = true;
                }
            }
        }
        return accion;
    }

    /**
     * getTipoElemento
     * @param nodoElemento
     * @return string
     */
    private String getTipoElemento(Node nodoElemento) {

        String tipoElemento = "";

        if (nodoElemento.getNodeType() == Node.ELEMENT_NODE) {
            Element elementTipo = (Element) nodoElemento;
            tipoElemento = elementTipo.getAttribute("tipo");
        }
        return tipoElemento;

    }

    /**
     * getCodigoELemento
     * @param nodeElemento
     * @return string
     */
    private String getCodigoElemento(Node nodeElemento) {

        String codigoElemento = "";
        if (nodeElemento.getNodeType() == Node.ELEMENT_NODE) {

            Element elementCodigoElemento = (Element) nodeElemento;
            codigoElemento = elementCodigoElemento.getElementsByTagName("codigo").item(0).getTextContent();

        }
        return codigoElemento;
    }

    /**
     * cargarElementos
     * @param nodeList
     */
    private void cargarElementos(NodeList nodeList) {
        TipoElementoDAO tipoElementoDAO = new TipoElementoDAO(dbConn.conectar());
        ElementoDAO elementoDAO = new ElementoDAO(dbConn.conectar());
        for (int i = 0; i < nodeList.getLength(); i++) {

            Node nodoModelo = nodeList.item(i);
            if (nodoModelo.getNodeType() == Node.ELEMENT_NODE) {

                String tipo = getTipoElemento(nodoModelo);
                tipoElementoDAO.crear(tipo);
                if (nodoModelo.hasChildNodes()) {
                    modelo.Elemento elemento = new Elemento(tipo, getCodigoElemento(nodoModelo));
                    elementoDAO.crear(elemento);
                }
            }

        }
    }


}