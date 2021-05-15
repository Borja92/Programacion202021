package negocio;
/**
 * Clase FillToXML
 */

import persistencia.GestorXML;

public class FillToXML {
    /**
     * Objetos de la clase
     */
   private String archivo;
   private GestorXML gestorXML;

    /**
     * Constructor
     * @param archivo
     */
    public FillToXML(String archivo){
        this.archivo=archivo;
        this.gestorXML= new GestorXML(this.archivo);
    }

}
