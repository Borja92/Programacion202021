import Reading.LeerCSVSimple;
import Reading.LeerFicheroTXT;
import Reading.LeerXML;
import Writing.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AppControlador {


    public static void main(String[] args) {
        LeerFicheroTXT accediendoTXT = new LeerFicheroTXT();


        accediendoTXT.Lee();

        EscribirFicheroTXT escribirFicheroTXT = new EscribirFicheroTXT();
        escribirFicheroTXT.escribir();

        EscribirCSVSImple escribirCSVSImple = new EscribirCSVSImple();

        System.out.println();
        System.out.println("Lectura y escritura CSV");
        System.out.println("==============================");
        //Lectura de CSV Simple con BufferedReader
        System.out.println("Lectura de CSV Simple con BufferedReader");
        LeerCSVSimple leerCSVSimple = new LeerCSVSimple();
        leerCSVSimple.leerCSVSimpleConBufferedReader();
        System.out.println();

        System.out.println("Lectura de CSV Simple con Scanner");
        leerCSVSimple.leerCSVSimpleConScanner();
        System.out.println();
        System.out.println("==============================");
        System.out.println();
        System.out.println("Escritura de CSV");
        List<String[]> texto = new ArrayList<>(); //array list

        //Añadiendo texto al arrayList
        texto.add(new String[]{"Nombre Persona1", "Apellido1", "38", "Comentario adicional1"});
        texto.add(new String[]{"Nombre Persona2", "Apellido2", "18", "Comentario adicional2 "});
        escribirCSVSImple.pasarACSV(texto);
        System.out.println();
        System.out.println("Lectura y escritura XML");
        System.out.println("==============================");
        System.out.println();
        System.out.println("Lectura de XML");
        LeerXML leerXML = new LeerXML("ejemploXML.xml");
        leerXML.readCoches();
        System.out.println();
        System.out.println("Escritura de XML");
        EscribirXML escribirXML= new EscribirXML();
        escribirXML.escribirXML("archivoEscritoPorCodigoXML.xml");
        System.out.println();
        System.out.println("Grabar un nuevo objeto en un XML");
        System.out.println();
        EscribirObjetosEnXML escribirObjetosEnXML= new EscribirObjetosEnXML();
       // escribirObjetosEnXML.addCoches();
        escribirObjetosEnXML.agregarSinSobreescribir("archivoEscritoPorCodigoXML.xml");
        LeerXML leerXML2= new LeerXML("archivoEscritoPorCodigoXML.xml");
        leerXML2.readCoches();

    }
}
