package Persistencia;


import Modelo.Libro;
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
import java.security.cert.CRLReason;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorXML {
    /**
     * Variable del doc
     */
    private String fichero;
    private Document doc;
    private List<Libro> libros;
    private HashMap<Libro, List<String>> libroConSusNodosHijos;


    /**
     * Constructor
     */

    public GestorXML(String fichero) {
        try {
            this.libros = new ArrayList<Libro>();
            this.libroConSusNodosHijos = new HashMap<>();
            String dir = System.getProperty("user.dir");
            System.out.println(dir + File.separator + fichero);

            //Se crea un objeto DocumentBuilderFactory
            File inputFile = new File(dir + File.separator + fichero);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            //Se crea un objeto Builder para cargar la estructura del árbol DOM a partir del árbol seleccionado

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
//Interpreta y parsea el DOM equivalente

            doc.getDocumentElement().normalize();


            //Indica que el modelo DOM no debe contemplar los comentarios que tenga el XML
            dbFactory.setIgnoringComments(true);

            //Ignora los espacios en blanco que tenga el documento
            dbFactory.setIgnoringElementContentWhitespace(true);


// Ahora doc apunta al árbol DOM listo para ser recorrido
            NodeList nodeList = doc.getElementsByTagName("Libro");

            getLibros(nodeList);


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * El siguiente código recorre el árbol DOM para dar la salida anterior con los nombres de los elementos
     * que contiene cada <Libro> (<Titulo>, <Autor>), sus valores y el valor y nombre del atributo de <Libro>
     * (publicado_en)
     **/

    /*public void procesarYMostrarLibros(Document doc){
       // List<Libro>listaLibros= new ArrayList<>();

        String datos_nodo[]=null;
        String salida="";

        Node nodeLibro = null;
// Obtiene el primer nodo del DOM (primer hijo)


Node nodeRaiz = doc.getFirstChild();

//Obtiene una lista de nodos con todos los nodos hijo del nodo raíz

        NodeList nodeList= nodeRaiz.getChildNodes();


        //Procesa los nodos hijos
        for (int i = 0; i <nodeList.getLength() ; i++) {
            //Es un libro
            if (nodeLibro.getNodeType()==Node.ELEMENT_NODE){

                datos_nodo=getLibros(nodeLibro);
                System.out.println("LLego aquí?");
                libros.add(new Libro(datos_nodo[0],datos_nodo[2],datos_nodo[1]));
            }
        }
return libros;
    }*/
    private void getLibros(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Libro libro = nuevoLibro(node);
                libros.add(libro);
                if (node.hasChildNodes()) {
                    libroConSusNodosHijos.put(libro, parseStringToList(node));
                    // getLibros().add(libro);
                }
            }
        }

    }

    //Método que devuelve el valor String del nodo Titulo
    /*private String getNodoHijoTitulo(Node nodeLibro) {
        //List<String>titulos= new ArrayList<>();

        // List<String>listaTitulos= new ArrayList<>();
        String título = "";
        NodeList titulosLibro = nodeLibro.getChildNodes();
        for (int i = 0; i < titulosLibro.getLength(); i++) {
            Node nodeTitulo = titulosLibro.item(1);
            if (nodeTitulo.getNodeType() == Node.ELEMENT_NODE) {

                Element elementoTitulo = (Element) nodeTitulo;
                elementoTitulo.getElementsByTagName("Titulo");
                //listaTitulos.add(elementoTitulo.getAttribute("titulo"));
                título = elementoTitulo.getTextContent();
//titulos.add(título);
            }
        }

        return título;
    }*/

    private String getNodoHijoTitulo(Node nodeLibro) {

        String titulo = "";
        if (nodeLibro.getNodeType() == Node.ELEMENT_NODE) {

            Element elementoTitulo = (Element) nodeLibro;
            titulo = elementoTitulo.getElementsByTagName("Titulo").item(0).getTextContent();
        }

        return titulo;
    }

//Método que devuelve el valor String del nodo Autor

    private String getNodoHijoAutor(Node nodeLibro) {

        String autor = "";
        /*NodeList autorLibro = nodeLibro.getChildNodes();
        for (int i = 0; i < autorLibro.getLength(); i++) {
            Node nodeAutor = autorLibro.item(3);
            if (nodeAutor.getNodeType() == Node.ELEMENT_NODE) {

                Element elementoTitulo = (Element) nodeAutor;
                elementoTitulo.getElementsByTagName("Autor");
                //listaTitulos.add(elementoTitulo.getAttribute("titulo"));
                autor = elementoTitulo.getTextContent();
            }
        }*/
        if (nodeLibro.getNodeType()==Node.ELEMENT_NODE){

            Element elementoAutor= (Element) nodeLibro;
            autor=elementoAutor.getElementsByTagName("Autor").item(0).getTextContent();
        }


        return autor;
    }


    public List<Libro> getLibros() {
        return libros;
    }

    public Map<Libro, List<String>> getLibrosConsusNodosHijos() {

        return libroConSusNodosHijos;
    }

    private List<String> parseStringToList(Node node) {
        List<String> tituloYAutor = new ArrayList<>();
        tituloYAutor.add(getNodoHijoTitulo(node));
        tituloYAutor.add(getNodoHijoAutor(node));

        return tituloYAutor;
    }


    private Libro nuevoLibro(Node nodeLibro) {
        Element elementoLibro = (Element) nodeLibro;

        elementoLibro.getElementsByTagName("Libro");
        return new Libro(elementoLibro.getAttribute("publicado_en"), getNodoHijoTitulo(nodeLibro), getNodoHijoAutor(nodeLibro));
    }

}

