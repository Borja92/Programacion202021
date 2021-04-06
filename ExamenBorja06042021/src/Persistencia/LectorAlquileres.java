package Persistencia;

import Modelo.Alquiler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LectorAlquileres {
    /**
     * Variable del doc
     */
    private String fichero;
    private Document doc;
    private List<Alquiler> listaAlquileres;

    /**
     * Constructor
     */

   public LectorAlquileres(String fichero){


       this.listaAlquileres= new ArrayList<>();

       String dir = System.getProperty("user.dir");
       System.out.println(dir + File.separator + fichero);
       try {
           File inputFile = new File(dir + File.separator + fichero);
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           doc = dBuilder.parse(inputFile);

           doc.getDocumentElement().normalize();

           NodeList nodeList = doc.getElementsByTagName("alquiler");

           getAlquileres(nodeList);

   } catch (Exception e){
       e.printStackTrace();
       }
   }

    private void getAlquileres(NodeList alquileres) {

        for (int i = 0; i < alquileres.getLength(); i++) {
            Node node = alquileres.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Alquiler alquiler = nuevoAlquiler(node);
                listaAlquileres.add(alquiler);
                if (node.hasChildNodes()) {
                   // libroConSusNodosHijos.put(libro, parseStringToList(node));
                    // getLibros().add(libro);
                }
            }
        }


    }
//Devuelve el valor del nodo codigo_coche
   private String getNodoHijoCodigo_Cohe(Node nodeAlquiler){
       String cod_coche="";

       if (nodeAlquiler.getNodeType()==Node.ELEMENT_NODE){

           Element elementoCodigoCoche= (Element) nodeAlquiler;
           cod_coche=elementoCodigoCoche.getElementsByTagName("codigo_coche").item(0).getTextContent();
       }

       return cod_coche;
   }
//Devuelve el valor del nodo fecha_alquiler
   private String getNodoHijoFecha_Alquiler(Node nodeAlquiler){

       String fecha="";
       if (nodeAlquiler.getNodeType()==Node.ELEMENT_NODE){
           Element elemntoFecha= (Element) nodeAlquiler;

           fecha=elemntoFecha.getElementsByTagName("fecha_alquiler").item(0).getTextContent();
       }
       return fecha;}

       //Devuelve el valor del nodo días_alquiler
       private String getNodoHijoDias_Alquiler(Node nodeAlquiler){
       String dias="";
       if (nodeAlquiler.getNodeType()==Node.ELEMENT_NODE){
           Element elemenDias= (Element) nodeAlquiler;

           dias=elemenDias.getElementsByTagName("dias_alquiler").item(0).getTextContent();
       }
       return dias;
}


//Cea un nuevo alquiler y lo devuelve
private Alquiler nuevoAlquiler(Node nodeAlquiler){

       Element elementoAlquiler= (Element) nodeAlquiler;

       elementoAlquiler.getElementsByTagName("alquiler");
       return new Alquiler(Integer.parseInt(getNodoHijoCodigo_Cohe(nodeAlquiler)),getNodoHijoFecha_Alquiler(nodeAlquiler),Integer.parseInt(getNodoHijoDias_Alquiler(nodeAlquiler)));

}
public List<Alquiler>getListaAlquileres(){
       return listaAlquileres;
}

}



