package Writing;

import Reading.LeerXML;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EscribirObjetosEnXML {


    /**
     * Se instancia el objeto de coche
     */

    Coche coche = new Coche();

    /**
     * Se crea una lista ESTÁTICA y su correspondiente getter
     */

    static List<Coche> listaCoches = new LinkedList<>();

    public List<Coche> getListaCoches() {
        return listaCoches;
    }


    /**
     * Método para agregar el objeto por teclado
     */

    private void addCoches() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Id");
        String id=teclado.next();
        System.out.print("Marca: ");
        String marca = teclado.next();
        System.out.print("Modelo: ");
        String modelo = teclado.next();
        System.out.print("Cilindrada: ");
        String cilindrada = teclado.next();

        coche = new Coche(id,marca, modelo, cilindrada);
        listaCoches.add(coche);

    }

    /**
     * Método para agregar el objeto sin sobreescribir
     */
    public void agregarSinSobreescribir(String nombreArchivo) {
      addCoches();
        int indiceObjeto=listaCoches.size()-1;
        try {

           DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
           DocumentBuilder documentBuilder= dbFactory.newDocumentBuilder();

Document doc= documentBuilder.parse(new File(nombreArchivo));

NodeList nodoRaiz= (NodeList) doc.getElementsByTagName("concesionario");

Element elementoCoche= doc.createElement("coche");
           /* NamedNodeMap attr= elementoCoche.getAttributes();
            Node nodeAttr= attr.getNamedItem("id"+indiceObjeto);*/
            elementoCoche.setAttribute("id", listaCoches.get(indiceObjeto).getId());
           nodoRaiz.item(indiceObjeto).appendChild(elementoCoche);

            Element elementoMarca= doc.createElement("marca");
           elementoMarca.appendChild(doc.createTextNode(listaCoches.get(indiceObjeto).getMarca()));
           //elementoMarca.appendChild(doc.createTextNode("Honda"));
elementoCoche.appendChild(elementoMarca);
            Element elementoModelo=doc.createElement("modelo");
            elementoModelo.appendChild(doc.createTextNode(listaCoches.get(indiceObjeto).getModelo()));
           // elementoModelo.appendChild(doc.createTextNode("z32"));
elementoCoche.appendChild(elementoModelo);
            Element elementoCilindrada= doc.createElement("cilindrada");
            elementoCilindrada.appendChild(doc.createTextNode(listaCoches.get(indiceObjeto).getCilindrada()));
           // elementoCilindrada.appendChild(doc.createTextNode("4.4"));
elementoCoche.appendChild(elementoCilindrada);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            Result output= new StreamResult(nombreArchivo);
            Source input= new DOMSource(doc);
            transformer.transform(input,output);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }


    /**
     * Método para agregar el objeto sin sobreescribir
     *//*
    public void agregarSinSobreescribir(String nombreArchivo, int indiceObjetoModificar) {
        LeerXML leerXML = new LeerXML(nombreArchivo);

        String id = String.valueOf(indiceObjetoModificar);
        String marcaPorTeclado = listaCoches.get(indiceObjetoModificar).getMarca();
        String modeloPorTeclado = listaCoches.get(indiceObjetoModificar).getModelo();
        String cilindradaPorTeclado = listaCoches.get(indiceObjetoModificar).getCilindrada();
        String archivo = nombreArchivo;

        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivo);
            Node concesionario=doc.getFirstChild();
            Node coche= (Node) doc.getElementsByTagName("coche");
            NamedNodeMap attr= coche.getAttributes();
            Node nodeAttr= attr.getNamedItem("id");
            System.out.println("coche"+nodeAttr.getTextContent());

            Element coche=doc.createElement("coche");
            coche.setAttributeNode("id="+id);
            Element marca=doc.createElement("marca");
            marca.setAttributeNode(marcaPorTeclado);


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/


    /**
     * Método para sobreescribir XML
     */
/*public void escribirObjetosEnXML(String nombreArchivo){
try {

        *//**
     * Inicializamos el archivo
     *//*

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        *//**
     * Se define el elemento raíz del documento
     *//*

        Element elementoRaiz = doc.createElement("concesionario");
        doc.appendChild(elementoRaiz);

        *//**
     * Se definen los nodos que contendrán los elementos
     *//*

        Element elementoCoche = doc.createElement("coche");
        elementoRaiz.appendChild(elementoCoche);

        Element elementoCoche2 = doc.createElement("coche");
        elementoRaiz.appendChild(elementoCoche2);

        *//**
     * Se define un atributo para el nodo coche
     *//*

        Attr atributoCoche = doc.createAttribute("id");
        atributoCoche.setValue("1");
        elementoCoche.setAttributeNode(atributoCoche);

        Attr atributoCoche2 = doc.createAttribute("id");
        atributoCoche2.setValue("2");
        elementoCoche2.setAttributeNode(atributoCoche2);

        *//**
     * Se define cada uno de los elementos y se le asigna un valor
     *//*

        Element elementoMarca = doc.createElement("marca");
        elementoMarca.appendChild(doc.createTextNode(getListaCoches().get(0).getMarca()));
        elementoCoche.appendChild(elementoMarca);

        Element elementoModelo = doc.createElement("modelo");
        elementoModelo.appendChild(doc.createTextNode(getListaCoches().get(0).getModelo()));
        elementoCoche.appendChild(elementoModelo);

        Element elementoCilindrada = doc.createElement("cilindrada");
        elementoCilindrada.appendChild(doc.createTextNode(getListaCoches().get(0).getCilindrada()));
        elementoCoche.appendChild(elementoCilindrada);

        Element elementoMarca2 = doc.createElement("marca");
        elementoMarca2.appendChild(doc.createTextNode("Ferrari"));
        elementoCoche2.appendChild(elementoMarca2);

        Element elementoModelo2 = doc.createElement("modelo");
        elementoModelo2.appendChild(doc.createTextNode("458"));
        elementoCoche2.appendChild(elementoModelo2);

        Element elementoCilindrada2 = doc.createElement("cilindrada");
        elementoCilindrada2.appendChild(doc.createTextNode("4.5"));
        elementoCoche2.appendChild(elementoCilindrada2);

        *//**
     * Se crea el archivo
     *//*

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(nombreArchivo));

        transformer.transform(source, result);

    } catch (TransformerConfigurationException e) {
        e.printStackTrace();
    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    } catch (TransformerException e) {
    e.printStackTrace();
}
}*/


}
