import Modelo.Libro;
import Persistencia.GestorXML;
import org.w3c.dom.Document;

import java.util.List;
import java.util.Map;

public class AppLibros {
    GestorXML gestorXML= new GestorXML("Libros.xml");

    public Libro getLibroByTitulo(String titulo){
    Libro libro = new Libro();
        for (Libro l:gestorXML.getLibrosConsusNodosHijos().keySet()) {
            if (titulo.equalsIgnoreCase(l.getTitulo())){
                return l;
            }
        }
        return null;
}


    public static void main(String[] args) {

        GestorXML gestorXML= new GestorXML("Libros.xml");
        AppLibros appLibros= new AppLibros();
        //System.out.println(gestorXML.getLibros());
        System.out.println(gestorXML.getLibrosConsusNodosHijos());
        System.out.println(appLibros.getLibroByTitulo("el sanador de caballos"));
    }
}
